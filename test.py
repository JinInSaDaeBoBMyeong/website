N = input()
N = int(N)
print(N)
while(True):
    if(N==1):
        break
    elif(N//2 == 0):
        N = N//2
        print(N)
    else:
        N = 3*N + 1
        print(N)
    