# 유니온파인드?
# 다익스트라?

# 다익스트라 풀이로 해봄

# 이어진경로로 해당 지점까지 이동한걸 정답리스트에 담고
# 2개의 정점을 지났는지 확인

import sys
from collections import defaultdict
from heapq import *

n,e = map(int,sys.stdin.readline().split())
graph = defaultdict(list)


for i in range(e):
    a,b,c = map(int,sys.stdin.readline().split())
    graph[a].append([b,c])
    graph[b].append([a,c])

v1,v2 = map(int,sys.stdin.readline().split())

def dijkstra(graph):
    # 각 노드까지의 거리
    distances = [sys.maxsize]*(n+1)

    #초기값지정
    distances[1] = 0

    #방문여부 체크
    visited = [0] *(n+1)

    #초기값 넣기
    que = []
    endList = [1]
    heappush(que,[distances[1],1],endList)

    while que:
        curDistance, curNode,endList = heappop(que)
        if visited[v1] != 0 and visited[v2] != 0:
            if distances[curNode] < curDistance:
                continue
        else:
            for newNode, newDistance in graph[curNode]:
                distance = curDistance + newDistance
                if distance < distances[newNode]:
                    distances[newNode] = distance
                    endList.append(newNode)
                    heappush(que,[distance,newNode],endList)
    
    return distances

answerList = dijkstra(graph)
print(answerList)