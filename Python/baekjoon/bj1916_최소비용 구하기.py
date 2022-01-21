# 최단거리 알고리즘
# 다익스트라 사용
# 비용저장하여 출력

import sys
from heapq import *
from collections import defaultdict

# 도시의 개수 n
n = int(sys.stdin.readline())

# 버스의 개수 m
m = int(sys.stdin.readline())

#연결 그래프
# graph = {}
# for node in range(1,n+1):
#     graph[node] = {}

graph = defaultdict(list)

# 버스정보
for _ in range(m):
    start,end,weight = map(int,sys.stdin.readline().split())
    graph[start].append((end,weight))

#출발지 도착지
startCity,endCity = map(int,sys.stdin.readline().split())

def dijkstra(graph,startCity):
    costs = [sys.maxsize] * (n+1)
    costs[startCity] = 0

    que = []
    heappush(que,[0,startCity])

    while que:
        curCost, curCity = heappop(que)
        if curCost > costs[curCity]:
            continue

        for nextCity,nextCost in graph[curCity]:
            cost = curCost + nextCost
            if costs[nextCity] > cost:
                costs[nextCity] = cost
                heappush(que,[cost,nextCity])

    return costs

costList = dijkstra(graph,startCity)
print(costList[endCity])