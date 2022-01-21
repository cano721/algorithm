# 3*50 맵크기라 브루트포스가능

from collections import deque
import sys

# 세로 n 가로 m
n,m = map(int,sys.stdin.readline().split())


# 로봇 청소기 좌표 r은 북쪽으로부터 c는 서쪽으로부터 떨어진 수
# 로봇 청소기가 바라보는 방향 d 0 북쪽 1 동쪽 2 남쪽 3 서쪽
r,c,d = map(int,sys.stdin.readline().split())
#맵 크기

maps = [0]*(n)
#맵 구현
for i in range(n):
    maps[i] = list(map(int,sys.stdin.readline().split()))

#방향이동 0 북쪽 1 동쪽 2 남쪽 3 서쪽
dirX = [-1,0,1,0]
dirY = [0,1,0,-1]




def clean(maps,r,c,d):
    global answer
    #큐 생성
    que = deque()
    que.append([r,c,d])
    while que:
        r,c, d = que.popleft()
        maps[r][c] = 2
        newD = d
        flag = 0
        for _ in range(4):
            newD -= 1
            if newD <0:
                newD = 3
            # 전진
            x = r + dirX[newD]
            y = c + dirY[newD]

            if maps[x][y] == 0:
                maps[x][y] = 2
                answer +=1
                que.append([x,y,newD])
                flag = 1
                break
        #청소 불가능
        if flag == 0:
            a = r + dirX[(d+2)%4]
            b = c + dirY[(d+2)%4]
            if maps[a][b] == 1:
                return
            else:
                que.append([a,b,d])

answer = 1
clean(maps,r,c,d)
print(answer)