# dp로 생각

#     1  2  3  4  5  6  7
# 6   0  0  0  0  0  13 13
# 4   0  0  0  8  8  13 13  
# 3   0  0  6  8  8  13 14
# 5   0  0  6  8  12 13 14

# 가방의 무게를 늘려가면서
# 해당 무게를 담을 수 있는지 파악
# 담을 수 있다면 가치를 담고
# 기존의것에서 남은 무게에 해당하는 위치값 더하기

# ex) 가방 무게가 3일때 물품(무게:3,가치:6) 담은후
#     가방 무게가 4에선 무게1만큼 더담을수있음.
#     하지만 기존 1에 해당하는값은 0임.
#     순차적으로 증가하여 7에 해당했을때
#     무게 4인 아이템 가치 8을 담으므로 총 14가 됨

import sys

#물품의 수 n 최대무게 k
n,k = map(int,sys.stdin.readline().split())

#물건 리스트
items = []
for i in range(n):
    items.append(list(map(int,sys.stdin.readline().split())))

#k에따른 가치합
dp = [[0]*(k+1) for _ in range(n)]

for i in range(n):
    for j in range(1,k+1):
        w = items[i][0]
        v = items[i][1]
        if w<= j:
            dp[i][j] = max(dp[i-1][j],dp[i-1][j-w]+v)
        else:
            dp[i][j] = dp[i-1][j]

print(dp[-1][-1])