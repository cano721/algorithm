# dfs를 통해 이동하면서
# 해당칸수가 기존 대나무보다 많으면 이동
# 정답을 맥스로 변경하면서 이동칸수 중 최대값 출력

# dfs로만 풀 경우 시간복잡도 초과..
# dp로 같은 dfs를 다시 들어오지 않게 설정해야함


import sys

sys.setrecursionlimit(1_000_000)

#dfs함수
def dfs(x,y):
    global answer

    #현재 좌표가 계산한 값일시
    if dp[x][y] != -1:
        return dp[x][y]
        
    #초기값
    dp[x][y] = 1

    #4방향 돌기
    for idx in range(4):
        newX = dirX[idx] + x
        newY = dirY[idx] + y
        # 맵안에서
        if 0<= newX < n and 0 <= newY < n:
            #이동한 자리가 현재 나무보다 많을 때
            if forest[x][y] < forest[newX][newY]:
                #최종 이동값이 담기게 됨
                dp[x][y] = max(dp[x][y],dfs(newX,newY)+1)

    return dp[x][y]
        
        

# 숲 크기
n = int(sys.stdin.readline().rstrip())

# 숲 생성
forest = [0]*n
for i in range(n):
    forest[i] = list(map(int,sys.stdin.readline().split()))

# 칸 방문 여부
dp = [[-1]*n for _ in range(n)]

# 4방향 체크
dirX = [0,0,-1,1]
dirY = [1,-1,0,0]

#정답
answer = 0


# 숲을 돌아다니면서 떨궈보기
for i in range(n):
    for j in range(n):
        answer = max(answer,dfs(i,j))

print(answer)