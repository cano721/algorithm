# 1번부터 키순서대로 전해짐
# 1번이 왼쪽에 2명이 있다고 전해지면 1번은 3번자리 고정
# 2번이 자기 왼쪽에 1명 있다고 하면 

import sys

n = int(sys.stdin.readline())

nlist = list(map(int,sys.stdin.readline().split()))
result = [0]*n

# 
for i in range(n):
    number = 0
    for j in range(n):
        if number == nlist[i] and result[j]==0:
            result[j] = i+1
            break
        elif(result[j] == 0):
            number += 1
for i in result:
    print(i,end=" ")