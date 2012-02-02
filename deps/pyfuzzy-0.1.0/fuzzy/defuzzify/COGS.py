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

__revision__ = "$Id: COGS.py,v 1.4 2009/08/07 07:19:18 rliebscher Exp $"

from fuzzy.defuzzify.Base import Base,DefuzzificationException
import fuzzy.set.Singleton

class COGS(Base):
    """defuzzification for singletons."""

    def __init__(self, INF=None, ACC=None, failsafe=None,*args,**keywords):
        """
            @param failsafe: if is not possible to calculate a center of gravity,
            return this value if not None or forward the exception
        """
        super(COGS, self).__init__(INF,ACC,*args,**keywords)
        self.failsafe = failsafe # which value if COG not calculable

    def getValue(self,variable):
        """Defuzzyfication using center of gravity method."""
        sum_1,sum_2 = 0.,0.
        for adjective in variable.adjectives.values():
            # get precomputed adjective set
            set = adjective.set
            if not isinstance(set,fuzzy.set.Singleton.Singleton):
                raise DefuzzificationException("Only Singleton for COGS defuzzification allowed.")
            a = (self.INF or self._INF)(set(set.x),adjective.getMembership())
            sum_1 += set.x*a
            sum_2 += a
        try:
            if sum_2 == 0.:
                raise DefuzzificationException("No result, all singletons set to 0.")
            return sum_1/sum_2
        except:
            # was not to calculate
            if self.failsafe is not None:
                # user gave us a value to return
                return self.failsafe
            else:
                # forward exception
                raise
