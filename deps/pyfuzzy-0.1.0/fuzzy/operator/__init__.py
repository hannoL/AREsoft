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
"""These operators are used to build fuzzy rules.

For example:

c{(A and B) or not C}

where

 - A,B,C is an adjective of a fuzzy variable and
 - 'and'/'or' are fuzzy norms

can be modelled as::

 Compound(FuzzyOr(),
     Compound(FuzzyAnd(),
         Input(A),
         Input(B)
     ),
     Not(
         Input(C)
     )
 )
"""

__revision__ = "$Id: __init__.py,v 1.4 2009/08/07 07:19:19 rliebscher Exp $"
