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

__revision__ = "$Id: SFunction.py,v 1.14 2009/08/31 21:02:06 rliebscher Exp $"


from fuzzy.set.Function import Function

class SFunction(Function):
    r"""
    Realize a S-shaped fuzzy set::
                 __
                /|
               / |
              /| |
            _/ | |
             | a |
             |   |
             delta

    See also U{http://pyfuzzy.sourceforge.net/test/set/SFunction.png}
    
    @ivar a: center of set.
    @type a: float
    @ivar delta: absolute distance between x-values for minimum and maximum.
    @type delta: float
    """

    def __init__(self,a=0.0,delta=1.0):
        """Initialize a S-shaped fuzzy set.

        @param a: center of set
        @type a: float
        @param delta: absolute distance between x-values for minimum and maximum
        @type delta: float
        """
        super(SFunction, self).__init__()
        self.a = a
        self.delta = delta

    def __call__(self,x):
        """Return membership of x in this fuzzy set.
           This method makes the set work like a function.
           
           @param x: value for which the membership is to calculate
           @type x: float
           @return: membership
           @rtype: float
           """
        a = self.a
        d = self.delta
        if x <= a-d:
            return 0.0
        if x <= a:
            t = (x-a+d)/(2.0*d)
            return 2.0*t*t
        if x <= a+d:
            t = (a-x+d)/(2.0*d)
            return 1.0-2.0*t*t
        return 1.0

    def getCOG(self):
        """Return center of gravity."""
        raise Exception("COG of SFunction uncalculable")

    class __IntervalGenerator(Function.IntervalGenerator):
        def __init__(self,set):
            self.set = set

        def nextInterval(self,prev,next):
            a = self.set.a
            d = self.set.delta
            if prev is None:
                if next is None:
                    return a-d
                else:
                    return min(next,a-d)
            else:
                # right of our area of interest
                if prev >= a+d:
                    return next
                else:
                    # maximal interval length
                    stepsize = 2.0*d/Function._resolution
                    if next is None:
                        return min(a+d,prev + stepsize)
                    else:
                        if next - prev > stepsize:
                            # split interval in n equal sized interval of length < stepsize
                            return min(a+d,prev+(next-prev)/(int((next-prev)/stepsize)+1.0))
                        else:
                            return next

    def getIntervalGenerator(self):
        return self.__IntervalGenerator(self)
