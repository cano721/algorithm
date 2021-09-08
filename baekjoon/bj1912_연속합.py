import sys

n = int(sys.stdin.readline())

nlist = list(map(int,sys.stdin.readline().split()))

dp = [0]*n
dp[0] = nlist[0]
for i in range(1,n):
    dp[i] = max(dp[i-1]+nlist[i],nlist[i])

print(max(dp))