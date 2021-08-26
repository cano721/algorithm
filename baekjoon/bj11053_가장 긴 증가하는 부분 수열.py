import sys

n = int(sys.stdin.readline())
nlist = list(map(int,sys.stdin.readline().split()))

#dp[현재길이][현재 맥스]

dp = [[0]*(n) for _ in range(n)]

#초기값 설정
for idx in range(n):
    dp[0][idx] = 1

for i in range(1,n):
    for j in range(0,n):
        #현재자리값이 기존맥스값보다 클때
        if j <= i:
            if nlist[i] > nlist[j]:
                #맥스값을 현재자리값으로하고
                #현재길이랑 기존맥스값 +1한것중 긴 길이로변경
                dp[i][i] = max(dp[i][i],dp[i-1][j]+1)
                dp[i][j] = max(dp[i][j],dp[i-1][j])
            #현재자리값보다 기존맥스값이 클때는 변동없음
            else:
                dp[i][j] = max(dp[i][j],dp[i-1][j])
        else:
            dp[i][j] = max(dp[i][j],dp[i-1][j])

print(max(dp[n-1]))