# 둘로 분할되었을 때 하나라도 연결이 안되어있다면 이분 그래프 가능
# 유니온파인드로 전체 연결되어있는지 안되어있는지 확인
# 생각 실패 유니온파인드로는 전체이어져있는지는 확인 불가능

from collections import defaultdict, deque
import sys


#테스트케이스 수
k = int(sys.stdin.readline())

for _ in range(k):
    # 정점의 수 v 간선의 수 e
    v, e = map(int,sys.stdin.readline().split())
    #방문여부
    visited = [0]*(v+1)
    #정답
    answer = False
    #연결 그래프
    graph = defaultdict(list)
    #연결
    for i in range(e):
        node1,node2 = map(int,sys.stdin.readline().split())
        graph[node1].append(node2)

    que = deque()
    que.append(1)
    visited[1] = 1
    while que:
        cur = que.popleft()
        for i in graph[cur]:
            if visited[i] == 0:
                visited[i] = 1
                que.append(i)

    if sum(visited) == v:
        print("NO")
    else:
        print("YES")
