N = int(input())
height = N * 2 - 1
dp = []
for i in range(height):
    if i == 0 or i == height - 1:
        dp.append(list(map(int, input())))
    else:
        dp.append(list(map(int, input().split())))

for i in range(1,N):
    for j in range(len(dp[i])):
        if j == 0:
            dp[i][j] += dp[i-1][j]
        elif j == len(dp[i])-1:
            dp[i][j] += dp[i-1][j-1]
        else:
            dp[i][j] = max(dp[i-1][j-1]+dp[i][j],dp[i-1][j]+dp[i][j])


for i in range(N, height):
    for j in range(len(dp[i])):
        dp[i][j] = max(dp[i][j] + dp[i - 1][j + 1], dp[i][j] + dp[i - 1][j])

print(dp[-1][-1])