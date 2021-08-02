# 최단거리 이동시 벽 부수는 개수 구하기
# 다익스트라 사용

import sys
from heapq import *
from collections import defaultdict

# 가로 세로 m ,n
m, n = map(int, sys.stdin.readline().split())

#연결 그래프
graph = [0]*(n)

# 벽 생성
for x in range(n):
    graph[x] = list(map(int,sys.stdin.readline().strip()))

#방향
dirX = [0,0,1,-1]
dirY = [1,-1,0,0]

def dijkstra():
    breakWall = [[sys.maxsize]*(m) for _ in range(n)]
    
    #초기값
    breakWall[0][0] = 0

    que = []
    heappush(que,[0,[0,0]])

    while que:
        curBreak, curCoodinates = heappop(que)
        curX = curCoodinates[0]
        curY = curCoodinates[1]
        if breakWall[curX][curY] < curBreak:
            continue
        
        for i in range(4):
            nextX = curX + dirX[i]
            nextY = curY + dirY[i]
            if 0 <= nextX < n and 0 <= nextY < m:
                nextBreak = curBreak + graph[nextX][nextY]
                if breakWall[nextX][nextY] > nextBreak:
                    breakWall[nextX][nextY] = nextBreak
                    heappush(que,[nextBreak,[nextX,nextY]])

    return breakWall

answerList = dijkstra()
print(answerList[n-1][m-1])
