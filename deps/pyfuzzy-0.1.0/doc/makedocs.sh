#!/bin/bash
#
# Creates documentation with pydoc and epydoc (PDF and HTML)
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
# $Id: makedocs.sh,v 1.3 2009/10/07 20:52:24 rliebscher Exp $

function run_pydoc {
    # this create docs with links to sourceforge cvs browser
    python ../SFpydoc.py -w $1
    # if you want create local docs uncomment the next line
    #pydoc -w $1
}

function create_pydoc {
    mkdir pydoc
    cd pydoc
    export PYTHONPATH=../..

    MODULES="./../.."
    for i in $MODULES ; do
        run_pydoc $i
    done
    cd ..
}

function create_epydoc {
    export PYTHONPATH=..
    epydoc --config=epydoc.cfg --config=epydoc.html.cfg
}
function create_epydoc_pdf {
    export PYTHONPATH=..
    epydoc --config=epydoc.cfg --config=epydoc.pdf.cfg
}

create_pydoc

create_epydoc_pdf

create_epydoc
