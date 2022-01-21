
import sys

# a = 1*1 1*2 1*3 1*4 1*5 1*6
#     2*1 2*2 2*3 2*4 2*5
#     3*1 3*2 3*3 3*4
#     4*1 4*2 4*3 4*4
#     5*1 5*2
#     6*1

n = int(sys.stdin.readline())
k = int(sys.stdin.readline())


start = 1
end = k
answer = 0
def binarySearch(start,end):
    global answer
    while start<= end:
        mid = (start+end)//2
        temp = 0
        for i in range(1,n+1):
            temp += min(mid//i,n)
        
        if temp>=k:
            answer = mid
            end = mid-1
        else:
            start = mid +1

binarySearch(start,end)
print(answer)
        
