# # 정수 x 제공
# # dfs로 재귀
# # 각 계산값을 dp에 저장
# # 메모리 초과 실패

# import sys
# sys.setrecursionlimit(1_000_000)

# dp = [sys.maxsize]*((10**6)+1)

# answer = sys.maxsize


# def dfs(cnt,x):
#     global answer
#     # 1을 구했으면 정답 비교
#     if x == 1:
#         answer = min(cnt,answer)
#         return
    
#     #현재 x를 구하기까지 기존에 구한연산숫자가 더 적으면 중단  
#     if dp[x] <= cnt:
#         return

#     dp[x] = cnt

#     if x % 3 == 0:
#         dfs(cnt+1,x//3)
#     if x % 2 == 0:
#         dfs(cnt+1,x//2)
#     dfs(cnt+1,x-1)

# n = int(sys.stdin.readline())
# dfs(0,n)
# print(answer)


# 두번째 방법
# 바텀업 풀이
# 기존값들을 구해가면서 풀이

import sys

n = int(sys.stdin.readline())
dp = [0]*(n+1)

for i in range(2,n+1):
    dp[i] = dp[i-1] +1

    if i%3 == 0:
        dp[i] = min(dp[i],dp[i//3]+1)
    if i%2 == 0:
        dp[i] = min(dp[i],dp[i//2]+1)

print(dp[n])

