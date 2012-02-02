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

__revision__ = "$Id: Triangle.py,v 1.13 2009/08/07 07:19:19 rliebscher Exp $"


from fuzzy.set.Polygon import Polygon
from fuzzy.utils import prop

class Triangle(Polygon):
    r"""Realize a triangle-shaped fuzzy set::
              ______  y_max
              A
             /|\
            / | \
           /  |  \
         _/   |   \_  y_min
          |   m   |
          |   |   |
         alpha|beta

    See also U{http://pyfuzzy.sourceforge.net/test/set/Triangle.png}
    """

    def __init__(self,m=0.0,alpha=1.0,beta=1.0,y_max=1.0,y_min=0.0):
        """
        Initialize a triangle-shaped fuzzy set.

        @param y_max:  y-value at top of the triangle (1.0)
        @param y_min:  y-value outside the triangle (0.0)
        @param m:      x-value of top of triangle (0.0)
        @param alpha:  distance of left corner to m (1.0)
        @param beta:   distance of right corner to m (1.0)
        """
        super(Triangle, self).__init__()
        self._y_max = y_max
        self._y_min = y_min
        self._m = m
        self._alpha = alpha
        self._beta = beta
        self._update() # update polygon

    @prop
    def y_max():
        """y-value at top of the triangle
        @type: float"""
        def fget(self):
            return self._y_max
        def fset(self,value):
            self._y_max = value
            self._update()
        return locals()

    @prop
    def y_min():
        """y-value outside the triangle
        @type: float"""
        def fget(self):
            return self._y_min
        def fset(self,value):
            self._y_min = value
            self._update()
        return locals()

    @prop
    def m():
        """x-value of top of triangle
        @type: float"""
        def fget(self):
            return self._m
        def fset(self,value):
            self._m = value
            self._update()
        return locals()

    @prop
    def alpha():
        """distance of left corner to m
        @type: float"""
        def fget(self):
            return self._alpha
        def fset(self,value):
            self._alpha = value
            self._update()
        return locals()

    @prop
    def beta():
        """distance of right corner to m
        @type: float"""
        def fget(self):
            return self._beta
        def fset(self,value):
            self._beta = value
            self._update()
        return locals()

    def _update(self):
        """update polygon"""
        p = super(Triangle, self)
        p.clear()
        p.add(self._m-self._alpha,self._y_min)
        p.add(self._m,self._y_max)
        p.add(self._m+self._beta,self._y_min)

    def add(self,x,y,where=Polygon.END):
        """Don't let anyone destroy our triangle."""
        raise Exception()

    def remove(self,x,where=Polygon.END):
        """Don't let anyone destroy our triangle."""
        raise Exception()

    def clear(self):
        """Don't let anyone destroy our triangle."""
        raise Exception()

