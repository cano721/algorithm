# 문제유형 파악실패


from collections import defaultdict, deque
import sys


def search():
    while minC<= maxC:
        mid = (minC+maxC) // 2  
        if bfs(mid):
            result = mid
            minC = mid+1
        else:
            maxC = mid -1

    return result


def bfs(mid):
    visited = [0]*(n+1)
    visited[start] = 1
    que = deque()
    que.append(start)

    while que:
        cur = que.popleft()
        if cur == end:
            return True

        for node,weight in graph[cur]:
            if visited[node] == 0 and weight>= mid:
                visited[node] = 1
                que.append(node)
    
    return False

# n 섬의 개수 m 다리개수
n,m = map(int,sys.stdin.readline().split())

#다리정보
graph = defaultdict(list)
maxC = -sys.maxsize
minC = 1

for i in range(m):
    a,b,c = map(int,sys.stdin.readline().split())
    graph[a].append([b,c])
    graph[b].append([a,c])
    maxC = max(maxC,c)

start,end = map(int,sys.stdin.readline().split())

print(search())
