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
"""Base class for any kind of fuzzy variable."""
__revision__ = "$Id: Variable.py,v 1.13 2009/10/07 21:08:13 rliebscher Exp $"


class Variable(object):
    """Base class for any kind of fuzzy variable.
       Returns as output the previous input value.
       
       @ivar description: Description of the fuzzy variable
       @type description: string
       @ivar min: minimum value (not strictly enforced, but useful for some external tools)
       @type min: float
       @ivar max: maximum value (not strictly enforced, but useful for some external tools)
       @type max: float
       @ivar unit: Unit of the values
       @type unit: string
       """

    def __init__(self,description='',min=0.,max=1.,unit=''):
        """
            @param description: Description of the fuzzy variable
            @type description: string
            @param min: minimum value (not strictly enforced, but useful for some external tools)
            @type min: float
            @param max: maximum value (not strictly enforced, but useful for some external tools)
            @type max: float
            @param unit: Unit of the values
            @type unit: string
        """
        self.adjectives = {}
        self.__value     = None
        self.description = description
        self.min         = min
        self.max         = max
        self.unit        = unit

    def setValue(self,value):
        """Just store the value."""
        self.__value = value

    def getValue(self):
        """Return previous input value."""
        return self.__value

    def reset(self):
        """Reset meberships of adjectives for new calculation step."""
        for adjective in self.adjectives.values():
            adjective.reset()

    def getName(self,system):
        """Lookup the name given this variable in the given system"""
        return system.findVariableName(self)
