
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
end = n*2

def binarySearch(start,end):
    
    while start<= end:
        mid = (start+end)//2

        
