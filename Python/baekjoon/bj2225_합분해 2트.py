# k  n -> 
#   1 2 3 4 5
# 1 1 1 1  1 1
# 2 2 3 4  5 6      
# 3 3 6 10 15 21         
# 4 4 10
# 5


#위의 숫자와 옆의숫자를 더한형태

#dp로 풀이

import sys

n,k = map(int,sys.stdin.readline().split())

divNum = 1_000_000_000

#합 리스트
dp = [[0]*(k+1) for _ in range(n+1)]

#k ==1 일때 초기값 넣기
for i in range(1,n+1):
    dp[i][1] = 1

for i in range(1,n+1):
    for j in range(1,k+1):
        #n == 1일때
        if i == 1:
            dp[i][j] = j
        # 그외의 경우
        else:
            dp[i][j] = (dp[i-1][j] + dp[i][j-1])%divNum

print(dp[-1][-1]%divNum)