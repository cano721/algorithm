# 상어가 공간을 bfs를 통해 이동
# 먹이를 발견했을때 이동거리와 좌표 저장
# 저장된 좌표들 중 우선조건에 맞는 물고기 먹기
# 그 좌표에서 다시 시작
# 불가능할때까지 진행

from collections import deque
from heapq import *
import sys

def eating(x,y):
    visited = [[0]*n for _ in range(n)]
    visited[x][y] = 1
    que = deque()
    que.append([x,y,0])

    # 먹을 수 있는 물고기가 담긴 힙
    fish = []

    while que:
        x,y,time = que.popleft()
        # 현재좌표의 물고기가 먹을 수 있는 거일때
        # 우선조건에 따르게 힙에 추가
        # 거리,가장위쪽,가장 왼쪽
        if 0 < space[x][y] < level:
            heappush(fish,[time,x,y])

        for idx in range(4):
            newX = dirX[idx] + x
            newY = dirY[idx] + y
            # 맵 내에 있을때
            if 0 <= newX < n and 0 <= newY < n:
                # 방문하지 않았을 때
                if visited[newX][newY] == 0:
                    # 이동 가능한경우
                    if space[newX][newY] <= level:
                        que.append([newX,newY,time+1])
                        visited[newX][newY] = 1
    
    # 먹을 수 있는 물고기가 있을때 우선조건에 따른 가장 앞의 값 반환
    if fish:
        return fish[0]
    else:
        return None


# 맵 크기
n = int(sys.stdin.readline())

# 공간 생성
space = [list(map(int,sys.stdin.readline().split())) for _ in range(n)]

# 현재레벨, 먹은숫자, 걸린시간
level = 2
eat = 0
allTime = 0

for a in range(n):
    for b in range(n):
        if space[a][b] == 9:
            x = a
            y = b
            space[a][b] = 0
            break

while True:
    dirX = [-1,0,1,0]
    dirY = [0,-1,0,1]

    # 먹을게 있는지 체크
    curAnswer = eating(x,y)

    # 결과값이 없으면 탈출
    if curAnswer == None:
        break
    
    time,x,y = curAnswer
    # 먹은 숫자 증가
    eat += 1
    # 이동시간 추가
    allTime += time
    # 먹은 자리 0으로 변환
    space[x][y] = 0

    # 레벨만큼 먹으면 레벨업. 먹은숫자는 초기화
    if eat == level:
        level += 1
        eat = 0

print(allTime)

    
    