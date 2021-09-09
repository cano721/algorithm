# 1,2,3 합으로 7 만들기
# 정수 n 이 주어짐
# dp 로 풀예정

import sys

#테스트케이스 수
t = int(sys.stdin.readline())

# 나누는 수
divNum = 1_000_000_009


for _ in range(t):
    # 정수 n
    n = int(sys.stdin.readline())

    dp = [0]*(n+1)
    for i in range(1,n+1):
        # i=1,2,3 초기값 설정
        if i == 1:
            dp[i] = 1
        elif i == 2:
            dp[2] = dp[1]+1
        elif i == 3:
            dp[3] = dp[i-1] + dp[i-2]+1
        # 3이 적은수에서 3을 더해 만들수있고
        # 2가 적은수에선 2를 더해서 만듬
        # 1이 적은수에선 1을 더해 만들수있음
        else:
            dp[i] = (dp[i-1] + dp[i-2] + dp[i-3])%divNum

    print(dp[n]%divNum)