import os
from selenium import webdriver
from webdriver_manager.chrome import ChromeDriverManager
from selenium.webdriver.common.by import By
from openpyxl import Workbook   
 


url_list = ["https://developer.android.com/reference/android/accounts/AbstractAccountAuthenticator","https://developer.android.com/reference/android/accounts/Account","https://developer.android.com/reference/android/accounts/AccountAuthenticatorActivity","https://developer.android.com/reference/android/accounts/AccountAuthenticatorResponse","https://developer.android.com/reference/android/accounts/AccountManager","https://developer.android.com/reference/android/accounts/AuthenticatorDescription"]

driver = webdriver.Chrome(ChromeDriverManager().install())
driver.maximize_window()
driver.implicitly_wait(10)

package_url_list = ["https://developer.android.com/reference/android/app/package-summary","https://developer.android.com/reference/android/app/admin/package-summary","https://developer.android.com/reference/android/accounts/package-summary","https://developer.android.com/reference/android/bluetooth/package-summary","https://developer.android.com/reference/android/content/package-summary","https://developer.android.com/reference/android/location/package-summary","https://developer.android.com/reference/android/media/package-summary","https://developer.android.com/reference/android/net/package-summary","https://developer.android.com/reference/android/nfc/package-summary","https://developer.android.com/reference/android/provider/package-summary","https://developer.android.com/reference/android/telecom/package-summary","https://developer.android.com/reference/android/telephony/package-summary"]
class_url_list = []
for urls in package_url_list:
    driver.get(urls)
    cls1 = driver.find_elements(By.CLASS_NAME,'jd-sumtable-expando')
    if urls == "https://developer.android.com/reference/android/telecom/package-summary":
        cl2 = cls1[0].find_elements(By.CLASS_NAME, 'jd-linkcol')
    else:
        cl2 = cls1[1].find_elements(By.CLASS_NAME, 'jd-linkcol')
    for cl in cl2:
        if('<' in cl.text):
            continue
        urls2 = urls.replace("package-summary",cl.text)
        class_url_list.append(urls2)
        
print(class_url_list)


api_list = []
try:
    for url in class_url_list:
        print(url)
        driver.get(url)
        class01 = driver.find_element(By.CLASS_NAME,'devsite-sidebar-content')
        class02 = class01.find_elements(By.CLASS_NAME,'devsite-nav-list')
        class03 = class02[-1].find_elements(By.CLASS_NAME,'devsite-nav-text')
        for cl in class03:
            if ord("a") <= ord(cl.text[0]) <= ord("z"):
                res = url.split("/")[-1]
                res = res.replace(".", "$")
                api_list.append(res + ';' + cl.text)
                print(res + ';' + cl.text)

finally:
    driver.quit()
    
    
write_wb = Workbook()
write_ws = write_wb.active
write_ws.append(api_list)
write_wb.save('apilist.xlsx')

file2 = open('apioutput.csv','w')
file3 = open('apilist.xlsx', 'r')

lines = file3.readlines(100000)  # 10만 줄을 한 번에 읽음 
                                # user가 설정할 수 있음
lines = list(set(lines))
lines.sort()

for line in lines:
    file2.write(line)

file2.close()
file3.close()

