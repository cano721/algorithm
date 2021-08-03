
import sys
from collections import deque

t = int(sys.stdin.readline())

def function(p,array):
    rcnt = 0
    for i in p:
        if i == "R":
            rcnt += 1
        else:
            if len(array) <1:
                return "error"
            if rcnt %2 == 1:
                array.pop()
            else:
                array.popleft()
    if rcnt %2 == 1:
        array.reverse()
    return array


for _ in range(t):
    p = sys.stdin.readline().rstrip()
    n = int(sys.stdin.readline())
    array = sys.stdin.readline().rstrip()
    array = array[1:-1].split(",")
    array = deque(array)
    if n == 0:
        array = deque()
    answer = function(p,array)
    
    if answer == "error":
        print(answer)
    else:
        answer = "[" + ",".join(answer) + "]"
        print(answer)