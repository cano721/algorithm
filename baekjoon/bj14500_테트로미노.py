#종이 안에서 이어진 4개의 숫자를 뽑았을때 가장 큰 숫자 찾기

import sys
from collections import deque

#종이의 세로 n 가로 m
n,m = map(int,sys.stdin.readline().split())

#종이숫자 설정 및 종이 내 맥스값 찾기
maps = [0]*n
maxNum = 0
for i in range(n):
    maps[i] = list(map(int,sys.stdin.readline().split()))
    curmaxNum = max(maps[i])
    maxNum = max(curmaxNum,maxNum)



#방향이동
dirX = [0,0,1,-1]
dirY = [1,-1,0,0]

#큐생성
que = deque()

answer = 0

#종이를 돌면서 맥스값일때 이동
for i in range(n):
    for j in range(m):
        if maps[i][j] == maxNum:
            #방문여부
            visited = [[0]*m for _ in range(n)]
            visited[i][j] = 1
            #큐에 현재좌표,현재까지 합,사용한블럭수 넣기
            que.append([[i,j],maps[i][j],1,visited])

            while que:
                coordinates,curSum,blockNum,visited = que.popleft()
                if blockNum == 4:
                    answer = max(answer,curSum)
                else:
                    curMax = 0
                    xyList = []
                    #좌표이동
                    for i in range(4):
                        x = coordinates[0] + dirX[i]
                        y = coordinates[1] + dirX[j]
                        #이동한좌표가 방문하지않았고 종이내라면
                        if 0 <= x < n and 0 <= y < m and visited[x][y] == 0:
                            if curMax < maps[x][y]:
                                curMax = maps[x][y]
                                xyList = [[x,y]]
                            elif curMax == maps[x][y]:
                                xyList.append([x,y])
                    for nextCoordinates in xyList:
                        nextX = nextCoordinates[0]
                        nextY = nextCoordinates[1]
                        que.append([[nextX,nextY],curSum+maps[nextX][nextY],blockNum+1])

