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
"""General instance of an input variable.""" 
__revision__ = "$Id: InputVariable.py,v 1.6 2009/10/07 21:08:13 rliebscher Exp $"

from fuzzy.Variable import Variable

class InputVariable(Variable):
    """General instance of an input variable 
        The fuzzification is provided by special object for this purpose,
        set as fuzzify param.
        Also marker, so you can check if any variable is an (instance of) input variable 

        @ivar fuzzify: Fuzzification method.
        @type fuzzify: L{fuzzy.fuzzify.Base.Base}
       """

    def __init__(self,fuzzify=None,*args,**keywords):
        """Initialize this input variable with a fuzzification method.

        @param fuzzify: Fuzzification method.
        @type fuzzify: L{fuzzy.fuzzify.Base.Base}
        """
        super(InputVariable, self).__init__(*args,**keywords)
        self.fuzzify = fuzzify

    def setValue(self,value):
        """Let adjectives calculate their membership values."""
        self.__value = self.fuzzify.setValue(self,value)

