#!/usr/bin/env python
# -*- coding: iso-8859-1 -*-
#
"""\
# Runs all defuzzification methods over (default) instances of all 
# fuzzy set classes and some additional examples to check the results
# you get.
# This is not an automatic test. You have to check the results by yourself.
"""
#
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

__revision__ = "$Id: demo_defuzzyfication.py,v 1.13 2009/09/28 06:52:12 rliebscher Exp $"

import sys, os
sys.path.insert(0, os.path.join(os.path.abspath(os.path.dirname(sys.argv[0])),os.path.pardir))

from utils import get_classes

def test():
    """test all found set classes with defuzzyfication method in specific kind
       of output variable class"""
    import types
    import fuzzy.set
    import fuzzy.defuzzify
    import fuzzy.OutputVariable
    import fuzzy.Adjective
    import fuzzy.set.Polygon

    # sizes of rows
    row1 = 10
    row2 = 25

    sets = get_classes(fuzzy.set)
    # Add tests of a special sets.
    sets["""~
        _
    _  / \  _
___/ \/   \/ \___
"""] = fuzzy.set.Polygon.Polygon([(-2,0),(-1.5,0.5),(-1.,0.5),(-0.5,0.0),(-0.25,1.),(0.25,1.),(0.5,0.0),(1.,0.5),(1.5,0.5),(2,0)])
    sets["""~
      ___
___  /
   \/
"""] = fuzzy.set.Polygon.Polygon([(-1,0.5),(0.,0.),(1.,1.)])
    sets["""~
__
  \  ___
   \/
"""] = fuzzy.set.Polygon.Polygon([(-1,1.0),(0.,0.),(1.,0.5)])
    defuzzy = get_classes(fuzzy.defuzzify)

    for o in sorted(sets):
        set = sets[o]
        # filter out classes without default values
        if o in ["Set","Function","Polygon"]:
            continue

        print "Defuzzification of %s:" % o
        print "%-*s | %s" % (row1,"method","value")
        print "%s-+-%s" % ("-"*row1,"-"*row2)

        for d in sorted(defuzzy):
            defuzzy_ = defuzzy[d]
            # filter out abstract base classes
            if d in ["Base"]:
                continue

            v = fuzzy.OutputVariable.OutputVariable(defuzzify=defuzzy_)

            try:
                a = fuzzy.Adjective.Adjective(set)
                a.setMembership(1.0)
                v.adjectives["test"] = a
                result = v.getValue()
                if isinstance(result,types.FloatType):
                    result = "%.3g" % result
                else:
                    result = str(result)
                print "%-*s | %s" % (row1,d,result) 
            except:
                print "%-*s |         >>> %s <<<" % (row1,d,sys.exc_info()[1])
        print

# when executed, just run test():
if __name__ == '__main__':
    test()

