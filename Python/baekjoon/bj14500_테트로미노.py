#종이 안에서 이어진 4개의 숫자를 뽑았을때 가장 큰 숫자 찾기

import sys
from collections import deque

#4줄짜리 만들 수 있는 4방향 체크(ㅗ모양 제외)
def dfs(coordinates,sumNum,cnt):
    global answer
    if cnt == 4:
        if sumNum > answer:
            answer = sumNum
        return
    
    for i in range(4):
        x = dirX[i] + coordinates[0]
        y = dirY[i] + coordinates[1]

        if 0<= x < n and 0<= y < m:
            if visited[x][y] == 0:
                visited[x][y] = 1
                dfs([x,y],sumNum+maps[x][y],cnt+1)
                visited[x][y] = 0

#ㅗ모양 체크
def check(coordinates,sumNum,cnt):
    global answer
    minNum = sys.maxsize
    for i in range(4):
        x = dirX[i] + coordinates[0]
        y = dirY[i] + coordinates[1]

        if 0<= x < n and 0<= y < m:
            cnt += 1
            sumNum += maps[x][y]
            minNum = min(minNum,maps[x][y])
    
    #4칸만 채웠을 경우 비교
    if cnt == 4:
        if answer < sumNum:
            answer = sumNum
    # 4방향을 다 갔을 경우 가장 작은 정수를 빼고 비교
    elif cnt == 5:
        sumNum -= minNum
        if answer < sumNum:
            answer = sumNum

#종이의 세로 n 가로 m
n,m = map(int,sys.stdin.readline().split())

#종이숫자 설정
maps = [0]*n
for i in range(n):
    maps[i] = list(map(int,sys.stdin.readline().split()))

#방향이동
dirX = [0,0,1,-1]
dirY = [1,-1,0,0]

answer = 0

#방문여부
visited = [[0]*m for _ in range(n)]

#종이를 돌면서 맥스값일때 이동
for i in range(n):
    for j in range(m):
        visited[i][j] = 1
        #ㅗ,ㅜ,ㅏ,ㅓ 모양 제외 확인
        dfs([i,j],maps[i][j],1)
        #ㅗ,ㅜ,ㅏ,ㅓ 모양 체크
        check([i,j],maps[i][j],1)
        visited[i][j] = 0

print(answer)