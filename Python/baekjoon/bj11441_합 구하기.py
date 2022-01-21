import sys

n = int(sys.stdin.readline())

nlist = list(map(int,sys.stdin.readline().split()))
sumlist = [0]
temp = 0
for i in nlist:
    temp += i
    sumlist.append(temp)

m = int(sys.stdin.readline())

for _ in range(m):
    start,end = map(int,sys.stdin.readline().split())
    print(sumlist[end] - sumlist[start-1])
