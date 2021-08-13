# 최단경로 알고리즘 다익스트라

#임의의 정점 두곳을 지나야함

# start -> v1 -> v2 -> end
# start -> v2 -> v1 -> end

# start-> v1까지 + v1->v2까지 + v2->end 형태로 합을 구할 수 있음

import sys
from collections import defaultdict
from heapq import *

def dijkstra(start,end):
    global n
    #각 정점까지의 거리
    distances= [sys.maxsize]*(n+1)
    distances[start] = 0
    que = []

    #탐색할 정점 집어넣기
    heappush(que,[distances[start],start])

    #정점과 이어진것 탐색하기
    while que:
        cur_distance,cur_node = heappop(que)

        if distances[cur_node] < cur_distance:
            continue
        
        for node,distance in graph[cur_node]:
            newDistance = distance + cur_distance
            if newDistance < distances[node]:
                distances[node] = newDistance
                heappush(que,[newDistance,node])
    
    return distances[end]

    

#정점의 수 n 간선의 수 e
n,e = map(int,sys.stdin.readline().split())

#간선 생성
graph = defaultdict(list)

for _ in range(e):
    a,b,c = map(int,sys.stdin.readline().split())
    graph[a].append([b,c])
    graph[b].append([a,c])

#두개의 정점
v1,v2 = map(int,sys.stdin.readline().split())

#두개의 정점을 지나는 최단 경로 구하기

answer1 = dijkstra(1,v1) + dijkstra(v1,v2) + dijkstra(v2,n)
answer2 = dijkstra(1,v2) + dijkstra(v2,v1) + dijkstra(v1,n)

#정답이 안나올경우
if answer1 >= sys.maxsize or answer2 >= sys.maxsize:
    print(-1)
#정답이 나오는경우 둘중에 최소값
else:
    print(min(answer1,answer2))

