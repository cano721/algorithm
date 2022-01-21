from collections import deque
import sys

# 트리의 노드 개수
n = int(sys.stdin.readline())

# 각 노드별 노드의 부모
nlist = list(map(int,sys.stdin.readline().split()))

# 큐 생성
que = deque()

# 트리 연결도
graph = [[0]*n for _ in range(n)]

for idx,i in enumerate(nlist):
    # 부모노드 넣어두기
    if i == -1:
        startNode = idx
        continue
    # 아니면 연결
    graph[i][idx] = 1

# 삭제 노드
dNode = int(sys.stdin.readline())

for i in range(n):
    graph[i][dNode] = 0
    graph[dNode][i] = 0


# 정답
cnt = 0

if startNode != dNode:
    que.append(startNode)

while que:
    cur = que.popleft()
    flag = False

    for idx,i in enumerate(graph[cur]):
        if i == 0:
            continue
        que.append(idx)
        flag = True
    if not flag:
        cnt += 1

print(cnt)