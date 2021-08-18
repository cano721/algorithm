# dp로 적립하여 풀기

import sys

#자리 수
n = int(sys.stdin.readline().rstrip())

# dp = [자리수][맨끝에 끝나는 숫자]
dp = [[0]*(2) for _ in range(n+1)]


dp[1][1] = 1   # 1

for i in range(2,n+1):
    #앞전의 n의자리이친수의 0으로 끝나는것과 1의 끝나는것에서
    #0으로 끝나는게 가능
    dp[i][0] = dp[i-1][0] + dp[i-1][1]
    #앞전의 0으로 끝나는거에서만 1로 끝나는게 가능
    dp[i][1] = dp[i-1][0]

print(sum(dp[n]))