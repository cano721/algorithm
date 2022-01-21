#누적합 풀이

import sys

# 날짜수 n 연속적인 날짜의 수 k
n,k = map(int,sys.stdin.readline().split())

# 온도 리스트
temperature = list(map(int,sys.stdin.readline().split()))

# 전체 합계 리스트
sumList = [0]
temp = 0

for i in temperature:
    temp += i
    sumList.append(temp)

# 온도 합계 리스트
tempSum = []

for i in range(len(temperature)):
    # 연속적인 날짜를 다 더할 수 있을때
    if i+k <= len(temperature):
        # 3~7은 7번까지 다더한거에서 2번까지더한걸 빼면 됨
        tempSum.append(sumList[i+k]-sumList[i])

#그 중 최대값
print(max(tempSum))