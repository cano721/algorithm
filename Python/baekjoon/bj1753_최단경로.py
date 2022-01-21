# 다익스트라
# 정점별 정점까지의 최소거리를 저장
# 최소힙을 기준으로 거리 이동

import sys
from heapq import *
from collections import defaultdict

# 정점의개수 v 간선의 개수 e
v,e = map(int,sys.stdin.readline().split())

#시작 정점
k = int(sys.stdin.readline())


#연결 그래프 생성
graph = defaultdict(list)

#간선 연결
for i in range(e):
    start,end,weight = map(int,sys.stdin.readline().split())
    graph[start].append((end,weight))

#다익스트라
def dijkstra(graph,k):
    #각 노드까지의 거리가 담긴 딕셔너리
    distances = [sys.maxsize]*(v+1)

    #초기값
    distances[k] = 0
    #초기값 넣기
    que = []
    heappush(que,[distances[k],k])

    while que:
        curDistance,curNode = heappop(que)
        if distances[curNode] < curDistance:
            continue

        for newNode,newDistance in graph[curNode]:
            distance = curDistance + newDistance
            if distance < distances[newNode]:
                distances[newNode] = distance
                heappush(que,[distance,newNode])

    return distances

answerList = dijkstra(graph,k)
for node in range(1,v+1):
    if answerList[node] >= sys.maxsize:
        print('INF')
    else:
        print(answerList[node])