import sys

n,k = map(int,sys.stdin.readline().split())
dp = [[1]*(n+1) for _ in range(k+1)]
num = 1000000000
# k와 n 테이블
#   n 1 2 3 4 5
# k   
# 1   1 1 1 1 1
# 2   2 3 4 5 6 
# 3   3 6 10 15 21
# 4   4 10 20 35 56
for i in range(1,k+1):
    for j in range(1,n+1):
        if i != 1:
            dp[i][j] = (dp[i-1][j] + dp[i][j-1])%num

print(dp[k][n])
        