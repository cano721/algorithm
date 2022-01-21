# from collections import deque
# import sys

# n,k = map(int,sys.stdin.readline().split())
# times = [0]*100001

# def bfs(start,end):
#     que = deque()

#     que.append([start,str(start)])

#     while que:
#         node,vlist = que.popleft()

#         if node == end:
#             print(times[node])
#             print(vlist)
#             break

#         if node*2 < 100001 and node != 0:
#             if times[node*2] == 0:
#                 times[node*2] = times[node]+1
#                 que.append([node*2,vlist + " " + str(node*2)])

#         if node+1 < 100001:
#             if times[node+1] == 0:
#                 times[node+1] = times[node]+1
#                 que.append([node+1,vlist+ " " + str(node+1)])
        
#         if node -1 >= 0:
#             if times[node-1] == 0:
#                 times[node-1] = times[node]+1
#                 que.append([node-1,vlist + " " + str(node-1)])

# bfs(n,k)

from collections import deque
import sys

n,k = map(int,sys.stdin.readline().split())

# 시간 저장
times = [0]*100001
# 경로 저장
path = [0]*100001

def makePath(x):
    arr = []
    temp = x
    for _ in range(times[x]+1):
        arr.append(temp)
        temp = path[temp]
    print(' '.join(map(str,arr[::-1])))

def bfs(n,k):
    que = deque()
    que.append(n)

    while que:
        x = que.popleft()

        if x == k:
            print(times[x])
            makePath(x)
            return
            
        for i in (x+1,x-1,x*2):
            if 0 <= i < 100001 and times[i] == 0:
                que.append(i)
                times[i] = times[x]+1
                path[i] = x

bfs(n,k)