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
        for next,cnt in graph[cur]:
            #차수 -1
            indegree[next] -= 1
            # 기본 부붐일경우
            if sum(works[cur]) == 0:
                works[next][cur] += cnt
            else:
                for i in range(1,n+1):
                    works[next][i] += works[cur][i] * cnt
            
            if indegree[next] == 0:
                que.append(next)

#완제품 번호
n = int(sys.stdin.readline().rstrip())
#부품들 관계 수
m = int(sys.stdin.readline().rstrip())

#차수
indegree = [0]*(n+1)

#연관관계
graph = defaultdict(list)

#작업개수 저장
works = [[0]*(n+1) for _ in range(n+1)]

for _ in range(m):
    x,y,z = map(int,sys.stdin.readline().split())
    graph[y].append([x,z])
    indegree[x] += 1

topological()
for idx,x in enumerate(works[n]):
    if x > 0:
        print(str(idx) + " " + str(x))
