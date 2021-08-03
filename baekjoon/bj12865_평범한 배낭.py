
import sys

#물품의수 n 버틸 수 있는 무게 k
n, k = map(int,sys.stdin.readline().split())

#아이템들 집합
items = [[0,0]]

#아이템들
for i in range(n):
    item = list(map(int,sys.stdin.readline().split()))
    items.append(item)

# dp[아이템][무게] = 가치
dp = [[0]*(k+1) for _ in range(n+1)]

for item in range(1,n+1):
    for weight in range(1,k+1):
        curWeight = items[item][0] #현재아이템의 무게
        curV = items[item][1] #현재 아이템의 가치
        if weight >= curWeight: # 지금 무게가 현재아이템의 무게와 같거나 클때
            #max(현재가치 + dp[이전아이템][가방무게-현재아이템무게], dp[이전아이템][가방무게])
            dp[item][weight] = max(curV + dp[item-1][weight - curWeight],dp[item-1][weight])
        else:
            #이전꺼 넣기
            dp[item][weight] = dp[item-1][weight]

print(dp[n][k])

