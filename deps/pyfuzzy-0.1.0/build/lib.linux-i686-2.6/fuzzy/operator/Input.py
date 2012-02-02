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
"""Special operator class which gets it value from a fuzzy adjective."""
__revision__ = "$Id: Input.py,v 1.12 2009/10/07 21:08:14 rliebscher Exp $"

from fuzzy.operator.Operator import Operator

class Input(Operator):
    """Special operator which gets it value from a fuzzy adjective.
       
       @ivar adjective: from which adjective get the membership value.
       @type adjective: L{fuzzy.Adjective.Adjective}
    """

    def __init__(self,adjective):
        """Constructor.
        
        @param adjective: from which adjective get the membership value.
        @type adjective: L{fuzzy.Adjective.Adjective}
        """ 
        super(Input, self).__init__()
        self.adjective = adjective

    def __call__(self):
        """return membership of given adjective."""
        return self.adjective.getMembership()
