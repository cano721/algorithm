# 오른쪽,왼쪽 돌리면 벌어지는 결과를 저장

# 최대 맞추기위해 10번 돌릴 수 있음
# 만층까지 있음

import sys

n = int(sys.stdin.readline())
start = ['0'] + list(sys.stdin.readline().rstrip())
end = ['0'] + list(sys.stdin.readline().rstrip())
answer = sys.maxsize

#dp = [[-1],[-1]...10개,
#       n+1개 생김]
# dp[현재나사위치][왼쪽으로 돌린횟수] = 최소돌려 현재나사위치 원하는숫자 맞춘 횟수
dp = [[sys.maxsize]*(10) for _ in range(n+1)]

#첫번째에서 왼쪽으로 돌린횟수들 초기값 넣기
for num in range(10):
    dp[0][num] = num

for i in range(1,n+1):
    #전에 왼쪽으로 돌린횟수
    for j in range(10):
        #현재위치의 숫자나사
        nowInt = int(start[i])
        #전에 왼쪽으로 돌린만큼 더해주기
        nowInt += j
        nowInt %= 10
        #원하는위치의 숫자나사
        wantInt = int(end[i])

        #왼쪽
        lcnt = wantInt - nowInt
        if lcnt < 0:
            lcnt += 10
        # dp[현재나사][(전에 왼쪽 돌린횟수 + 현재 왼쪽 돌린횟수) %10] = min(기존구한값,현재구한값)
        dp[i][(j+lcnt)%10] = min(dp[i][(j+lcnt)%10],dp[i-1][j] +lcnt)
        
        #오른쪽 (사실 10번이면 한바퀴니까 10-왼쪽으로 돌려서 맞출경우를 하면 된다)
        rcnt = nowInt - wantInt
        if rcnt < 0:
            rcnt += 10 
        #dp[현재나사][전에오른쪽 돌린횟수] = min(기존구한값,현재구한값)
        dp[i][j] = min(dp[i][j],dp[i-1][j] +rcnt)

#최종나사위치의 최소값을 정답값으로 처리
for i in range(10):
    answer = min(answer,dp[n][i])

print(answer)