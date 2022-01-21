from collections import deque
import sys

n,m,h = map(int,sys.stdin.readline().split())

# 맵
maps = [[0]*(n+1) for _ in range(h+1)]

for _ in range(m):
    a,b = map(int,sys.stdin.readline().split())
    maps[a][b] = 1


# 체크함수
# def check():
#     flag = True
#     que = deque()
#     for i in range(1,n+1):
#         que.append([1,i])

#         while que:
#             x,y = que.popleft()
#             # 마지막번일경우
#             if x == h+1:
#                 # 시작세로선으로 안 끝나면
#                 if y != i:
#                     # False로 변경
#                     flag = False
#                 # 마지막번일경우 큐 그만 돌기
#                 que.clear()
#                 break
#             # 좌로 이동할 경우 좌표 안에 있고 가로선이 있을 경우
#             if 1 <= y-1 < n+1 and maps[x][y-1] == 1:
#                 que.append([x+1,y-1])
#             # 우로 이동할 경우 좌표 안에 있고 가로선이 있을 경우
#             elif 1 <= y+1 < n+1 and maps[x][y] == 1:
#                 que.append([x+1,y+1])
#             # 다 해당 없을경우 한칸 밑 이동
#             else:
#                 que.append([x+1,y])
        
#         if flag == False:
#             return flag

#     return flag

def check() :
    # 모든 세로선 탐색
    for ii in range(1,n+1) :
        num = ii
        for jj in range(1,h+1) :
            if maps[jj][num] == 1 :
                num += 1
            elif maps[jj][num-1] == 1 :
                num -= 1
        if num != ii :
            return False
    return True


# 가로선 만들기 함수
def makeLine(stage,newi):
    global answer
    if stage > 3:
        return 0
    if check():
        answer = min(answer,stage)
        return
    for i in range(newi,h+1):
        for j in range(1,n):
            # 양옆과 본인자리에 가로선이 없을 경우 만들 수 있음
            if maps[i][j] == 0 and maps[i][j-1] == 0:
                # 우측 세로선이 있을경우
                if j+1 < n+1:
                    # 가로선이 그어져있으면 못 만듬
                    if maps[i][j+1] != 0:
                        continue
                # 가로선 만들고 체크
                maps[i][j] = 1
                makeLine(stage+1,i)
                maps[i][j] = 0
# 정답
answer = sys.maxsize

makeLine(0,1)
if answer == sys.maxsize:
    print(-1)
else:
    print(answer)
