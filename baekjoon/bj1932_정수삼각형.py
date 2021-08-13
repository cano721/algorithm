# dp문제
#아래로 내려간 값들중 맥스값을 저장하면서 풀기

import sys

#삼각형의 크기
n = int(sys.stdin.readline().rstrip())

# 삼각형 생성
triangle = [0]*(n)
for i in range(n):
    triangle[i] = list(map(int,sys.stdin.readline().split()))

# 경로의 수 합
dp = [[0]*i for i in range(1,n+1)]
#초기값
dp[0][0] = triangle[0][0]

for i in range(1,n):
    for j in range(i+1):
        #그줄의 첫번째 자리는 윗줄의 첫번째자리에서밖에 못내려옴
        if j == 0:
            dp[i][j] = max(dp[i][j],dp[i-1][j]+triangle[i][j])
        #그줄의 마지막 자리는 윗줄의 마지막자리에서밖에 못내려옴
        elif j == i:
            dp[i][j] = max(dp[i][j], dp[i-1][j-1]+triangle[i][j])
        #두군데서 내려올 수 있음
        else:
            dp[i][j] = max(dp[i][j],dp[i-1][j-1]+triangle[i][j],dp[i-1][j]+triangle[i][j])

#마지막줄의 최대값
print(max(dp[-1]))
            
