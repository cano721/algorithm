# 가장자리를 체크하여 0과 맞닿으면 줄이기
# 바깥쪽과 닿았느냐 안닿았느냐를 플래그로 선언하고
# 닿았으면 삭제

import sys,copy
from collections import deque

a,b = map(int,sys.stdin.readline().split())

# 맵 생성
maps = []
for _ in range(a):
    maps.append(list(map(int,sys.stdin.readline().split())))

# 좌표변경
dirX = [0,0,1,-1]
dirY = [1,-1,0,0]

# 정답
answerTime = 0
cheese = 0

def bfs(maps):
    que = deque()
    # 방문여부체크
    visited = [[0]*b for _ in range(a)]
    que.append([0,0])
    visited[0][0] = 1
    while que:
        cur = que.popleft()
        for idx in range(4):
            x = dirX[idx] + cur[0]
            y = dirY[idx] + cur[1]
            # 맵 범위내에 있으면
            if 0 <= x < a and 0 <= y < b:
                # 공기면서 방문 안했으면 방문한걸로 표시 및 큐에 추가
                if maps[x][y] == 0 and visited[x][y] == 0:
                    visited[x][y] = 1
                    que.append([x,y])
                # 치즈면 방문한걸로 표시하고 녹은걸로 변환
                elif maps[x][y] == 1 and visited[x][y] == 0:
                    visited[x][y] = 1
                    maps[x][y] = 0
    
    return maps

while True:
    # 현재 치즈여부 체크
    temp = 0
    for i in range(a):
        temp += maps[i].count(1)
    if temp == 0:
        break
    # 시간 1초 증가
    answerTime += 1
    # 현재 치즈 개수 저장
    cheese = temp
    # 치즈 녹이기
    maps = bfs(maps)

print(answerTime)
print(cheese)



                                
