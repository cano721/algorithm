# 우선순위 큐를 통한 최소숫자 기준으로 정렬
# 미드값 뽑아서 출력

import sys
from heapq import *

n = int(sys.stdin.readline())

left = []
right = []
for _ in range(n):
    num = int(sys.stdin.readline())
    if len(left) == len(right):
        heappush(left,(-num,num))
    else:
        heappush(right,(num,num))

    if len(left) >= 1 and len(right)>=1:
        if left[0][1] > right[0][1]:
            leftMaxNum = heappop(left)[1]
            rightMinNum = heappop(right)[1]
            heappush(left,(-rightMinNum,rightMinNum))
            heappush(right,(leftMaxNum,leftMaxNum))
    print(left[0][1])
