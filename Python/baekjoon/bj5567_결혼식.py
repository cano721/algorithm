# 유니온파인드로 풀어볼려고 했지만 애매한부분 있음
# 2차원배열로 n*n으로 친구여부 체크
# 그후 체크리스트를 만들어 bfs를 돌면서
# 친구 여부 체크


import sys
from typing import Deque

# 상근이 동기 수 n 상근이는 1
n = int(sys.stdin.readline())

# 친구리스트 길이 m
m = int(sys.stdin.readline())

# 참석자체크
friend = [0]*(n+1)

#친구 관계
graph = [[0]*(n+1) for _ in range(n+1)]
for _ in range(m):
    f1,f2 = map(int,sys.stdin.readline().split())
    graph[f1][f2] = 1
    graph[f2][f1] = 1

# 큐 생성
que = Deque()

#상근이의 직접적인 친구 큐에 넣기
for i in range(2,n+1):
    if graph[1][i] == 1:
        que.append(i)
        friend[i] = 1

#상근이 친구의 친구 찾기
while que:
    #상근이 친구 cur
    cur = que.popleft()
    for idx in range(2,n+1):
        #상근이 친구의 친구면
        if graph[cur][idx] == 1:
            #참석자로 체크
            friend[idx] = 1

#참석자인원수 체크
print(sum(friend))


