# n과 m 응용

import sys

k = int(sys.stdin.readline().rstrip())
klist = list(map(str,sys.stdin.readline().split()))
visited = [0]*10
answer = []

def solve(stage,i,string):
    # 다 정했을 때
    if stage == k:
        if len(string) == k+1:
            answer.append(string)
        return

    if klist[stage] == "<":
        for j in range(i+1,10):
            if visited[j] == 0:
                visited[j] = 1
                solve(stage+1,j,string+str(j))
                visited[j] = 0
    else:
        for j in range(0,i):
            if visited[j] == 0:
                visited[j] = 1
                solve(stage+1,j,string + str(j))
                visited[j] = 0

for i in range(10):
    visited[i] = 1
    solve(0,i,str(i))
    visited[i] = 0

answer.sort()
print(answer[-1])
print(answer[0])