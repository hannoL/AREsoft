#!/usr/bin/env python
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

__revision__ = "$Id: Reader.py,v 1.3 2009/08/31 21:02:06 rliebscher Exp $"

import antlr3

from FCLLexer import FCLLexer
from FCLParser import FCLParser

class Reader(object):
    """Parses a FCL file to a fuzzy.System.System instance"""

    def __init__(self):
        pass

    def __load(self,char_stream):
        lexer = FCLLexer(char_stream)
        tokens = antlr3.CommonTokenStream(lexer)
        parser = FCLParser(tokens)
        return parser.main()

    def load_from_file(self,filename):
        return self.__load(antlr3.ANTLRFileStream(filename))

    def load_from_stream(self,stream):
        return self.__load(antlr3.ANTLRInputStream(stream))

    def load_from_string(self,str):
        return self.__load(antlr3.ANTLRStringStream(str))

