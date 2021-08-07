# 이분그래프 뜻 파악 실패..
# bfs 돌면서 체크 만약 같은 그룹이면 NO를 출력

from collections import defaultdict, deque
import sys

def check(visited,graph,v):
    for node in range(1,v+1):
        if visited[node] == 0:
            visited[node] = 1
            que = deque()
            que.append(node)
            while que:
                cur = que.popleft()

                for i in graph[cur]:
                    if visited[i] == visited[cur]:
                        return "NO"
                    elif visited[i] == 0:
                        visited[i] = -1 * visited[cur]
                        que.append(i)
    
    return "YES"
#테스트케이스 수
k = int(sys.stdin.readline())

for _ in range(k):
    # 정점의 수 v 간선의 수 e
    v, e = map(int,sys.stdin.readline().split())
    #방문여부
    visited = [0]*(v+1)
    #연결 그래프
    graph = defaultdict(list)
    #연결
    for i in range(e):
        node1,node2 = map(int,sys.stdin.readline().split())
        graph[node1].append(node2)
        graph[node2].append(node1)

    print(check(visited,graph,v))
