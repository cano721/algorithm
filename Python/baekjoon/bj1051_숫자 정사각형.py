import sys

n,m = map(int,sys.stdin.readline().split())

maps = []
for i in range(n):
    maps.append(list(map(int,sys.stdin.readline().rstrip())))

answer = 0
minNum = min(n,m)
for i in range(n):
    for j in range(m):
        for k in range(minNum):
            check = maps[i][j]
            if 0 <= i+k < n and 0 <= j+k < m:
                if check == maps[i+k][j] and check == maps[i][j+k] and check == maps[i+k][j+k]:
                    answer = max(answer,(k+1)**2)

print(answer)