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
Different kind of fuzzy sets.
For any of these you can call C{set(x)} to get the membership value of x.

See L{Set<fuzzy.set.Set>} for more.

examples can be found here U{http://pyfuzzy.sourceforge.net/test/set/}


"""

__revision__ = "$Id: __init__.py,v 1.8 2009/08/07 07:19:19 rliebscher Exp $"


#def __import_classes(dir):
#    """ Import any classes in the named directory.
#        So you can simply add new classes to the directory,
#        you only have to define in each module a symbol(class)
#        of the same name as the module itself.
#
#        Similar to "from dir import *", but you dont need to specify
#        all classes in dir in __init__.py.  
#    """
#    import os,sys,imp
#    old_sys_path = sys.path
#    classes_dir = os.path.dirname(__file__) + os.sep + dir
#    suffixes = []
#    for suffix in imp.get_suffixes():
#        suffixes.append(suffix[0])
#    sys.path = [classes_dir] + sys.path
#    for class_file in os.listdir(classes_dir):
#        for suffix in suffixes:
#            class_name = class_file[:-len(suffix)]
#            if class_name == "__init__":
#                break
#            if  class_file[-len(suffix):] == suffix:
#                module = __import__(class_name) 
#                globals()[class_name] = module.__dict__[class_name]
#                break
#
#    sys.path = old_sys_path

#__import_classes(".")
