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

def dfs(sumNum,cnt):
    if cnt == 4:
        if sumNum > answer:
            answer = sumNum
    
    
    


