import openpyxl
import pandas as pd
#file2 = open('apioutput.csv','w')
filename = "apilist.xlsx" #파일명
df = pd.read_excel(filename)
for api in df.columns:
    print(api)
# file3 = open('apilist.xlsx', 'r')

# lines = file3.readlines(100000)  # 10만 줄을 한 번에 읽음 
#                                 # user가 설정할 수 있음
# lines = list(set(lines))
# lines.sort()

# for line in lines:
#     file2.write(line)

# file2.close()
# file3.close()