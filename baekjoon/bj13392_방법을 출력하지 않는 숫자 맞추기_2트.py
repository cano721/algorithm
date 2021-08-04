# 오른쪽,왼쪽 돌리면 벌어지는 결과를 저장

# 최대 맞추기위해 10번 돌릴 수 있음
# 만층까지 있음

import sys
sys.setrecursionlimit(100000)

n = int(sys.stdin.readline())
start = list(sys.stdin.readline().rstrip())
end = list(sys.stdin.readline().rstrip())

#dp = [[-1],[-1]...10개,
#       n+1개 생김]
dp = [-1]*n

for i in range(1,n+1):
    if dp[i] != -1:
        continue
    dp[i] = 

def solve(stage,leftTurn):
    nowInt = int(start[stage])
    wantInt = int(end[stage])

    nowInt = nowInt +leftTurn
    nowInt %= 10
    #왼쪽
    lcnt = wantInt - nowInt
    if lcnt < 0:
        lcnt += 10
    leftTurn += lcnt

    left = lcnt + solve(stage+1,leftTurn%10)
    dp[stage]
    #오른쪽
    rcnt = nowInt - wantInt
    if rcnt < 0:
        rcnt += 10

    right = rcnt + solve(stage+1,leftTurn)
    answer = min(left,right)
    return answer

print(solve(0,0))