import sys

n,m = map(int,sys.stdin.readline().split())

nlist = list(map(int,sys.stdin.readline().split()))

temp = 0
sumList = [0]
for i in nlist:
    temp += i
    sumList.append(temp)

for _ in range(m):
    i,j = map(int,sys.stdin.readline().split())
    print(sumList[j] -sumList[i-1])
