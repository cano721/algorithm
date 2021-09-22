import sys

n,k = map(int,sys.stdin.readline().split())

nlist = [i for i in range(2,n+1)]
checkList = [0]*(n+1)
check = 2
cnt = 0
flag = True
while flag:
    check2 = check
    while check2 <= n:
        if checkList[check2] == 0:
            cnt+= 1
            nlist.remove(check2)
            checkList[check2] = 1
        if cnt == k:
            print(check2)
            flag = False
            break
        check2 += check
    if len(nlist) > 0:
        check = nlist[0]