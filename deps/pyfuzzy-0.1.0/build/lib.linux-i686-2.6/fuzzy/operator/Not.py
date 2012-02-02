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
"""Operator class which takes value of input operator and calculates complement of it."""
__revision__ = "$Id: Not.py,v 1.13 2009/10/07 21:08:14 rliebscher Exp $"

from fuzzy.operator.Operator import Operator

class Not(Operator):
    """Take value of input operator and calculate complement of it.
       
       @ivar input: input which result is to complement.
       @type input: L{fuzzy.operator.Operator.Operator}
    """ 

    def __init__(self, input):
        """Constructor.
        
        @param input: input which result is to complement.
        @type input: L{fuzzy.operator.Operator.Operator}
        """
        super(Not, self).__init__()
        self.input = input

    def __call__(self):
        """Get input value and return 1.0-value."""
        return 1.0 - self.input()
