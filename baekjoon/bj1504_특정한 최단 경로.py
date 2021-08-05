# 유니온파인드?
# 다익스트라?

# 다익스트라 풀이로 해봄

# 2개의 정점을 지났는지 확인
# 시작점-v1 + v1-v2 + v2-도착점
# 시작점-v2 + v2-v1 + v1-도착점

import sys
from collections import defaultdict
from heapq import *

def dijkstra(start,end):
    global graph
    # 각 노드까지의 거리
    distances = [sys.maxsize]*(n+1)

    #초기값지정
    distances[start] = 0

    #초기값 넣기
    que = []
    heappush(que,[distances[start],start])

    while que:
        curDistance, curNode= heappop(que)
        if distances[curNode] < curDistance:
            continue
        else:
            for newNode, newDistance in graph[curNode]:
                distance = curDistance + newDistance
                if distance < distances[newNode]:
                    distances[newNode] = distance
                    heappush(que,[distance,newNode])
    
    return distances[end]

n,e = map(int,sys.stdin.readline().split())
graph = defaultdict(list)

for i in range(e):
    a,b,c = map(int,sys.stdin.readline().split())
    graph[a].append([b,c])
    graph[b].append([a,c])

v1,v2 = map(int,sys.stdin.readline().split())

v1Answer = dijkstra(1,v1) + dijkstra(v1,v2) + dijkstra(v2,n)
v2Answer = dijkstra(1,v2) + dijkstra(v2,v1) + dijkstra(v1,n)
#불가능 경로
if v1Answer >= sys.maxsize and v2Answer >= sys.maxsize:
    print(-1)
else:
    answer = min(v1Answer,v2Answer)
    print(answer)