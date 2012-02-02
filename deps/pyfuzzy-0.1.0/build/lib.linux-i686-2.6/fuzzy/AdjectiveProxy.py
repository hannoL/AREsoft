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
"""Serves as proxy for a named variable.adjective."""
__revision__ = "$Id: AdjectiveProxy.py,v 1.10 2009/10/07 21:08:13 rliebscher Exp $"


class AdjectiveProxy(object):
    """Serves as proxy for the named variable.adjective in system.
    
    @deprecated: such objects have problems using pickle
    """

    def __init__(self,system,variable,adjective):
        self.proxy_system = system
        self.proxy_variable = variable
        self.proxy_adjective = adjective

    def __getattr__(self,name):
        """Return attribute value from real adjective."""
        if name in ["proxy_variable","proxy_adjective","proxy_system"]:
            return self.__dict__[name]
        else:
            variable = self.__dict__["proxy_variable"]
            adjective = self.__dict__["proxy_adjective"]
            system = self.__dict__["proxy_system"]
            return getattr(system.variables[variable].adjectives[adjective],name)

    def __setattr__(self,name,value):
        """Set attribute value in real adjective."""
        if name in ["proxy_variable","proxy_adjective","proxy_system"]:
            self.__dict__[name] = value
        else:
            variable = self.__dict__["proxy_variable"]
            adjective = self.__dict__["proxy_adjective"]
            system = self.__dict__["proxy_system"]
            setattr(system.variables[variable].adjectives[adjective],name,value)

    def getName(self,system):
        """Find own name in given system.
        Returns a tuple (var_name,adj_name) of None."""
        if system is self.proxy_system:
            return [self.proxy_adjective,self.proxy_variable]
        import fuzzy.Exception
        raise fuzzy.Exception.Exception()
