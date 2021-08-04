# bfs로 풀이

# 각 그래프를 돌며 물을 만나는 칸수를 +1
# 저장된 칸수를 통해 빙산 녹이기
# 몇개의 덩어리로 되어있는지 체크
# 3step으로 진행

import sys
from collections import deque

# 빙산 물 닿는곳 체크
def checkWater():
    #큐 생성
    que = deque()
    #물 닿는 면 체크
    waterMountain = [[0]*m for _ in range(n)]

    #초기값 넣기
    for i in range(n):
        for j in range(m):
            if maps[i][j] != 0:
                que.append([i,j])
        
    while que:
        cur = que.popleft()
        #4방향 돌리기
        for num in range(4):
            x = cur[0] + dirX[num]
            y = cur[1] + dirC[num]
            #뉴좌표가 맵안에 있으면
            if 0 <= x < n and 0 <= y < m:
                #그 칸이 물이면
                if maps[x][y] == 0:
                    #-1하기 최소는 0으로
                    waterMountain[cur[0]][cur[1]] += 1
    #녹이기
    for a in range(n):
        for b in range(m):
            maps[a][b] = max(0,maps[a][b] - waterMountain[a][b])

#빙산 덩어리 체크
def checkMountainNum():
    #큐 생성
    que = deque()
    #방문여부
    visited = [[0]*m for _ in range(n)]
    #덩어리수
    cnt = 0
    for i in range(n):
        for j in range(m):
            if maps[i][j] != 0 and visited[i][j] == 0:
                cnt += 1
                que.append([i,j])
                visited[i][j] = 1

                while que:
                    cur = que.popleft()
                    for num in range(4):
                        x = cur[0] + dirX[num]
                        y = cur[1] + dirC[num]
                        if 0 <= x < n and 0 <= y < m:
                            if maps[x][y] != 0 and visited[x][y] == 0:
                                visited[x][y] = 1
                                que.append([x,y])
    return cnt


# 행의개수 m 열의 개수 n
n,m = map(int,sys.stdin.readline().split())

# 빙산 맵
maps = [0] * n
for i in range(n):
    maps[i] = list(map(int,sys.stdin.readline().split()))

#년수
year = 0

#4방향체크
dirX = [0,0,1,-1]
dirC = [1,-1,0,0]

while True:
    cnt = checkMountainNum()
    if cnt == 0:
        print(0)
        break
    elif cnt >= 2:
        print(year)
        break
    checkWater()
    year+=1


