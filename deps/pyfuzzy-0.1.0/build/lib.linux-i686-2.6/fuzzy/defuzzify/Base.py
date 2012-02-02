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

__revision__ = "$Id: Base.py,v 1.7 2009/08/07 07:19:18 rliebscher Exp $"


from fuzzy.norm.Max import Max
from fuzzy.norm.Min import Min
from fuzzy.set.Set import norm,merge
import fuzzy.Exception

class DefuzzificationException(fuzzy.Exception.Exception):
    pass

class Base(object):
    """Abstract base class for defuzzification
       which results in a numeric value.
       
        @ivar INF: inference norm, used with set of adjective and given value for it
        @type INF: L{fuzzy.norm.Norm.Norm}
        @ivar ACC: norm for accumulation of set of adjectives
        @type ACC: L{fuzzy.norm.Norm.Norm}
        @cvar _INF: default value when INF is None
        @type _INF: L{fuzzy.norm.Norm.Norm}
        @cvar _ACC: default value when ACC is None
        @type _ACC: L{fuzzy.norm.Norm.Norm}
        @ivar activated_sets: results of activation of adjectives of variable.
        @type activated_sets: {string:L{fuzzy.set.Polygon.Polygon}}
        @ivar accumulated_set: result of accumulation of activated sets
        @type accumulated_set: L{fuzzy.set.Polygon.Polygon}
       """

    # default values if instance values are not set 
    _INF = Min()
    _ACC = Max()

    def __init__(self, INF=None, ACC=None):
        """
        @param INF: inference norm, used with set of adjective and given value for it
        @type INF: L{fuzzy.norm.Norm.Norm}
        @param ACC: norm for accumulation of set of adjectives
        @type ACC: L{fuzzy.norm.Norm.Norm}
        """
        self.ACC = ACC # accumulation
        self.INF = INF # inference
        self.activated_sets = {}
        self.accumulated_set = None

    def getValue(self,variable):
        """Defuzzyfication."""
        raise DefuzzificationException("don't use the abstract base class")

# helper methods for sub classes

    def accumulate(self,variable,segment_size=None):
        """combining adjective values into one set"""
        self.activated_sets = {}
        temp = None
        for name,adjective in variable.adjectives.items():
            # get precomputed adjective set
            temp2 = norm((self.INF or self._INF),adjective.set,adjective.getMembership(),segment_size)
            self.activated_sets[name] = temp2
            # accumulate all adjectives
            if temp is None:
                temp = temp2
            else:
                temp = merge((self.ACC or self._ACC),temp,temp2,segment_size)
        self.accumulated_set = temp
        return temp

    def value_table(self,set):
        """get a value table of the polygon representation"""
        # get polygon representation
        ig = set.getIntervalGenerator()
        next = ig.nextInterval(None,None)
        while next is not None:
            x = next
            y = set(x)
            yield (x,y)
            # get next point from polygon
            next = ig.nextInterval(next,None)
