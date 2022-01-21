import sys
input = sys.stdin.readline
country_number = int(input())
country_budget = list(map(int,input().split()))
budget = int(input())
start, end = 0, max(country_budget)
while (start <= end):
    # upper_cnt = 0
    country_budget_sum = 0
    mid = (start + end) // 2
    for i in country_budget:
        if i >= mid:
            country_budget_sum += mid
            # upper_cnt += 1
        else:
            country_budget_sum += i
    if (country_budget_sum > budget):
        end = mid - 1
    else:
        # if (budget - country_budget_sum) < upper_cnt:
        #     break
        start = mid + 1
print(mid)