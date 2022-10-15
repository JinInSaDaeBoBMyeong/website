from androguard.misc import AnalyzeAPK, get_default_session
import os 
import time
import shutil
import csv
os.chdir('./uploaded_files')
#---------------------------------------------------------------------------------------
def EXTRACT_API_CALLS(a):
    sess = get_default_session()
    app, list_of_dex, dx = AnalyzeAPK(a , session = sess)
    # Write Method Calls to a .txt file.......///
    for method in dx.get_methods():
        for _, call, _ in method.get_xref_to():
            temp_list = call.class_name.split('/')
            if temp_list[0] == "Landroid":
                if temp_list[1] == "content" or temp_list[1] == "app" or temp_list[1] == "bluetooth" or temp_list[1] == "location" or temp_list[1] == "media" or temp_list[1] == "net" or temp_list[1] == "nfc" or temp_list[1] == "provider" or temp_list[1] == "telecom" or temp_list[1] == "telephony":
                    # file.write(call.class_name + call.name + '\n')
                    file.write(temp_list[-1] + call.name + '\n')
    sess.reset()
#------------------------------------------------------------------------------------------

# with open('apioutput.csv', newline='') as f:
#     reader = csv.reader(f)
#     data = list(reader)
#     print(data[0])
    
for apk in os.listdir():
    start = time.time()
    file_name , file_extension = os.path.splitext(apk)
    file = open(file_name + '.csv', 'w')
    EXTRACT_API_CALLS(apk)
    file.close()

    file2 = open(file_name + 'out.csv','w')
    file3 = open(file_name + '.csv', 'r')

    lines = file3.readlines(100000)  # 10만 줄을 한 번에 읽음 
                                    # user가 설정할 수 있음
    lines = list(set(lines))
    lines.sort()

    for line in lines:
        file2.write(line)
    
    file2.close()
    file3.close()
    os.remove(file_name + '.csv')
    shutil.move(file_name + 'out.csv', '../apiout/'+file_name + '.csv')
    end = time.time()
    print(f"{end - start:.5f} sec")
