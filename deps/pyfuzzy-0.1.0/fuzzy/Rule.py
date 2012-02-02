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
"""Represents a fuzzy rule."""
__revision__ = "$Id: Rule.py,v 1.13 2009/10/07 21:08:13 rliebscher Exp $"

from fuzzy.norm.Min import Min

class Rule(object):
    """This is realizes an important part of the inference engine.
       It represents and calculates the value of a fuzzy rule
       and sets the given adjective to the appropriate value.

       @cvar _CER: the default value (=Min()) for the norm used to calculate the certainty of a rule.
       @type _CER: L{fuzzy.norm.Norm.Norm}
       @ivar adjective: fuzzy adjective to set
       @type adjective: L{fuzzy.Adjective.Adjective}
       @ivar operator: Operator which provides the value to set
       @type operator: L{fuzzy.operator.Operator.Operator}
       @ivar certainty: how sure are we about this rule
       @type certainty: float
       @ivar CER: fuzzy norm to use with certainty (normally a t-norm)
       @type CER: L{fuzzy.norm.Norm.Norm}
    """

    # default if not set in instance
    _CER = Min()

    def __init__(self,adjective,operator,certainty=1.0,CER=None):
        """Initialize instance.
           @param adjective: fuzzy adjective to set
           @type adjective: L{fuzzy.Adjective.Adjective}
           @param operator: Operator which provides the value to set
           @type operator: L{fuzzy.operator.Operator.Operator}
           @param certainty: how sure are we about this rule
           @type certainty: float
           @param CER: fuzzy norm to use with certainty (normally a t-norm)
           @type CER: L{fuzzy.norm.Norm.Norm}
        """

        self.adjective = adjective
        self.operator = operator
        self.certainty = certainty
        self.CER = CER

    def compute(self):
        """Compute and set value for given fuzzy adjective."""

        import fuzzy.Adjective
        if isinstance(self.adjective,fuzzy.Adjective.Adjective):
            self.adjective.setMembership(
                                    (self.CER or self._CER)(
                                        self.certainty,       # how sure are we about this rule
                                        self.operator() # value from input
                                    )
                                )
        elif isinstance(self.adjective,list):
            for adj in self.adjective:
                adj.setMembership(
                                    (self.CER or self._CER)(
                                        self.certainty,       # how sure are we about this rule
                                        self.operator() # value from input
                                    )
                                )
        else:
            raise Exception("rule target not set.")

    def getName(self,system):
        """Lookup the name given this rule in the given system"""
        return system.findRuleName(self)
