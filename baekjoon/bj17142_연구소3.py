#문제풀이
# 시간제한 10^8/4
# 맵에서 바이러스 고르기
# 고른 바이러스로 전파
# 최종 전파시 걸린 시간(마지막 전파가 기존 바이러스면 제외)
# n과 m 백트래킹으로 고르니 시간초과
# 콤비네이션으로 해결..
import sys,copy
from collections import deque
from itertools import combinations

n,m = map(int,sys.stdin.readline().split())
# 맵 생성
maps = []
for i in range(n):
    maps.append(list(map(int,sys.stdin.readline().split())))

# 바이러스 리스트
v = []
for i in range(n):
    for j in range(n):
        if maps[i][j] == 2:
            v.append([i,j,0])


# 방향탐색
dirX = [0,0,1,-1]
dirY = [1,-1,0,0]

# 정답
answer = sys.maxsize

# 다 채웠는지 확인 함수
def check(graph):
    for i in range(n):
        for j in range(n):
            if graph[i][j] == 0:
                return False
    
    return True

# 바이러스 선택함수
def choiceV(stage,newi):
    global answer
    if stage == m:
        answer = min(answer,bfs())
        return

    for i in range(newi,n):
        for j in range(n):
            if maps[i][j] == 2:
                maps[i][j] = 3
                choiceV(stage+1,i)
                maps[i][j] = 2

# 바이러스 채우기 함수
def bfs(choice,maps):
    que = deque()
    maps2 = copy.deepcopy(maps)

    que.extend(choice)

    # 다돌았을때 걸린 시간
    answerNum = 0

    #방문여부
    visited = [[0]*n for _ in range(n)]

    # 돌기
    while que:
        a,b,time = que.popleft()
        visited[a][b] = 1
        for idx in range(4):
            x = dirX[idx] + a
            y = dirY[idx] + b

            # 좌표내에있고 방문하지 않은 곳이면
            if 0 <= x < n and 0 <= y < n and visited[x][y] == 0 and maps2[x][y] != 1:
                visited[x][y] = 1
                # 방문하지않은곳이 빈칸이면
                # 마지막에 방문한곳이 빈칸이 아닐때를 가려내기위해
                # 이고셍 answerNum 변화를 일으킴
                if maps2[x][y] == 0:
                    maps2[x][y] = 3
                    answerNum = time+1
                que.append([x,y,time+1])
                
    
    # 다돌았는지 및 시간 체크
    flag = check(maps2)

    if flag:
        return answerNum
    else:
        return sys.maxsize


choiceV = list(combinations(v,m))

for choice in choiceV:
    result = bfs(choice,maps)
    if answer > result:
        answer = result

if answer == sys.maxsize:
    print(-1)
else:
    print(answer)