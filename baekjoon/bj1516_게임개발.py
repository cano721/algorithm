#위상정렬!


import sys
from collections import deque


def topological():
    que = deque()
    for i in range(1,n+1):
        if indegree[i] == 0: #첫번째 건물 넣기
            que.append(i)
    while que:
        cur = que.popleft()
        for i in range(len(graph[cur])): #해당건물을 지은후 지어져야하는 다른 건물들 돌기
            next = graph[cur][i] #다음 건물
            # 현재값과 사전에 구해둔 값 비교하여 맥스값 저장
            buildingtime[next] = max(buildingtime[next],buildingtime[cur]+time[next])
            indegree[next] -= 1
            # 사전에 지어야하는 건물들을 다 지었고 계산 끝났으면 큐에 넣기
            if indegree[next] == 0:
                que.append(next)

#건물의 수
n = int(sys.stdin.readline())

time = [0] # 각건물 짓는시간
buildingtime = [0]*(n+1) # 각건물까지 완성 짓는 시간
graph = [[] for _ in range(n+1)] # 건물별 사전지어야하는 건물

indegree = [0]*(n+1) # 건물연결

for i in range(1,n+1):
    buildings = list(map(int,sys.stdin.readline().split()))
    time.append(buildings[0]) #맨 앞의 원소는 해당건물 짓는 시간
    for j in buildings[1:-1]: # 해당 건물 짓기전 완성해야하는 건물들
        graph[j].append(i)
    indegree[i] = len(buildings[1:-1]) # 몇개의 건물들을 완성해야하는지 저장
    buildingtime[i] = buildings[0] # 건물 완성시간 초기값 지정

topological()
for build in range(1,n+1):
    print(buildingtime[build])


