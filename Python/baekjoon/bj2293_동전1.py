# 동전을 몇개 골라 k가 되는 방법의수 출력

# dfs로 풀 예정 시간복잡도는 모르겠음...
# dfs 실패 dp

# dp[총금액][사용 코인]


import sys


n,k = map(int,sys.stdin.readline().split())

coins = []
for _ in range(n):
    coins.append(int(sys.stdin.readline().rstrip()))

dp = [[0]*(k) for _ in range(n+1)]

for i in range(k):
    for j in range(n):
        if i == 0:
            dp[0][j] = coins[j]
        else:
            dp[i][j] = dp[i-1][]