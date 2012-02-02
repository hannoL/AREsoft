#!/usr/bin/env python
# -*- coding: iso-8859-1 -*-
#
"""\
# Generate plots of all available fuzzy set classes using their default values
# after processing with all available fuzzy complement classes.
# The result are some images, which you have to check by yourself.
# (They are also useful to put on the website.)
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

__revision__ = "$Id: demo_complement.py,v 1.6 2009/10/18 19:44:46 rliebscher Exp $"

import sys, os
sys.path.insert(0, os.path.join(os.path.abspath(os.path.dirname(sys.argv[0])),os.path.pardir))

try:
    # If the package has been installed correctly, this should work:
    import Gnuplot, Gnuplot.funcutils
except ImportError:
    print "Sorry, you need Gnuplot.py (http://gnuplot-py.sourceforge.net) to use this."
    sys.exit(1)

from utils import get_classes, get_test_params
import string

x_min,x_max = -1.5,+1.5

def getGnuplot():
    """Get a preconfigured Gnuplot instance for plotting."""
    # A straightforward use of gnuplot.  The `debug=1' switch is used
    # in these examples so that the commands that are sent to gnuplot
    # are also output on stderr.
    g = Gnuplot.Gnuplot(debug=0)
    g(' set style fill solid 0.5 border')
    g('set style data filledcurves y1=0')
    g('set noautoscale xy')
    g('set xrange [%f:%f]' % (x_min,x_max))
    g('set yrange [-0.2:1.2]')
    g.xlabel('x')
    g.ylabel('y')
    return g

def plot(c,set,title,filename,gnuplot=None,interactive=False):
    """Demonstrate a complement plot"""
    import fuzzy.set.operations

    steps = 50
    # make array in range x_min,x_max
    x = [ i*(x_max-x_min)/float(steps) + x_min for i in range(steps) ]

    set_c = fuzzy.set.operations.complement(c,set)

    g = gnuplot or getGnuplot()
    g.title(title)

    print "Plot %s ... " % title
    if interactive == False:
        g("set terminal png small truecolor nocrop")
        g("set output 'complement/%s.png'" % filename)
    if isinstance(set_c,fuzzy.set.Polygon.Polygon):
        p = set_c.points
        if len(p) == 0:
            raise Exception("Polygon with 0 points found.")
        if p[0][0] > x_min:
            p.insert(0,(x_min,p[0][1]))
        if p[-1][0] < x_max:
            p.append((x_max,p[-1][1]))
        g.plot(p)
    else:
        g.plot(Gnuplot.funcutils.compute_Data(x,set_c))
    if interactive == True:
        raw_input('Please press return to continue...\n')
    if gnuplot is None:
        g.close()
    g = None


def plotComplement(c,name,s,name2,params=None,gnuplot=None,interactive=False):
    """Plot a given complement with the given set, using the names for the title/filename.
    For parametric complements, it uses several values of the parameter.
    These values depend on the valid range of the parameter.

    For different parameters a letter is inserted in the filename of get a consistent sorting of filenames.
    (They sort then according ascending parameter values.)
    
    If gnuplot is not None, use it for the plot, otherwise create a own instance.
    If interactive is True, wait after plotting for key press.
    """    
    import fuzzy.complement.Parametric
    if isinstance(c,fuzzy.complement.Parametric.Parametric):
        if params is None:
            params = get_test_params(c.p_range)
        # use letters to get sortable filenames
        for p,letter in zip(params,string.ascii_lowercase):
            c.p = p
            title = "%s %s (p=%s)" % (name,name2,p)
            filename = "%s_%s_%s_%s" % (name,name2,letter,p)
            plot(c,s,title,filename,gnuplot,interactive)
    else:
        title = "%s_%s" % (name,name2)
        filename = "%s_%s" % (name,name2)
        plot(c,s,title,filename,gnuplot,interactive)


def test():
    """Show examples for all complements in package fuzzy.complement"""
    import fuzzy.set
    import fuzzy.complement

    objects = get_classes(fuzzy.set)
    # add demo sets
    #from fuzzy.set.Polygon import Polygon
    #objects["Polygon (Demo)"] = Polygon([
    #        (-1.2,0),
    #        (-1.2,1),
    #        (-0.8,0.3),
    #        (-0.3,0.2),
    #        (-0.2,0.4),
    #        (-0.1,0.0),
    #        (0.0,0.0),
    #        (0.3,1),
    #        (0.6,0.5),
    #        (0.6,0.1),
    #        (1.3,0.6),
    #    ])

    complements = get_classes(fuzzy.complement)
    #print complements

    for name in sorted(objects):
        if name in ["Set", "Function", "Polygon", "Singleton"]:
            continue
        obj = objects[name]

        for name2 in sorted(complements):
            if name2 in ["Base","Parametric"]:
                continue
            try:
                complement = complements[name2]
                plotComplement(complement,name2,obj,name)
            except:
                import traceback
                traceback.print_exc()


def interactive(name,params):
    """interactive use: plot complement using given params"""
    import fuzzy.complement
    objects = get_classes(fuzzy.complement)
    try:
        complement = objects[name]
    except KeyError:
        print "%s is unknown." % name 
        return

    g = getGnuplot()
    from fuzzy.set.Triangle import Triangle
    set  = Triangle()
    set_name = "Triangle"

    if len(params) > 0:
        plotComplement(complement,name,set,set_name,params,gnuplot=g,interactive=True)
    else:
        plotComplement(complement,name,set,set_name,gnuplot=g,interactive=True)

    g.close()


# when executed, just run test():
if __name__ == '__main__':
    if len(sys.argv) > 1:
        interactive(sys.argv[1],[float(x) for x in sys.argv[2:]])
    else:
        if not os.path.exists("complement"):
            os.mkdir("complement")
        test()


