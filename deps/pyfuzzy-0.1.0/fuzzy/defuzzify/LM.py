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

__revision__ = "$Id: LM.py,v 1.2 2009/08/07 07:19:18 rliebscher Exp $"

from fuzzy.defuzzify.Base import Base,DefuzzificationException

class LM(Base):
    """Defuzzyfication which uses the left most (local) maximum."""

    def __init__(self, INF=None, ACC=None, failsafe=None,*args,**keywords):
        """Initialize the defuzzification method with INF,ACC 
        and an optional value in case defuzzification is not possible"""
        super(LM, self).__init__(INF,ACC,*args,**keywords)
        self.failsafe = failsafe # which value if value not calculable

    def getValue(self,variable):
        """Defuzzyfication."""
        try:
            temp = self.accumulate(variable)

            # get polygon representation
            table = list(self.value_table(temp))

            if len(table) == 0:
                raise DefuzzificationException("no value calculable: complete undefined set")

            y = table[0][1]
            x = float('-inf') # left end of polygon is always -infinity

            for (x_,y_) in table[1:]:
                if y_ > y:
                    y = y_
                    x = x_
                else:
                    break

            return x
        except:
            # was not to calculate
            if self.failsafe is not None:
                # user gave us a value to return
                return self.failsafe
            else:
                raise
