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
"""Plotting of variables, adjectives, ... using gnuplot"""

__revision__ = "$Id: doc.py,v 1.9 2009/09/24 20:32:20 rliebscher Exp $"


def getMinMax(set):
    """get tuple with minimum and maximum x-values used by the set."""
    ig = set.getIntervalGenerator()

    next = ig.nextInterval(None,None)
    
    x_min = next
    x_max = None
    
    while next is not None:
        x_max = next
        next = ig.nextInterval(next,None)

    return (x_min,x_max)

def getGlobalMinMax(sets):
    """get tuple with minimum and maximum x-values used by the sets of this dicts of sets."""
    x_min = None
    x_max = None
    for s in sets.values():
        (x_min2,x_max2) = getMinMax(s)
        if x_min is None or x_min2 < x_min:
            x_min = x_min2
        if x_max is None or x_max2 > x_max:
            x_max = x_max2
    return (x_min,x_max)


def getPoints(sets):
    """Collect all important points of all adjectives in this dict of sets."""

    from fuzzy.set.Set import merge
    # merge them all
    temp = None
    for s in sets.values():
        if temp is None:
            temp = s
        else:
            temp = merge(max,temp,s)

    # collect points
    # >>> result of merge is always a Polygon object
    points = [p[0] for p in temp.points]
    # avoid to have same value twice (filter points out where successor is equal)
    return points[:1] + [p0 for p0,p1 in zip(points[1:],points) if p0!=p1]


def getSets(variable):
    """Get all sets of adjectives in this variable."""
    sets = {}
    for a_name,adj in variable.adjectives.items():
        sets[a_name] = adj.set
    return sets


class Doc(object):
    """Main object. Get an instance of this to do your work."""

    def __init__(self,directory="doc"):
        self.directory = directory
        self.overscan = 0.1 #: the plotted range is M{[min-o,max+o]} with M{o=(max-min)*overscan}

    def setTerminal(self,g,filename):
        g("set terminal png small transparent truecolor nocrop")
        g("set output '%s/%s.png'" % (self.directory,filename))

    def initGnuplot2D(self,filename="plot",xlabel=None,ylabel=None,title=None,xrange_=None,yrange=None,x_logscale=0,y_logscale=0):
        import Gnuplot
        g = Gnuplot.Gnuplot(debug=0)
        self.setTerminal(g,filename)
        if xlabel is not None: g.xlabel(xlabel)
        if ylabel is not None: g.ylabel(ylabel)
        if title is not None: g.title(title)
        if xrange_ is not None: g('set xrange [%f:%f]' % xrange_) 
        else: g('set autoscale x')
        if yrange is not None: g('set yrange  [%f:%f]' % yrange) 
        else: g('set autoscale y')
        if x_logscale: g('set logscale x'); g('set autoscale x')
        if y_logscale: g('set logscale y'); g('set autoscale y')
        return g

    def initGnuplot3D(self,filename="plot3D",xlabel=None,ylabel=None,zlabel=None,title=None,xrange_=None,yrange=None,zrange=None,x_logscale=0,y_logscale=0,z_logscale=0):
        import Gnuplot
        g = Gnuplot.Gnuplot(debug=0)
        self.setTerminal(g,filename)
        if xlabel is not None: g.xlabel(xlabel)
        if ylabel is not None: g.ylabel(ylabel)
        if zlabel is not None: g("set zlabel '%s'" % zlabel)
        if title is not None:  g.title(title)
        if xrange_ is not None: g('set xrange [%f:%f]' % xrange_) 
        else: g('set autoscale x')
        if yrange is not None: g('set yrange  [%f:%f]' % yrange) 
        else: g('set autoscale y')
        if zrange is not None: g('set zrange  [%f:%f]' % zrange) 
        else: g('set autoscale z')
        if x_logscale: g('set logscale x');g('set autoscale x')
        if y_logscale: g('set logscale y');g('set autoscale y')
        if z_logscale: g('set logscale z');g('set autoscale z')
        g('set style data lines')
        g('set hidden')
        g('set pm3d at s')
        g('set pm3d ftriangles interpolate 50,50')
        g('set contour surface')
        return g


    def getValues(self,v):
        return self.getValuesSets(getSets(v))


    def getValuesSets(self,sets):
        (x_min,x_max) = getGlobalMinMax(sets)
        width = x_max - x_min
        x_min = x_min - self.overscan * width
        x_max = x_max + self.overscan * width
        width = x_max - x_min

        values = [x_min]+getPoints(sets)+[x_max]

        return (x_min,x_max,values)


    def createDoc(self,system):
        """create plots of all variables defined in the given system."""

        from fuzzy.OutputVariable import OutputVariable
        from fuzzy.InputVariable import InputVariable
        import fuzzy.defuzzify.Dict
        import fuzzy.fuzzify.Dict

        for name,var in system.variables.items():
            if isinstance(var,OutputVariable) and isinstance(var.defuzzify,fuzzy.defuzzify.Dict.Dict):
                print "ignore variable %s because it is of type OutputVariable => Dict" % name
            elif isinstance(var,InputVariable) and isinstance(var.fuzzify,fuzzy.fuzzify.Dict.Dict):
                print "ignore variable %s because it is of type InputVariable => Dict" % name
            else:
                self.createDocVariable(var,name)

    def createDocVariable(self,v,name,x_logscale=0,y_logscale=0):
        """Creates a 2D plot of a variable"""

        self.createDocSets(getSets(v),name,x_logscale,y_logscale,description=v.description,units=v.unit)

    def createDocSets(self,sets,name,x_logscale=0,y_logscale=0,description=None,units=None):
        """Creates a 2D plot of dict of sets"""

        import Gnuplot
        import Gnuplot.funcutils
        import fuzzy.set.Polygon

        # sort sets by lowest x values and higher membership values next
        def sort_key(a):
            s = sets[a]
            x = s.getIntervalGenerator().nextInterval(None,None)
            return (x,-s(x))

        (x_min,x_max,x) = self.getValuesSets(sets)

        # calculate values
        plot_items = []
        for s_name in sorted(sets,key=sort_key):
            s = sets[s_name]
            if isinstance(s,fuzzy.set.Polygon.Polygon):
                p = [(x_min,s(x_min))] + s.points + [(x_max,s(x_max))]
                plot_item = Gnuplot.PlotItems.Data(p,title=s_name)
            else:
                plot_item = Gnuplot.funcutils.compute_Data(x,s,title=s_name)
            plot_items.append(plot_item)

        xlabel = description or ""
        if units is not None:
            xlabel += " [%s]" % units
        g = self.initGnuplot2D(filename=name,xlabel=xlabel,ylabel="membership",title=name,xrange_=(x_min,x_max),yrange=(-0.2,1.2),x_logscale=x_logscale,y_logscale=y_logscale)
        g('set style fill transparent solid 0.5 border')
        g('set style data filledcurves y1=0')
        g.plot(*plot_items)
        g.close()

    def create2DPlot(self,system,x_name,y_name,input_dict={},output_dict={},x_logscale=0,y_logscale=0):
        """Creates a 2D plot of an input variable and an output variable.
        Other (const) variables have to be set beforehand in the dictionary input_dict.
        
        @param system: the fuzzy system to use
        @type system: L{fuzzy.System.System}
        @param x_name: name of input variable used for x coordinate values
        @type x_name: string
        @param y_name: name of output variable used for y coordinate values
        @type y_name: string
        @param input_dict: dictionary used for input values, can be used to predefine other input values
        @type input_dict: dict
        @param output_dict: dictionary used for output values
        @type output_dict: dict
        @param x_logscale: use logarithmic scale for x values
        @type x_logscale: bool
        @param y_logscale: use logarithmic scale for y values
        @type y_logscale: bool
        """

        import Gnuplot
        import Gnuplot.funcutils

        (x_min,x_max,x) = self.getValues(system.variables[x_name])

        def f(x,
                system=system,
                x_name=x_name,
                y_name=y_name,
                input_dict=input_dict,
                output_dict=output_dict):
            input_dict[x_name] = x
            output_dict[y_name] = 0.0

            system.calculate(input_dict,output_dict)

            return output_dict[y_name]

        g = self.initGnuplot2D(filename=x_name+"_"+y_name,xlabel=x_name,ylabel=y_name,title=y_name+"=f("+x_name+")",xrange_=(x_min,x_max),x_logscale=x_logscale,y_logscale=y_logscale)
        g('set style data lines')
        g.plot(Gnuplot.funcutils.compute_Data(x, f))
        g.close()

    def create3DPlot(self,system,x_name,y_name,z_name,input_dict={},output_dict={},x_logscale=0,y_logscale=0,z_logscale=0):
        """Creates a 3D plot of 2 input variables and an output variable.
        Other (const) variables have to be set beforehand in the dictionary input_dict.
        
        @param system: the fuzzy system to use
        @type system: L{fuzzy.System.System}
        @param x_name: name of input variable used for x coordinate values
        @type x_name: string
        @param y_name: name of input variable used for y coordinate values
        @type y_name: string
        @param z_name: name of output variable used for z coordinate values
        @type z_name: string
        @param input_dict: dictionary used for input values, can be used to predefine other input values
        @type input_dict: dict
        @param output_dict: dictionary used for output values
        @type output_dict: dict
        @param x_logscale: use logarithmic scale for x values
        @type x_logscale: bool
        @param y_logscale: use logarithmic scale for y values
        @type y_logscale: bool
        @param z_logscale: use logarithmic scale for z values
        @type z_logscale: bool
        """

        import Gnuplot
        import Gnuplot.funcutils

        (x_min,x_max,x) = self.getValues(system.variables[x_name])
        (y_min,y_max,y) = self.getValues(system.variables[y_name])

        def f(x,y,
                system=system,
                x_name=x_name,
                y_name=y_name,
                z_name=z_name,
                input_dict=input_dict,
                output_dict=output_dict):
            input_dict[x_name] = x
            input_dict[y_name] = y
            output_dict[z_name] = 0.0

            system.calculate(input_dict,output_dict)

            return output_dict[z_name]

        g = self.initGnuplot3D(filename=x_name+"_"+y_name+"_"+z_name,xlabel=x_name,ylabel=y_name,zlabel=z_name,title="%s=f(%s,%s)" % (z_name,x_name,y_name),xrange_=(x_min,x_max),yrange=(y_min,y_max),x_logscale=x_logscale,y_logscale=y_logscale,z_logscale=z_logscale)
        g.splot(Gnuplot.funcutils.compute_GridData(x,y, f,binary=0))
        g.close()


    def create3DPlot_adjective(self,system,x_name,y_name,z_name,adjective,input_dict={},output_dict={},x_logscale=0,y_logscale=0,z_logscale=0):
        """Creates a 3D plot of 2 input variables and an adjective of the output variable.
        Other (const) variables have to be set beforehand in the dictionary input_dict.
        
        @param system: the fuzzy system to use
        @type system: L{fuzzy.System.System}
        @param x_name: name of input variable used for x coordinate values
        @type x_name: string
        @param y_name: name of input variable used for y coordinate values
        @type y_name: string
        @param z_name: name of output variable used for z coordinate values
        @type z_name: string
        @param adjective: name of adjective of output variable used for z coordinate values
        @type adjective: string
        @param input_dict: dictionary used for input values, can be used to predefine other input values
        @type input_dict: dict
        @param output_dict: dictionary used for output values
        @type output_dict: dict
        @param x_logscale: use logarithmic scale for x values
        @type x_logscale: bool
        @param y_logscale: use logarithmic scale for y values
        @type y_logscale: bool
        @param z_logscale: use logarithmic scale for z values
        @type z_logscale: bool
        """

        import Gnuplot
        import Gnuplot.funcutils

        (x_min,x_max,x) = self.getValues(system.variables[x_name])
        (y_min,y_max,y) = self.getValues(system.variables[y_name])

        def f(x,y,
                system=system,
                x_name=x_name,
                y_name=y_name,
                z_name=z_name,
                adjective=adjective,
                input_dict=input_dict,
                output_dict=output_dict):
            input_dict[x_name] = x
            input_dict[y_name] = y
            output_dict[z_name] = 0.0

            system.calculate(input_dict,output_dict)

            return output_dict[z_name][adjective]

        g = self.initGnuplot3D(filename=x_name+"_"+y_name+"_"+z_name+"_"+adjective,xlabel=x_name,ylabel=y_name,zlabel=z_name,title="%s.%s=f(%s,%s)" % (z_name,adjective,x_name,y_name),xrange_=(x_min,x_max),yrange=(y_min,y_max),zrange=(0,1),x_logscale=x_logscale,y_logscale=y_logscale,z_logscale=z_logscale)
        g("set xyplane at 0")
        g("set cntrparam levels incremental 0.1,0.2,1.0")
        g.splot(Gnuplot.funcutils.compute_GridData(x,y, f,binary=0))
        g.close()
