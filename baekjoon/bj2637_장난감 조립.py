# 사전순서가 있으면 위상정렬 의심

# 위상정렬로 사전에 만들어야하는 개수를 체크

from collections import defaultdict, deque
import sys

def topological():
    que = deque()
    for i in range(1,n+1):
        if indegree[i] == 0:
            que.append(i)
        
    while que:
        #현재 부품
        cur = que.popleft()
        #사전 완료 부품 돌기
        for i in range(len(graph[cur])):
            #다음 부품
            nextWork = graph[cur][i]
            #관계대수 -1
            indegree[nextWork] -= 1
            if nextWork == n:
                workNum[cur] += works[nextWork][cur]
            if indegree[nextWork] == 0:
                que.append(nextWork)

#완제품 번호
n = int(sys.stdin.readline().rstrip())
#부품들 관계 수
m = int(sys.stdin.readline().rstrip())

#관계대수
indegree = [0]*(n+1)

#연관관계
graph = defaultdict(list)

#작업개수 저장
works = defaultdict(dict)

#작업수 저장
workNum = [0]*(n+1)

for _ in range(m):
    x,y,z = map(int,sys.stdin.readline().split())
    graph[y].append(x)
    works[x][y] = z
    indegree[x] += 1

topological()
# print(workNum)


for i in range(n,0,-1):
    if workNum[i] != 0:
        if works.get(i):
            for key,value in works[i].items():
                workNum[key] += workNum[i]*value
            workNum[i] = 0

for i in range(1,n+1):
    if workNum[i] != 0:
        print(str(i) + " " + str(workNum[i]))