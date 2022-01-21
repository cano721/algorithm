# 인접차수를 넣어서 위상정렬로 풀이


from collections import deque,defaultdict
import sys

def topological():
    global answer
    que = deque()

    for i in range(1,n+1):
        if indegree[i] == 0:
            que.append(i)
            alltimes[i] = times[i]
    
    while que:
        node = que.popleft()

        for i in range(len(graph[node])):
            #다음작업
            nextWork = graph[node][i]
            
            alltimes[nextWork] = max(alltimes[nextWork],alltimes[node] + times[nextWork])
            # node 작업을 했으니 다음작업리스트들에서
            # 사전작업 개수 -1
            indegree[nextWork] -= 1
            if indegree[nextWork] == 0:
                que.append(nextWork)

n = int(sys.stdin.readline().rstrip())

#연결도 i작업후에 j 작업 있음
graph = defaultdict(list)

#먼저 작업해야하는 개수
indegree = [0]*(n+1)

#각 작업별 시간
times = [0]

#각 작업까지 걸린시간
alltimes = [0]*(n+1)

for i in range(1,n+1):
    works = list(map(int,sys.stdin.readline().split()))
    #작업별 걸리는 시간 추가
    times.append(works[0])
    #선행작업들
    work = works[2:]
    for j in work:
        #그래프에 추가
        graph[j].append(i)
    #i 작업전에 끝내야하는 작업들 수
    indegree[i] = works[1]

#정답
answer = 0

topological()
print(max(alltimes))