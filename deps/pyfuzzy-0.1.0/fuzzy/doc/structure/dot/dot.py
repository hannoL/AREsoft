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

"""Generates description of structure in dot format"""

__revision__ = "$Id: dot.py,v 1.4 2009/08/07 07:19:18 rliebscher Exp $"

# stores handler of different object types
_registered_handler = {}

def register_handler(class_, handler):
    _registered_handler[class_] = handler


def print_dot(obj,out,system,parentname):
    """Print object obj into output stream out"""
    for class_ in type(obj).mro():
        if class_ in _registered_handler.keys():
            handler = _registered_handler[class_]
            return handler(obj,out,system,parentname)
    return ""

def printVariablesDot(system,out):
    """Print all variables"""
    for name,variable in system.variables.items():
        print_dot(variable,out,system,name)

def printRulesDot(system,out):
    """Print all rules"""
    for name,rule in system.rules.items():
        print_dot(rule,out,system,name)

def printDot(system,out):
    """Print whole system into one graph"""
    print_header(out)
    #printVariablesDot(system,out)
    printRulesDot(system,out)
    print_footer(out)

def print_header(out,name="System"):
    """Print graph header"""
    out.write("digraph %s {graph [rankdir = \"LR\"];\n" % name)

def print_footer(out):
    """Print graph footer"""
    out.write("}\n")

# import handlers for object types
import fuzzy.doc.structure.dot.handlers
