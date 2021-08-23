# dp 풀이로 할려했지만 시간초과
# 이분탐색으로 진행
# 무게를 지정해두고 그 조건이 맞는지 dp로 검사..?

import sys

def check():
    for i in range(n):
        for j in range(i+1,n):
            if items[i]+items[j] == c:
                return 1
            else:
                result = binary_search(start,end,c - items[i]+items[j])
                if result > 0:
                    return 1
    return 0

def binary_search(start,end,num):
    if num < 0:
        return 0
    while start<= end:
        mid = (start+end) //2

        if items[mid] < num:
            start = mid+1
        elif items[mid] == num:
            return 1
        else:
            end = mid-1

    return 0

#물건의 수 n 무게 c
n,c = map(int,sys.stdin.readline().split())

#아이템
items = list(map(int,sys.stdin.readline().split()))
items.sort()

start = 0
end = len(items)-1
result = 0

answer = check()
print(answer)