# 각각의 마을에서 x번 마을을 왔다 가는 시간 중 최대시간
# 최소시간으로 x번 마을에 가야하기에 다익스트라 적용
# x번마을에서 다시 현재마을로 돌아오는것도 구해야함!

from collections import defaultdict
from heapq import *
import sys

def dijkstra(start,end):
    #각 마을까지의 도착시간
    distances = [sys.maxsize for _ in range(n+1)]

    distances[start] = 0
    que = []
    #초기값 넣기
    heappush(que,[0,start])

    while que:
        curDistance, curNode = heappop(que)
        #현재거리가 기존의 구한값보다 크면 안해도됨
        if distances[curNode] < curDistance:
            continue
        #연결되어있는 다른 마을 갔을때
        for newNode,newDistance in street[curNode]:
            distance = newDistance + curDistance
            #현재 구해진 시간보다 적다면 바꿔주기
            if distances[newNode] > distance:
                distances[newNode] = distance
                heappush(que,[distance,newNode])

    return distances[end]

            

#n개의 마을 m개의 도로 x 도착지
n,m,x = map(int,sys.stdin.readline().split())

#도로
street = defaultdict(list)
for _ in range(m):
    start,end,time = map(int,sys.stdin.readline().split())
    street[start].append([end,time])

#정답
answer = 0

#마을에서 도착지까지갔다가 마을로 돌아온 최소시간들 중 가장 큰 시간이 정답
for i in range(1,n+1):
    mintime = dijkstra(i,x) + dijkstra(x,i)
    answer = max(answer,mintime)

print(answer)