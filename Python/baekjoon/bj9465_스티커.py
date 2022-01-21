# dp로 풀 예정

# 2*n 배열을 만들어두고 순차적으로 그 스티커를 골랐을때의 max값 저장형태

import sys

#테스트케이스 수
t = int(sys.stdin.readline().rstrip())


for _ in range(t):
    n = int(sys.stdin.readline().rstrip())
    #스티커 배열
    sticker = [0]*2
    for i in range(2):
        sticker[i] = list(map(int,sys.stdin.readline().split()))
    
    #각 자리를 골랐을 때 최대값
    dp = [[0]*(n) for _ in range(2)]

    #정답
    answer = 0
    
    for a in range(n):
        for b in range(2):
            #초기값 설정
            if a == 0:
                dp[0][0] = sticker[0][0]
                dp[1][0] = sticker[1][0]
            elif a == 1:
                dp[0][1] = sticker[1][0] + sticker[0][1]
                dp[1][1] = sticker[0][0] + sticker[1][1]
            elif b == 0:
                #대각선값이나 대각선 한칸옆 중에 최대값 + 현재 스티커 값
                dp[b][a] = max(dp[b+1][a-2],dp[b+1][a-1]) + sticker[b][a]
            else:
                #대각선값이나 대각선 한칸옆 중에 최대값 + 현재 스티커 값
                dp[b][a] = max(dp[b-1][a-2],dp[b-1][a-1]) + sticker[b][a]
    
    for idx in range(2):
        answer = max(answer,max(dp[idx]))

    print(answer)
