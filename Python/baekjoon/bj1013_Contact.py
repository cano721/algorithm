
import sys
import re

# 테스트케이스 t
t = int(sys.stdin.readline().rstrip())

for _ in range(t):
    string = sys.stdin.readline().rstrip()

    p = re.compile('(100+1+|01)+')
    result= p.fullmatch(string)
    if result:
        print("YES")
    else:
        print("NO")




                

