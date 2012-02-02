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
Helper functions for calculation with fuzzy sets.

Examples can be found here U{http://pyfuzzy.sourceforge.net/test/merge/}

* Intersection of set1 and set2 can be done by
  
  C{set = merge(T_NORM,set1,set2)}
  
  where T_NORM is a t-norm eg. Min.
  (or a function which accepts two parameters as min().)

* Union of set1 and set2 can be done by
  
  C{set = merge(S_NORM,set1,set2)}
  
  where S_NORM is a s-norm eg. Max.
  (or a function which accepts two parameters as max().)

* Complement of set1 can be done by
  
  C{set = norm(lambda a,b:1.0-a ,set1,0.0)}
  
  using a user defined function for it.
  (The second parameter is ignored or better said
  it doesn't influence the value, it only influences
  maybe where the points of the resulting polygon are
  set.)

* Activation function can be done by
  
  C{set = norm(act_norm,set,act_value)}
  
  where act_norm is any L{fuzzy.norm} or two params function (eg. min)
  and act_value is the result of a rule calculation.
"""

__revision__ = "$Id: operations.py,v 1.5 2009/09/24 20:32:20 rliebscher Exp $"

# helper functions
def _find_null_steffensen(x,f,epsilon=None):
    """Find zero of function f by using the Steffensen method.
       As fixpoint equation M{g(x) = x - f(x)} is used.
       The algorithm stops if the error estimation is smaller than epsilon
       or the convergence quotient is larger than 1.0 (for at least two steps)
       or there is an ZeroDivisionError, which means in the last steps
       nothing changed.

       Normally the number of correct digits doubles each step, which
       means for 64 bits it needs not more than 6-7 steps for an
       arbitrary function.
       
       
       @param x: first estimation of result
       @type x: float
       @param f: function for which to find M{f(x)=0}
       @type f: M{f(x)}
       @param epsilon: break condition for algorithm (value < epsilon)
       @type epsilon: float/None
       @return: M{x} where M{f(x)=0}
       @rtype: float
    """
    g = lambda x,f=f: x-f(x)
    x_2,x_1,x_0 = None,None,x
    q_0,q_1 = 0.0,0.0
    while abs(q_0)<1.0 or abs(q_1)<1.0:
        y0 = x_0
        y1 = g(y0)
        y2 = g(y1)
        try:
            x_2,x_1,x_0 = x_1,x_0,y2 - (y2-y1)*(y2-y1)/(y2-2*y1+y0)
            if x_2 is not None:
                # Konvergenzquotient
                q_1,q_0 = q_0,(x_0-x_1)/(x_1-x_2)
                if epsilon is not None:
                    # Fehlerschaetzung
                    if epsilon > abs((x_0-x_1)*(x_0-x_1)/(x_0-2*x_1+x_2)):
                        break
        except ZeroDivisionError:
            break
    return x_0


def _merge_generator(NORM, set1, set2):
    """Returns a new fuzzy set which ist the merger of set1 and set2,
    where the membership of the result set is equal to C{NORM(set1(x),set2(x))}.
    
    @param NORM: fuzzy norm to calculate both sets values. For example Min(), Max(), ...
        Also possible as two params function, eg. C{lambda a,b: (a+b)/2.}.
    @type NORM: L{fuzzy.norm.Norm.Norm}
    @param set1: fuzzy set
    @type set1: L{fuzzy.set.Set}
    @param set2: fuzzy set
    @type set2: L{fuzzy.set.Set}
    @return: resulting fuzzy set
    @rtype: L{fuzzy.set.Polygon.Polygon}
       """
    from fuzzy.set.Polygon import Polygon
    g1 = set1.getIntervalGenerator()
    g2 = set2.getIntervalGenerator()

    x = g1.nextInterval(None,None)
    x_ = g2.nextInterval(None,x)
    if x_ is not None and x_ < x:
        x = x_
    if x is None:
        return
    y1 = set1(x)
    y2 = set2(x)
    yield (x,NORM(y1,y2))
    while 1:
        prev_x, prev_y1, prev_y2 = x, y1, y2
        # get new interval from sets
        x = g1.nextInterval(prev_x,None)
        x_ = g2.nextInterval(prev_x,x)
        if x is None and x_ is None: # no need for more intervals
            break
        if x is None: 
            # first set is finished => take values from second 
            x = x_
        else:
            if x_ is None:
                # second set is finished first, x is already ok
                pass
            else:
                if x_ < x:
                    # both need more calculations, get smaller value
                    x = x_
        y1 = set1(x)
        y2 = set2(x)
        # test if intersection => split interval
        if (x != prev_x) and ((y1>y2 and prev_y1<prev_y2) or (y1<y2 and prev_y1>prev_y2)):
            saved_x, saved_y1, saved_y2 = x, y1, y2
            # calculate intersection
            y_diff = y1-y2
            prev_y_diff = prev_y2-prev_y1
            p = prev_y_diff/(prev_y_diff + y_diff)
            x = prev_x + p * (x-prev_x)
            if not (isinstance(set1,Polygon)
               and isinstance(set2,Polygon)):
                # in this case we have only an approximation
                x = _find_null_steffensen(x,lambda x,set1=set1,set2=set2:set1(x)-set2(x))
            y1 = set1(x)
            y2 = set2(x)
            # add this point
            yield (x,NORM(y1,y2))
            # restore saved point
            prev_x, prev_y1, prev_y2 = x, y1, y2
            x,y1,y2 = saved_x,saved_y1,saved_y2
        # add this point
        yield (x,NORM(y1,y2))
    return


def merge(NORM, set1, set2, segment_size=None):
    """Returns a new fuzzy set which ist the merger of set1 and set2,
    where the membership of the result set is equal to C{NORM(set1(x),set2(x))}.
    
    For nonlinear operations you might want set the segment size to a value 
    which controls how large a linear segment of the result can be. 
    See also the following examples:
      - U{http://pyfuzzy.sourceforge.net/test/merge/AlgebraicProduct_d_d.png} - The algebraic product is M{x*y}, so using it on the same set, it calculates the square of it.
      - U{http://pyfuzzy.sourceforge.net/test/merge/AlgebraicSum_d_d.png} - The algebraic sum is M{x+y-x*y}.
       
    @param NORM: fuzzy norm to calculate both sets values. For example Min(), Max(), ...
        Also possible as two params function, eg. C{lambda a,b: (a+b)/2.}.
    @type NORM: L{fuzzy.norm.Norm.Norm}
    @param set1: fuzzy set
    @type set1: L{fuzzy.set.Set}
    @param set2: fuzzy set
    @type set2: L{fuzzy.set.Set}
    @param segment_size: maximum size of a segment
    @type segment_size: float/None
    @return: resulting fuzzy set
    @rtype: L{fuzzy.set.Polygon.Polygon}
       """
    from fuzzy.set.Polygon import Polygon
    ret = Polygon()

    prev_x,prev_y = None,None
    for x,y in _merge_generator(NORM,set1,set2):
        if (segment_size is not None) and (prev_x is not None) and (abs(y-prev_y)>0.01):
            diff = x-prev_x
            if  diff > 2.*segment_size:
                n = int(diff/segment_size)
                dx = diff/n
                for i in range(1,n):
                    x_ = prev_x+i*dx
                    ret.add(x_,NORM(set1(x_),set2(x_)))
        ret.add(x,y)
        prev_x,prev_y = x,y

    return ret


def _norm_generator(NORM, set, value):
    """Returns a new fuzzy set which ist this set normed with value.
    where the membership of the result set is equal to C{NORM(set(x),value)}.
    
    @param NORM: fuzzy norm to calculate set's values with value. For example Min(), Max(), ...
        Also possible as two params function, eg. C{lambda a,b: (a+b)/2.}.
    @type NORM: L{fuzzy.norm.Norm.Norm}
    @param set: fuzzy set
    @type set: L{fuzzy.set.Set}
    @param value: value
    @type value: float
    @return: resulting fuzzy set
    @rtype: L{fuzzy.set.Polygon.Polygon}
    """
    from fuzzy.set.Polygon import Polygon
    g = set.getIntervalGenerator()

    x = g.nextInterval(None,None)
    if x is None:
        return
    y = set(x)
    yield (x,NORM(y,value))
    while 1:
        prev_x, prev_y = x, y
        # get new interval from sets
        x = g.nextInterval(prev_x,None)
        if x is None: # no need for more intervals
            break
        y = set(x)
        # test if intersection => split interval
        if (x != prev_x) and ((y>value and prev_y<value) or (y<value and prev_y>value)):
            saved_x, saved_y = x, y
            # calculate intersection
            y_diff = y-value
            prev_y_diff = value-prev_y
            p = prev_y_diff/(prev_y_diff + y_diff)
            x = prev_x + p * (x-prev_x)
            if not isinstance(set,Polygon):
                # in this case we have only an approximation
                x = _find_null_steffensen(x,lambda x,set=set,value=value:set(x)-value)
            y = set(x)
            # add this point
            yield (x,NORM(y,value))
            # restore saved point
            prev_x, prev_y = x, y
            x,y = saved_x,saved_y
        # add this point
        yield (x,NORM(y,value))
    return

def norm(NORM, set, value,segment_size=None):
    """Returns a new fuzzy set which ist this set normed with value.
    where the membership of the result set is equal to C{NORM(set(x),value)}.

    For meaning of segment_size see also L{fuzzy.set.operations.merge}.
    
    @param NORM: fuzzy norm to calculate set's values with value. For example Min(), Max(), ...
        Also possible as two params function, eg. C{lambda a,b: (a+b)/2.}.
    @type NORM: L{fuzzy.norm.Norm.Norm}
    @param set: fuzzy set
    @type set: L{fuzzy.set.Set}
    @param value: value
    @type value: float
    @param segment_size: maximum size of a segment
    @type segment_size: float/None
    @return: resulting fuzzy set
    @rtype: L{fuzzy.set.Polygon.Polygon}
    """
    from fuzzy.set.Polygon import Polygon
    ret = Polygon()

    prev_x,prev_y = None,None
    for x,y in _norm_generator(NORM,set,value):
        if (segment_size is not None) and (prev_x is not None) and (abs(y-prev_y)>0.01):
            diff = x-prev_x
            if  diff > 2.*segment_size:
                n = int(diff/segment_size)
                dx = diff/n
                for i in range(1,n):
                    x_ = prev_x+i*dx
                    ret.add(x_,NORM(set(x_),value))
        ret.add(x,y)
        prev_x,prev_y = x,y

    return ret

def _complement_generator(COMPLEMENT, set):
    """Returns a new fuzzy set which ist this complement of the given set.
    (Where the membership of the result set is equal to C{COMPLEMENT(set(x))}.
    
    @param COMPLEMENT: fuzzy complement to use. For example Zadeh(), ...
        Also possible as one param function, eg. C{lambda x: 1.-x}.
    @type COMPLEMENT: L{fuzzy.complement.Base.Base}
    @param set: fuzzy set
    @type set: L{fuzzy.set.Set}
    @return: resulting fuzzy set
    @rtype: L{fuzzy.set.Polygon.Polygon}
    """
    g = set.getIntervalGenerator()

    x = g.nextInterval(None,None)
    if x is None:
        return
    y = set(x)
    yield (x,COMPLEMENT(y))
    while 1:
        prev_x, prev_y = x, y
        # get new interval from sets
        x = g.nextInterval(prev_x,None)
        if x is None: # no need for more intervals
            break
        y = set(x)
        # add this point
        yield (x,COMPLEMENT(y))
    return


def complement(COMPLEMENT, set,segment_size=None):
    """Returns a new fuzzy set which ist this complement of the given set.
    (Where the membership of the result set is equal to C{COMPLEMENT(set(x))}.

    For meaning of segment_size see also L{fuzzy.set.operations.merge}.
    
    @param COMPLEMENT: fuzzy complement to use. For example Zadeh(), ...
        Also possible as one param function, eg. C{lambda x: 1.-x}.
    @type COMPLEMENT: L{fuzzy.complement.Base.Base}
    @param set: fuzzy set
    @type set: L{fuzzy.set.Set}
    @param segment_size: maximum size of a segment
    @type segment_size: float/None
    @return: resulting fuzzy set
    @rtype: L{fuzzy.set.Polygon.Polygon}
    """
    from fuzzy.set.Polygon import Polygon
    ret = Polygon()

    prev_x,prev_y = None,None
    for x,y in _complement_generator(COMPLEMENT,set):
        if (segment_size is not None) and (prev_x is not None) and (abs(y-prev_y)>0.01):
            diff = x-prev_x
            if  diff > 2.*segment_size:
                n = int(diff/segment_size)
                dx = diff/n
                for i in range(1,n):
                    x_ = prev_x+i*dx
                    ret.add(x_,COMPLEMENT(set(x_)))
        ret.add(x,y)
        prev_x,prev_y = x,y

    return ret
