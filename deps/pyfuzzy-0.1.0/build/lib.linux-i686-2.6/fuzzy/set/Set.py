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

"""
Base class for all fuzzy sets.
"""

__revision__ = "$Id: Set.py,v 1.17 2009/08/07 07:19:19 rliebscher Exp $"

class Set(object):
    """Base class for all types of fuzzy sets."""

    def __call__(self,x):
        """Return membership of x in this fuzzy set.
           This method makes the set work like a function.
           
           @param x: value x
           @type x: float
           @return: membership for value x
           @rtype: float
           """
        return 0.

    class IntervalGenerator(object):
        def nextInterval(self,prev,next):
            """For conversion of any set to a polygon representation.
               Return which end value should have the interval started
               by prev. (next is the current proposal.)
               The membership function has to be monotonic in this interval.
               (eg. no minima or maxima)
               To find left start point prev is None.
               If no further splitting at right necessary return None."""
            return next

    def getIntervalGenerator(self):
        """Internal helper function to help convert arbitrary fuzzy sets in 
        fuzzy sets represented by a polygon."""
        return self.IntervalGenerator()

    def getCOG(self):
        """Returns center of gravity.
           
           @return: x-value of center of gravity
           @rtype: float
           """
        #raise Exception("abtract class %s has no center of gravity." % self.__class__.__name__)
        return 0. # XXX



# too make old code happy
from fuzzy.set.operations import norm,merge