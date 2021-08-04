
# bfs 로 돌면서 적록색약과 아닌사람으로 체크

import sys
from collections import deque

def checkEyes():
    visited = [[0]*n for _ in range(n)]
    #큐생성
    que = deque()
    #범위 개수
    cnt = 0
    for i in range(n):
        for j in range(n):
            if visited[i][j] == 0:
                cnt += 1
                que.append([i,j])
                visited[i][j] = 1

                while que:
                    cur = que.popleft()
                    curColor = maps[cur[0]][cur[1]]
                    for num in range(4):
                        x = cur[0] + dirX[num]
                        y = cur[1] + dirC[num]
                        if 0 <= x < n and 0 <= y < n:
                            if visited[x][y] == 0:
                                if curColor == "B":
                                    if maps[x][y] == curColor:
                                        visited[x][y] = 1
                                        que.append([x,y])   
                                else:
                                    if maps[x][y] == "R" or maps[x][y] == "G":
                                        visited[x][y] = 1
                                        que.append([x,y])

    return cnt

def checkNomal():
    visited = [[0]*n for _ in range(n)]
    #큐생성
    que = deque()
    #범위 개수
    cnt = 0
    for i in range(n):
        for j in range(n):
            if visited[i][j] == 0:
                cnt += 1
                que.append([i,j])
                visited[i][j] = 1

                while que:
                    cur = que.popleft()
                    curColor = maps[cur[0]][cur[1]]
                    for num in range(4):
                        x = cur[0] + dirX[num]
                        y = cur[1] + dirC[num]
                        if 0 <= x < n and 0 <= y < n:
                            if visited[x][y] == 0 and maps[x][y] == curColor:
                                visited[x][y] = 1
                                que.append([x,y])

    return cnt

# 맵크기 n
n = int(sys.stdin.readline())

# 맵
maps = [0] * n
for i in range(n):
    oneLine = sys.stdin.readline().rstrip()
    maps[i] = list(oneLine)

#4방향
dirX = [0,0,1,-1]
dirC = [1,-1,0,0]


eyesNum = checkEyes()
nomalNum = checkNomal()

print(nomalNum,eyesNum)