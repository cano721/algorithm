from collections import deque
import sys

n,k = map(int,sys.stdin.readline().split())

def dijstra(start,end):
    times = [sys.maxsize for _ in range(200001)]

    que = deque()
    que.append([start,0])

    while que:
        node,time = que.popleft()

        if times[node] <= time:
            continue

        times[node] = time

        if node*2 < 200001:
            que.append([node*2,time])
        if node+1 < 200001:
            if time+1 < times[node+1]:
                que.append([node+1,time+1])
        if node-1 >= 0:
            if time+1 < times[node-1]:
                que.append([node-1,time+1])
    
    return times[end]

print(dijstra(n,k))