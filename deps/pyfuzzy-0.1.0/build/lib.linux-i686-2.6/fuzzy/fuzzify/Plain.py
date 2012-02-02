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

__revision__ = "$Id: Plain.py,v 1.2 2009/08/07 07:19:18 rliebscher Exp $"


from fuzzy.fuzzify.Base import Base


class Plain(Base):
    """Just fuzzify the input value using the membership values of the given adjectives"""

    def __init__(self,*args,**keywords):
        super(Plain, self).__init__(*args,**keywords)

    def setValue(self,variable,value):
        """Let adjectives calculate their membership values."""
        for adjective in variable.adjectives.values():
            adjective.setMembershipForValue(value)
        return value
