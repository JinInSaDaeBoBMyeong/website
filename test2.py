#!/usr/bin/env python

import sys,string
from androguard.core.bytecodes.dvm import DalvikVMFormat
from androguard.core.bytecodes.apk import APK
from androguard.core.analysis.analysis import uVMAnalysis

def join_names(items):
    arr = []
    for item in items:
        arr.append(item[0].class_name+"->"+item[0].name)
    return string.join(arr, ", ")

if len(sys.argv) > 2:
    filename = sys.argv[1]
    method_name = sys.argv[2]
    d = DalvikVMFormat(APK(filename, False).get_dex())
    d.create_python_export()
    dx = uVMAnalysis(d)
    d.set_vmanalysis(dx)
    d.create_xref()
    for m in d.get_methods():
        if m.name == method_name:
            print (m.class_name + "->" + m.name + " ----------------- XREFfrom: [" + join_names(m.XREFfrom.items) + "] XREFto: [" + join_names(m.XREFto.items) + "]")