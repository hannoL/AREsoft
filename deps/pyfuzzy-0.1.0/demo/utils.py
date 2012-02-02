#!/usr/bin/env python
# -*- coding: iso-8859-1 -*-
#
"""\
# Helper utilities for tests.
#  - Find all classes in directory and return creates instances of them.
#  - Get lists of values to use for show-off of parametric classes 
#    depending on the allowed range of the parameters there
"""
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


__revision__ = "$Id: utils.py,v 1.6 2009/09/28 15:26:46 rliebscher Exp $"

def get_classes(package):
    """Find all classes defined in given directory
    and return them as dictionary {name,instance}"""
    import os,imp
    package_name = package.__name__
    classes_dir = os.path.dirname(package.__file__)
    suffixes = [suffix[0] for suffix in imp.get_suffixes()]
    objects = {}
    for class_file in os.listdir(classes_dir):
        for suffix in suffixes:
            class_name = class_file[:-len(suffix)]
            if class_name == "__init__":
                break
            if  class_file[-len(suffix):] == suffix:
                module = __import__(package_name+"."+class_name)
                components = (package_name+"."+class_name).split('.')
                for comp in components[1:]:
                    module = getattr(module, comp)
                try:
                    objects.update({class_name: module.__dict__[class_name]()})
                except:
                    # probably no object with this name in file
                    pass
                break
    return objects


from fuzzy.utils import inf_p,inf_n

# possible parameter values for some allowed ranges of this parameter
# tuples of ( allowed_range, list_of_values ) 
__params = (
    ( [[0.,1.]]     , [0.0,0.25,0.50,0.75,1.] ),
    ( [(0.,1.)]     , [0.05,0.25,0.50,0.75,0.95] ),
    ( [(0.,inf_p)]  , [0.01,0.10,1.0,10.,100.] ),
    ( [(-1.,inf_p)] , [-0.99,-0.1,0.0,0.10,1.0,10.,100.] ),
    ( [(inf_n,-1.),(-1.,inf_p)] , [-100.,-10,-0.99,0.0,1.0,10.,100.] ),
    ( [(0.,1.),(1.,inf_p)] , [0.1,0.9,1.1,10.,100.] ),
    ( [(inf_n,0.),(0.,inf_p)] , [-100.,-10,-1.,-0.1,0.1,1.,10.,100.] )
)

def get_test_params(range_):
    """Get a list of usable values depending of the allowed range for them."""
    for p in __params:
        if p[0] == range_:
            return p[1]
    raise Exception("No params for range %s defined." % repr(range_))
