# request, BeautifulSoup 패키지 선언하기

import requests
from bs4 import BeautifulSoup



# 희망하는 URL을 변수에 집어 넣고, 연결시키기
Targeted_URL = 'https://developer.android.com/reference/android/accounts/AbstractAccountAuthenticator'
Requested01 = requests.get(Targeted_URL)



# BeautifulSoup을 이용하여, 파싱(parsing)하기

test_1 = BeautifulSoup(Requested01.text, 'html.parser')


# class 속성 값을 이용하여 Data 추출하기

result01_class01 = test_1.find('div', class_ ='devsite-sidebar-content')
result01_class02 = result01_class01.find_all('li', class_ ='devsite-nav-item')
print(result01_class01)
#print(result01_class01.get_text().strip())
