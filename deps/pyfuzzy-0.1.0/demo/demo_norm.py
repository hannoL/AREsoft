#!/usr/bin/env python
# -*- coding: iso-8859-1 -*-
#
"""\
# Run all fuzzy norms over the valid input ranges and create a 3D-plot 
# of the result. Paramtric norms are done with several paramter values.
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

__revision__ = "$Id: demo_norm.py,v 1.13 2009/10/18 19:44:46 rliebscher Exp $"

import sys, os
sys.path.insert(0, os.path.join(os.path.abspath(os.path.dirname(sys.argv[0])),os.path.pardir))

try:
    # If the package has been installed correctly, this should work:
    import Gnuplot, Gnuplot.funcutils
except ImportError:
    print "Sorry, you need Gnuplot.py (http://gnuplot-py.sourceforge.net) to use this."
    sys.exit(1)

from utils import get_classes, get_test_params
import fuzzy.norm
import string

def getGnuplot():
    """Get a preconfigured Gnuplot instance for plotting."""
    # A straightforward use of gnuplot.  The `debug=1' switch is used
    # in these examples so that the commands that are sent to gnuplot
    # are also output on stderr.
    g = Gnuplot.Gnuplot(debug=0)
    g('set parametric')
    g('set style data lines')
    g('set hidden')
    g('set contour surface')
    g('set cntrparam levels 10')
    g('set border 4095')
    g('set xyplane at 0')
    g('set colorbox user origin 0.9,0.05 size 0.05,0.5')
    g('set noautoscale xy')
    g('set xrange [0:1]')
    g('set yrange [0:1]')
    g('set zrange [0:1]')
    g('set cbrange [0:1]')
    g.xlabel('x')
    g.ylabel('y')
    g('set pm3d at s')
    return g


def plot(norm,title,filename,gnuplot=None,interactive=False):
    """Demonstrate a 3-d plot"""
    # set up x and y values at which the function will be tabulated:
    # use values  0.00 0.02 0.04 ... 0.96 0.98 1.00
    steps = 50
    x = [ i*1./steps for i in range(steps+1) ]
    y = [ i*1./steps for i in range(steps+1) ]

    g = gnuplot or getGnuplot()
    g.title(title) 
    print "Plot %s ... " % title
    #g.splot(Gnuplot.funcutils.compute_GridData(x,y, norm, binary=1))
    if interactive == False:
        g("set terminal png small truecolor nocrop")
        g("set output 'norm/%s.png'" % filename)
    g.splot(Gnuplot.funcutils.compute_GridData(x,y, norm, binary=0))
    if interactive == True:
        raw_input('Please press return to continue...\n')
    if gnuplot is None:
        g.close()
    g = None


#def plotNorm(norm,name,params=[0.05,0.25,0.50,0.75,0.95],gnuplot=None,interactive=False):
def plotNorm(norm,name,params=None,gnuplot=None,interactive=False):
    """Plot a given norm using the name for the title/filename.
    For parametric norms, it uses several values of the parameter.
    These values depend on the valid range of the parameter.

    For different parameters a letter is inserted in the filename of get a consistent sorting of filenames.
    (They sort then according ascending parameter values.)
    
    If gnuplot is not None, use it for the plot, otherwise create a own instance.
    If interactive is True, wait after plotting for key press.
    """
    import fuzzy.norm.ParametricNorm
    if isinstance(norm,fuzzy.norm.ParametricNorm.ParametricNorm):
        if params is None:
            params = get_test_params(norm.p_range)
        # use letters to get sortable filenames
        for p,letter in zip(params,string.ascii_lowercase):
            try:
                norm.p = p
                title = "%s (p=%s)" % (name,p)
                filename = "%s_%s_%s" % (name,letter,p)
                plot(norm,title,filename,gnuplot,interactive)
            except:
                import traceback
                traceback.print_exc()
                raw_input('Please press return to continue...\n')
    else:
        title = "%s" % (name)
        filename = title
        plot(norm,title,filename,gnuplot,interactive)


def test():
    """Show examples for all norm in package fuzzy.norm"""
    objects = get_classes(fuzzy.norm)

    for name in sorted(objects):
        if name in ["Norm","ParametricNorm"]:
            continue
        try:
            norm = objects[name]
            plotNorm(norm,name)
        except:
            import traceback
            traceback.print_exc()
            #raw_input('Please press return to continue...\n')

def interactive(name,params):
    """interactive use: plot norm using given params"""
    objects = get_classes(fuzzy.norm)
    try:
        norm = objects[name]
    except KeyError:
        print "%s is unknown." % name 
        return

    g = getGnuplot()

    if len(params) > 0:
        plotNorm(norm,name,params,gnuplot=g,interactive=True)
    else:
        plotNorm(norm,name,gnuplot=g,interactive=True)

    g.close()


# when executed, just run test():
if __name__ == '__main__':
    if len(sys.argv) > 1:
        interactive(sys.argv[1],[float(x) for x in sys.argv[2:]])
    else:
        if not os.path.exists("norm"):
            os.mkdir("norm")
        test()

