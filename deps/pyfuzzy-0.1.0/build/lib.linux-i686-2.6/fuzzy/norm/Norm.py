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
    Abstract base class for any kind of fuzzy norm.
"""

__revision__ = "$Id: Norm.py,v 1.11 2009/08/07 07:19:19 rliebscher Exp $"

from fuzzy.Exception import Exception
class NormException(Exception):
    """Base class for any exception in norm calculations."""
    pass


class Norm(object):
    """Abstract Base class of any fuzzy norm"""

    # types of norm
    UNKNOWN = 0 #: type of norm unknown
    T_NORM = 1 #: norm is t-norm
    S_NORM = 2 #: norm is s-norm

    def __init__(self,type=0):
        """Initialize type of norm"""
        self._type = type

    def __call__(self,*args):
        """
            Calculate result of norm(arg1,arg2,...)
        
            @param args: list of floats as arguments for norm.
            @type args: list of float
            @return: result of norm calulation
            @rtype: float
            @raise NormException: any problem in calculation (wrong number of arguments, numerical problems)
        """
        raise NormException("abstract class %s can't be called" % self.__class__.__name__)

    def getType(self):
        """
            Return type of norm:
            0 = not defined or not classified
            1 = t-norm ( = Norm.T_NORM)
            2 = s-norm ( = Norm.S_NORM)

        """
        return self._type


def product(*args):
    """Calculate product of args.

    @param args: list of floats to multiply
    @type args: list of float
    @return: product of args
    @rtype: float
    """
    r = args[0]
    for x in args[1:]:
        r *= x
    return r


def sum(*args):
    """Calculate sum of args.
    
    If using numpy the builtin sum doesn't work always!

    @param args: list of floats to sum
    @type args: list of float
    @return: sum of args
    @rtype: float
    """
    r = args[0]
    for x in args[1:]:
        r += x
    return r
