# bfs를 통해 이동
# 정해진 규칙에 따른 이동

from collections import deque
import sys

# 맵 크기
n = int(sys.stdin.readline())

maps = [[0]*(n) for _ in range(n)]

# 사과 개수
k = int(sys.stdin.readline())

for _ in range(k):
    #사과의 위치 행,열
    b,a = map(int,sys.stdin.readline().split())
    maps[b-1][a-1] = 1

# 뱀의 방향 변환 횟수 l
l = int(sys.stdin.readline())

#방향 전환 리스트
direction = deque()
for _ in range(l):
    direction.append(list(map(str,sys.stdin.readline().split())))

# 방향(오른쪽,아래,왼쪽,위)
dirX = [0,1,0,-1]
dirY = [1,0,-1,0]

#뱀 시작 위치
maps[0][0] = 2

#뱀꼬리 리스트
tails = deque()
tails.append([0,0])

que = deque()

#초기값 좌표랑 방향(0 -> 오른쪽), 시간
que.append([0,0,0,1])

#정답
answer = 0

while que:
    x,y,way,time = que.popleft()
    
    answer = max(answer,time)

    #현재 방향으로 이동
    nx = dirX[way] + x
    ny = dirY[way] + y

    #이동한 좌표가 갈수 있는 곳이면 큐에 추가
    if 0 <= nx < n and 0 <= ny < n and maps[nx][ny] != 2:
        #사과가 없는 곳으로 이동했다면 꼬리 칸 비워주기
        if maps[nx][ny] == 0:
            tail = tails.popleft()
            maps[tail[0]][tail[1]] = 0

        #이동한 곳을 뱀으로 표기
        maps[nx][ny] = 2

        #꼬리 리스트에 추가
        tails.append([nx,ny])

        #만약 현재타임이 방향전환 타임이면 방향전환
        if direction:
            if time == int(direction[0][0]):
                change = direction.popleft()
                if change[1] == "L":
                    if way == 0:
                        way = 3
                    else:
                        way = way-1
                else:
                    way = (way+1)%4
        que.append([nx,ny,way,time+1])

print(answer)
