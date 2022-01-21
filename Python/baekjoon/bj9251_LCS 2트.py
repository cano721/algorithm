#   A C A Y K P
# C 0 1 1 1 1 1
# A 1 1 2 2 2 2
# P 1 1 2 2 2 2
# C 1 2 2 2 2 2
# A 1 2 3 3 3 3
# K 1 2 3 3 4 4


import sys

# 스트링 저장
str1 = sys.stdin.readline().rstrip()
str2 = sys.stdin.readline().rstrip()

#LCS개수 저장 DP[str1길이][str2길이] 일때 = LCS길이
dp = [[0]*(len(str2)+1) for _ in range(len(str1)+1)]


for i in range(1,len(str1)+1):
    for j in range(1,len(str2)+1):
        #현재자리글자가 같을시
        if str1[i-1] == str2[j-1]:
            #기존조합 + 1
            dp[i][j] = dp[i-1][j-1] +1
        else:
            #다르면 
            dp[i][j] = max(dp[i-1][j],dp[i][j-1])

print(dp[-1][-1])

        