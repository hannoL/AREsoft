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

__revision__ = "$Id: Dict.py,v 1.6 2009/08/31 21:02:06 rliebscher Exp $"

from fuzzy.defuzzify.Base import Base

class Dict(Base):
    """Not a real defuzzyfication.
       Just stores the adjective memberships
       in a dictionary for output.
       You should use in the adjectives instances of Set itself.
       
       What can be done with this?
       
       For example:
       
       You want help with buying a car.
       
       Input are your preferences::
        speed, payload (1-10), ...
       (map to "very important, important, doesn't matter, not wanted, never" ;-)
       
       Output are choices:
       cars with adjectives: ferrari, truck, ...
       
       rules are as follows::
        if speed->very_important && payload->never then car->ferrari
        if payload->very_important then car->truck
       ... and so on
       
       Then you use this as follows::
        input variables 
        { speed:3, payload:1, ...} 
        ==> 
        output_variables
        { car: {
                 ferrari:0.1,
                 truck: 1.0,
                 ...
               }
        }
       """
    def __init__(self,*args,**keywords):
        super(Dict,self).__init__(*args,**keywords)

    def getValue(self,variable):
        """no defuzzification just return membership values"""
        temp = {}
        for name,adjective in variable.adjectives.items():
            # get precomputed adjective set membership
            temp[name] = adjective.getMembership()
        return temp
