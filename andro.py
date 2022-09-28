from subprocess import call
from androguard.core.bytecodes.apk import APK
from androguard.core.bytecodes.dvm import DalvikVMFormat

from androguard.core.bytecodes import apk
from androguard.core.bytecodes import dvm

apkf = APK('uploaded_files/sample2.apk') # 분석 대상 앱의 위치

# print ('1. App Name')
# print(apkf.get_app_name())

# print ('2. Permissions')
# print(apkf.get_permissions())

# print ('3. Package')
# print(apkf.get_package())

# print ('4. Main Activity')
# print(apkf.get_main_activity())

# print ('5. Activities')
# print(apkf.get_activities())

# print ('6. Services')
# print(apkf.get_services())

def dump_xml(apk_file):
    print(type(str(apkf.get_android_manifest_axml().get_xml())))
    return str(apkf.get_android_manifest_axml().get_xml())

#print('7. Strings')
classes = apkf.get_dex()
a = DalvikVMFormat(classes)
#print(apkf.get_features)
#print(a.get_classes())
#print(a.get_strings())
 
#apk method 가져오기
def dump_method(apk_file):
    call_method=[]
    a = apk.APK(apk_file)
    d = dvm.DalvikVMFormat(a.get_dex())
    for current_class in d.get_classes():
        for method in current_class.get_methods():
            call_method.append(method.get_name())
 
    call_method = list(set(call_method))
    print(call_method)
    return call_method, len(call_method)
 
#apk 퍼미션
def dump_permissions(apk_file):
    call_permissions = []
    a = apk.APK(apk_file)
    for per in a.get_permissions():
        per=per.split(".")
        #if "Admin" in per[-1]:
        call_permissions.append(per[-1])
 
    call_permissions = list(set(call_permissions))
    return call_permissions





