# -*- coding: iso-8859-1 -*-
#
# Copyright (C) 2009  Rene Liebscher
#
# This program is free software; you can redistribute it and/or modify it under
# the terms of the GNU Lesser General Public License as published by the Free 
# Software Foundation; either version 3 of the License, or (at your option) any
# later version.
#
# This program is distributed in the hope that it will be useful, but WITHOUT 
# ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
# FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more details.
# 
# You should have received a copy of the GNU Lesser General Public License along with 
# this program; if not, see <http://www.gnu.org/licenses/>. 
#

__revision__ = "$Id: Polygon.py,v 1.18 2009/08/31 21:02:06 rliebscher Exp $"


from fuzzy.set.Set import Set
from fuzzy.utils import prop

class Polygon(Set):
    r"""Represents a fuzzy set, which membership function
       is the shape of a polygon. For example: triangle,
       trapezoid, rectangle, or something similar.

       If you need something similar to ZFunction or SFunction, 
       use this class directly by building it from two points.::

          ---*                     *---
              \                   /
               \        OR       /
                \               /
                 *---       ---*

       See also U{http://pyfuzzy.sourceforge.net/test/set/Polygon%20(Demo).png}

       """

    # indices for coordinate tuple
    X = 0 #: index of x value in tuple
    Y = 1 #: index of y value in tuple

    def __init__(self,points=[]):
        """Initialize with given sorted list of (x,y) values
        
        @param points: sorted list of 2-tuples of (x,y) values
        @type points: list of 2-tuples (float,float)
        """
        super(Polygon, self).__init__()
        import copy
        self.__points = copy.deepcopy(points)

    def __call__(self,x):
        """Get membership of value x."""
        p = self.__points

        # first handle obvious cases
        if p == []:
            return 0.0
        if len(p) == 1:
            return p[0][Polygon.Y]
        if x < p[0][Polygon.X]:
            return p[0][Polygon.Y]
        if x > p[-1][Polygon.X]:
            return p[-1][Polygon.Y]

        x0 = p[0][Polygon.X]
        for i in range(1,len(p)):
            x1 = p[i][Polygon.X]
            # found right interval border
            if x1 < x:
                x0 = x1
                continue
            # if we want a x values which is a polygon point ...
            if x1 == x:
                y = p[i][Polygon.Y]
                # ... check following points for same x-value ...
                for j in range(i+1,len(p)):
                    if p[j][Polygon.X] > x:
                        break
                    else:
                        # ... and use the maximum value
                        y_ = p[j][Polygon.Y]
                        if y_ > y:
                            y = y_
                return y
            y0 = p[i-1][Polygon.Y]
            y1 = p[i][Polygon.Y]
            # interpolate value in interval
            if x1 == x0: # should never happen
                return max(y0,y1)
            return y0+(y1-y0)/(x1-x0)*(x-x0)
        return 0.0 # should never be reached

    # at which end do we insert or remove a point
    BEGIN = 0
    END = 1

    def add(self,x,y,where=END):
        r"""Add a new point to the polygon.
           The parameter where controls at which end
           it is inserted. (The points are always sorted, but
           if two have the same x value their order is important.
           For example: adding a second point(y=0) in the middle::
            now           where=END        where=BEGIN
            *--*           *--*             *  *
                \             |              \ |\
                 \            |               \| \
                  *           *--*             *  *
        """
        # quick and dirty implementation
        if where == self.END:
            self.__points.append((x,y))
        else:
            self.__points.insert(0,(x,y))
        # use only x value for sorting
        self.__points.sort(key = lambda p:p[Polygon.X])


    def remove(self,x,where=END):
        r"""Remove a point from the polygon.
           The parameter where controls at which end
           it is removed. (The points are always sorted, but
           if two have the same x value their order is important.
           For example: removing the second point in the middle::
            now           where=END        where=BEGIN
            *--*           *--*             *
               |               \             \
               |                \             \
               *--*              *             *--*
        """
        # quick and dirty implementation
        range_p = range(len(self.__points))
        if where == self.END:
            range_p.reverse()
        for i in range_p:
            if self.__points[i][Polygon.X] == x:
                self.__points.remove(i)
                return
        #raise Exception("Not in points list")

    def clear(self):
        """Reset polygon to zero."""
        del self.__points[:]

    @prop
    def points():
        """points of the polygon.
        @type: list of 2-tuple (x,y)"""
        def fget(self):
            import copy
            return copy.deepcopy(self.__points)
        return locals()


    def getIntervalGenerator(self):
        return self.__IntervalGenerator(self.__points)

    class __IntervalGenerator(Set.IntervalGenerator):
        def __init__(self,points):
            self.__points = points
            self.index = 0

        def nextInterval(self,prev,next):
            l = len(self.__points)
            if l == 0 or self.index >= l:
                return next
            if prev is None:
                self.index = 0
            else:
                if prev == self.__points[self.index][Polygon.X]:
                    self.index = self.index + 1
                if self.index >= l:
                    return next
            if next is None:
                return self.__points[self.index][Polygon.X]
            else:
                return min(next,self.__points[self.index][Polygon.X])

    def getCOG(self):
        """Return center of gravity."""
        if len(self.__points) <=1 :
            #return 0.0
            raise Exception("no COG calculable: single point = constant value")
        if self.__points[0][Polygon.Y] > 0 or self.__points[-1][Polygon.Y] > 0:
            raise Exception("no COG calculable: end points of polygon not y=0.0")
        area = 0.
        COG = 0.
        iterator = iter(self.__points)
        x0,y0 = iterator.next()
        x0_2 = x0*x0  # =x²
        x0_3 = x0_2*x0  # =x³
        for x1,y1 in iterator:
            if x1 != x0: # vertical slopes don't have an area to x.axis
                x1_2 = x1*x1
                x1_3 = x1_2*x1
                area += (y0+y1)/2.0*(x1-x0) # area of trapez
                # Integral( x*f(x) ) 
                COG += y0/2.0*(x1_2-x0_2)+(y1-y0)/(x1-x0)*(x1_3/3.0-x0_3/3.0-x1_2*x0/2.0+x0_3/2.0)
                x0,x0_2,x0_3 = x1,x1_2,x1_3
            y0 = y1
        if area == 0.0:
            raise Exception("no COG calculable: polygon area is zero!")
        COG /= area
        return COG # XXX
