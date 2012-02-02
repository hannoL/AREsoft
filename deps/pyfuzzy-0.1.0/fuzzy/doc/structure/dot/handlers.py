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

"""Handlers for different object types which print the object in dot format"""

__revision__ = "$Id: handlers.py,v 1.5 2009/08/07 07:19:18 rliebscher Exp $"


from fuzzy.doc.structure.dot.dot import register_handler,print_dot

def ID(obj):
    """Get an unique ID from object for dot node names"""
    return hex(id(obj)).replace('-','_')

# if set to 1 every adjective in every rule is unique
# otherwise same adjectives in different rules are collapsed 
# into one when in same graph
_XXX = 0

class DocBase(object):
    """'Abstract' Base class for everything else"""
    def __init__(self):
        self.node_style = { 
            "label":"%(label)s",
        }
        self.connection_style = { }

    def make_node(self,out,name,values={}):
        opt = ""
        for option,value in self.node_style.items():
            if value == None:
                continue
            if opt != "":
                opt += ","
            opt += '%s="%s"' % ( option , (value % values) )
        if opt != "":
            opt = " [" + opt + "]"
        out.write("%s%s;\n" % (name,opt))

    def make_connection(self,out,node1,node2,values={}):
        opt = ""
        for option,value in self.connection_style.items():
            if value == None:
                continue
            if opt != "":
                opt += ","
            opt += '%s="%s"' % ( option , (value % values) )
        if opt != "":
            opt = " [" + opt + "]"
        out.write("%s -> %s%s;\n" % (node1,node2,opt))

#########################
class Doc_Compound(DocBase):
    def __init__(self):
        super(Doc_Compound,self).__init__()
        #self.node_style.update(
        #    { "comment":"XXX" }
        #)

    def __call__(self,obj,out,system,parent_name):
        norm_name = print_dot(obj.norm,out,system,parent_name)
        for i in obj.inputs:
            inp_node_name = print_dot(i,out,system,norm_name)
            self.make_connection(out,inp_node_name,norm_name)
        return norm_name

import fuzzy.operator.Compound
register_handler(fuzzy.operator.Compound.Compound,Doc_Compound())

#########################
class Doc_Const(DocBase):
    def __call__(self,obj,out,system,parent_name):
        prefix = (parent_name+"_") if _XXX else ""
        node_name = prefix + "CONST_" + ID(obj)
        self.make_node(out,node_name,{"label":"%g" % obj.value})
        return node_name

import fuzzy.operator.Const
register_handler(fuzzy.operator.Const.Const,Doc_Const())


#########################
class Doc_Input(DocBase):
    def __call__(self,obj,out,system,parent_name):
        #out.write("{rank=min;\n")
        input_name = print_dot(obj.adjective,out,system,parent_name)
        #out.write("}\n")
        return input_name

import fuzzy.operator.Input
register_handler(fuzzy.operator.Input.Input,Doc_Input())


#########################
class Doc_Not(DocBase):
    def __init__(self):
        super(Doc_Not,self).__init__()
        self.node_style.update({ "label":"NOT" })

    def __call__(self,obj,out,system,parent_name):
        prefix = (parent_name+"_") if _XXX else ""
        node_name = prefix + "NOT_" + ID(obj)
        self.make_node(out,node_name)
        inp_node_name = print_dot(obj.input,out,system,node_name)
        self.make_connection(out,inp_node_name,node_name)
        return node_name

import fuzzy.operator.Not
register_handler(fuzzy.operator.Not.Not,Doc_Not())

#########################
class Doc_Norm(DocBase):
    def __call__(self,obj,out,system,parent_name):
        prefix = (parent_name+"_") if _XXX else ""
        node_name = prefix + "NORM_" + ID(obj)
        norm_name = obj.__class__.__name__
        self.make_node(out,node_name,{"label":norm_name})
        return node_name

import fuzzy.norm.Norm
register_handler(fuzzy.norm.Norm.Norm,Doc_Norm())

#########################
class Doc_ParametricNorm(Doc_Norm):
    def __call__(self,obj,out,system,parent_name):
        prefix = (parent_name+"_") if _XXX else ""
        node_name = prefix + "NORM_" + ID(obj)
        norm_name = obj.__class__.__name__
        self.make_node(out,node_name,{"label":"%s(%g)" % (norm_name,obj.p)})
        return node_name

import fuzzy.norm.ParametricNorm
register_handler(fuzzy.norm.ParametricNorm.ParametricNorm,Doc_ParametricNorm())

#########################
class Doc_Adjective(DocBase):
    def __init__(self):
        super(Doc_Adjective,self).__init__()
        self.node_style.update({
            "shape":"box",
            "style":"filled",
            "fillcolor":"palegreen",
        })

    def __call__(self,obj,out,system,parent_name):
        prefix = (parent_name+"_") if _XXX else ""
        node_name = prefix + "ADJ_" + ID(obj)
        adj = obj.getName(system)
        if not(adj is None):
            adjname = adj[1] + "." + adj[0]
        else:
            adjname = "???"
        self.make_node(out,node_name,{"label":adjname})
        return node_name

import fuzzy.Adjective
register_handler(fuzzy.Adjective.Adjective,Doc_Adjective())
import fuzzy.AdjectiveProxy
register_handler(fuzzy.AdjectiveProxy.AdjectiveProxy,Doc_Adjective())

#########################
class Doc_Rule(DocBase):
    def __init__(self):
        super(Doc_Rule,self).__init__()
        self.connection_style.update({
            "label":"%(label)s",
#            "decorate":"true",
            "weight":"2"
        })

    def __call__(self,obj,out,system,parent_name):
        node_name = "RULE_" + ID(obj)
        name = obj.getName(system)
        out.write(
"""#  subgraph "%(node_name)s" {
#    label="%(name)s";
    """ % locals())
        operator_node_name = print_dot(obj.operator,out,system,node_name)

        if isinstance(obj.adjective,fuzzy.Adjective.Adjective):
            #out.write("{rank=max;\n")
            adj_node_name = print_dot(obj.adjective,out,system,node_name)
            #out.write("}\n")
            self.make_connection(out,operator_node_name,adj_node_name,{"label": name + ("" if obj.certainty == 1.0 else ": %g" % obj.certainty) })
        elif isinstance(obj.adjective,list):
            for adj in obj.adjective:
                #out.write("{rank=max;\n")
                adj_node_name = print_dot(adj,out,system,node_name)
                #out.write("}\n")
                self.make_connection(out,operator_node_name,adj_node_name,{"label": name + ("" if obj.certainty == 1.0 else ": %g" % obj.certainty) })
        else:
            raise Exception("rule target not set.")
        return ""

import fuzzy.Rule
register_handler(fuzzy.Rule.Rule,Doc_Rule())

####################################
import fuzzy.OutputVariable
class Doc_Variable(DocBase):
    def __init__(self):
        super(Doc_Variable,self).__init__()
        self.node_style.update({
            "style":"filled",
            "fillcolor":"pink",
        })
        self.connection_style.update({
            "weight":"10",
            "style":"bold"
        })

    def __call__(self,obj,out,system,parent_name):
        node_name = "VAR_" + ID(obj)
        name = obj.getName(system)
        #rank = "max" if isinstance(obj,fuzzy.OutputVariable.OutputVariable) else "min"
        #out.write("{rank=%(rank)s;\n" % locals())
        self.make_node(out,node_name,{"label":name})
        #out.write("}\n")
        #out.write("subgraph XXX {rank=same;\n")
        for adj in obj.adjectives.values():
            adj_node_name = print_dot(adj,out,system,node_name)
            self.make_connection(out,node_name,adj_node_name)
        #out.write("}\n")
        return ""

class Doc_OutputVariable(Doc_Variable):
    def make_connection(self,out,node1,node2,values={}):
        # output variables get the arrows from adjective to variable
        super(Doc_OutputVariable,self).make_connection(out,node2,node1,values)

import fuzzy.Variable
register_handler(fuzzy.Variable.Variable,Doc_Variable())
register_handler(fuzzy.OutputVariable.OutputVariable,Doc_OutputVariable())
