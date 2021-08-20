# dp로 풀 예정

# 1
# 1 100
# 1 100, 1 2 .. .1 100
# 1 100, 1 2 50 1 100
# 1 100, 1 2 50 60

import sys

#수열의 길이
n = int(sys.stdin.readline().rstrip())

#수열
alist = list(map(int,sys.stdin.readline().split()))

#dp 정답값 저장 : dp[최대맥스값]
dp = [0]*n

#맨초기값 저장
# for i in range(n):
#     dp[i] = alist[i]

dp[0] = alist[0]

for i in range(n):
    for j in range(i):
        if alist[i] > alist[j]: 
            dp[i]= max(dp[i],dp[j] +alist[i])


print(max(dp))
