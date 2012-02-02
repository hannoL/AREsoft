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
"""Helper functions for  pyfuzzy."""
__revision__ = "$Id: utils.py,v 1.5 2009/10/07 21:08:12 rliebscher Exp $"

def prop(func):
    """Function decorator for defining property attributes
  
    The decorated function is expected to return a dictionary
    containing one or more of the following pairs:
      - fget - function for getting attribute value
      - fset - function for setting attribute value
      - fdel - function for deleting attribute
    This can be conveniently constructed by the locals() builtin
    function; see:
    U{http://aspn.activestate.com/ASPN/Cookbook/Python/Recipe/205183}
    """
    return property(doc=func.__doc__, **func())

def checkRange(value,ranges):
    """Checks if the value is in the defined range.
    
    The range definition is a list/iterator from:
        - float values belonging to the defined range M{x \in {a}}
        - 2-tuples of two floats which define a range not including the tuple values itself M{x \in ]a,b[}
        - 2-list of two floats which define a range including the list values M{x \in [a,b]}
    The order of elements is not important. So could define the set of integer numbers by a
    generator returning the following sequence: M{0,1,-1,2,-2,3-,3,...} .
    
    It returns True if the value is in one of the defined ranges.
    Otherwise it returns false.
    """
    import types
    for part in ranges:
        if isinstance(part,types.FloatType):
            if part == value:
                return True
        elif isinstance(part,types.ListType) and len(part) == 2:
            if part[0] <= value and value <= part[1]:
                return True
        elif isinstance(part,types.TupleType) and len(part) == 2:
            if part[0] < value and value < part[1]:
                return True
        else:
            raise Exception("Range definition is wrong")
    return False


inf = float("inf")
inf_p = float("+inf")
inf_n = float("-inf")
