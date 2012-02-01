#!/usr/bin/env python
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
"""pyfuzzy: Python Fuzzy Utilities

pyfuzzy is a python module for working with fuzzy sets 
(for example for controllers or other similar stuff, 
it can be also used for decision making in business.)
"""
__revision__ = "$Id: setup.py,v 1.13 2009/10/07 21:08:14 rliebscher Exp $"

from distutils.core import setup

DOCLINES = __doc__.split("\n")

CLASSIFIERS = """\
Development Status :: 4 - Beta
Intended Audience :: Science/Research
Intended Audience :: Developers
License :: OSI Approved :: GNU Library or Lesser General Public License (LGPL)
Programming Language :: Python
Topic :: Software Development :: Libraries :: Python Modules
Topic :: Scientific/Engineering
Operating System :: OS Independent
"""

PACKAGES = [
        'fuzzy',
        'fuzzy.set',
        'fuzzy.operator',
        'fuzzy.norm',
        'fuzzy.complement',
        'fuzzy.fuzzify',
        'fuzzy.defuzzify',
        'fuzzy.storage',
        'fuzzy.doc',
        'fuzzy.doc.plot',
        'fuzzy.doc.plot.gnuplot',
        'fuzzy.doc.structure',
        'fuzzy.doc.structure.dot',
        ]

try:
    import antlr3
    PACKAGES.extend([
            'fuzzy.storage.fcl',
            ])
except:
    print """\
Sorry, without the python runtime of ANTLR3, there will be
no reading of FCL files.
"""

if __name__ == "__main__":
    setup (name = "pyfuzzy",
       version = "0.1.0",
       description = DOCLINES[0],
       author = "Rene Liebscher",
       author_email = "R.Liebscher@gmx.de",
       maintainer = "Rene Liebscher",
       maintainer_email = 'R.Liebscher@gmx.de',
       url = "http://pyfuzzy.sourceforge.net",
       download_url = "http://sourceforge.net/project/showfiles.php?group_id=59160&package_id=55171",
       license = "LGPL+",
       long_description = "\n".join(DOCLINES[2:]),
       classifiers=CLASSIFIERS.split('\n'),
       platforms = ["OS Independent"],
       packages = PACKAGES,
      )
