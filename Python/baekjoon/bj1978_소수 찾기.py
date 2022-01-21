import sys,math

#소수 판별 함수
def tpnum(n):
    for i in range(2,int(math.sqrt(n))+1):
        if n%i == 0:
            return False
    
    return True

n = int(sys.stdin.readline())

nlist = list(map(int,sys.stdin.readline().split()))

answer = 0
for i in nlist:
    if i == 1:
        continue
    if tpnum(i):
        answer +=1

print(answer)
