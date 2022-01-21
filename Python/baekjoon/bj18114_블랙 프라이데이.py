# dp 풀이로 할려했지만 시간초과
# 이분탐색으로 진행
# 두개의 아이템을 골라서 그값이 c이거나 c-두개의핪을 뺀게 아이템에 있는지 조사

# 이분탐색 실패
# 무게별로 아이템이 있는지 리스트를 만들어서 확인하는 형태로 n^2풀이 ㄱ

import sys

def check():
    for i in range(n):
        # 아이템 한개가 c이면 정답
        if items[i] == c:
            return 1
        for j in range(i+1,n):
            #두개의 아이템을 더했을 때 c 이면 정답
            if items[i]+items[j] == c:
                return 1
            #c에서 두개의 아이템합을 뺐을 때 그 무게의 아이템이 있을경우 정답
            else:
                weight = c - (items[i]+items[j])
                # 현재 뽑은 아이템이랑 같지 않아야한다(판매하는 물건의 무게는 다 다르다고 함)
                if weight != items[i] and weight != items[j] and checkList[weight]:
                    return 1
    
    return 0

#물건의 수 n 무게 c
n,c = map(int,sys.stdin.readline().split())

#아이템
items = list(map(int,sys.stdin.readline().split()))
items.sort(reverse=True)

#무게별 아이템이 있는지 체크
checkList = [0]*(10**8+1)
for i in items:
    checkList[i] = 1

print(check())


# def check():
#     for i in range(n):
#         for j in range(i+1,n):
#             if items[i]+items[j] == c:
#                 return 1
#             else:
#                 result = binary_search(start,end,c - items[i]+items[j])
#                 if result > 0:
#                     return 1
#     return 0

# #c - 2개아이템합 뺀게 아이템에 있는지 확인
# def binary_search(start,end,num):
#     if num < 0:
#         return 0
#     while start<= end:
#         mid = (start+end) //2

#         if items[mid] < num:
#             start = mid+1
#         elif items[mid] == num:
#             return 1
#         else:
#             end = mid-1

#     return 0

# #물건의 수 n 무게 c
# n,c = map(int,sys.stdin.readline().split())

# #아이템
# items = list(map(int,sys.stdin.readline().split()))
# items.sort()

# #시작 인덱스랑 최대 인덱스
# start = 0
# end = len(items)-1

# answer = check()
# print(answer)
