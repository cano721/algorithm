from collections import deque
import sys

# 세로 가로 n, m 주사위좌표 x,y 명령개수 k
n,m,x,y,k  = map(int,sys.stdin.readline().split())

# 지도생성
maps =[]
for i in range(n):
    maps.append(list(map(int,sys.stdin.readline().split())))

maps[x][y] = 0

# 주사위 이동 명령
command = list(map(int,sys.stdin.readline().split()))


# 윗면,우,좌,상,하,뒷
dice = [0]*6

# 좌표이동
dirX = [0,0,0,-1,1]
dirY = [0,1,-1,0,0]


# 주사위 면변화 저장
def rolling(num):
    # 동쪽으로 굴릴때 면 변화
    if num == 1:
        temp = dice[0]
        dice[0] = dice[2]
        dice[2] = dice[5]
        dice[5] = dice[1]
        dice[1] = temp
    # 서쪽
    elif num == 2:
        temp = dice[0]
        dice[0] = dice[1]
        dice[1] = dice[5]
        dice[5] = dice[2]
        dice[2] = temp
    # 북쪽
    elif num == 3:
        temp = dice[0]
        dice[0] = dice[4]
        dice[4] = dice[5]
        dice[5] = dice[3]
        dice[3] = temp
    # 남쪽
    else:
        temp = dice[0]
        dice[0] = dice[3]
        dice[3] = dice[5]
        dice[5] = dice[4]
        dice[4] = temp

# 명령어 실행
for com in command:
    # 굴린방향에 따른 맵이동
    newX = x + dirX[com]
    newY = y + dirY[com]

    # 맵이동이 맵안에 있을 경우
    if 0 <= newX < n and 0 <= newY < m:
        # 좌표 변경
        x = newX
        y = newY
        # 주사위 면 변화
        rolling(com)
        # 이동한 좌표에 숫자가 없을 경우
        if maps[x][y] == 0:
            maps[x][y] = dice[5]
        # 숫자가 있을 경우
        else:
            dice[5] = maps[x][y]
            maps[x][y] = 0
    
        print(dice[0])







