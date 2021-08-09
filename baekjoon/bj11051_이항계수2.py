import sys

n,k = map(int,sys.stdin.readline().split())

#이항계수 파악
#nCk 이므로
# nCk = n-1Ck-1 + n-1Ck 같음
#ex) 5C2 = 4C1 + 4C2
dp = [[1]*(n+1) for _ in range(k+1)]
for i in range(1,k+1):
    for j in range(i+1,n+1):
        dp[i][j] = (dp[i-1][j-1] + dp[i][j-1])%10007

print(dp[k][n])