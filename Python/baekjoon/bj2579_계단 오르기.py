# 연속된 3개의 계단은 밟을 수 없음
# 마지막 계단은 필수로 밟아야함

# 현재계단을 올수 있는 방법은
# 이전계단이랑 그이전계단

import sys

n = int(sys.stdin.readline())

dp = [0]*n

#계단별 점수
stairs = []
for _ in range(n):
    stairs.append(int(sys.stdin.readline()))


for i in range(n):
    if i == 0:
        dp[0] = stairs[0]
    elif i == 1:
        dp[1] = stairs[0] + stairs[1]
    elif i == 2:
        dp[2] = max(stairs[0]+stairs[2], stairs[1] + stairs[2])
    else:
        dp[i] = max(dp[i-3] + stairs[i-1] + stairs[i],dp[i-2] + stairs[i])

print(dp[n-1])

