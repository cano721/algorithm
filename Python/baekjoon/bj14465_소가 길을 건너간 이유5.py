import sys

# 신호등개수 n 원하는 연속신호등 k 고장난 신호등개수 b
n,k,b = map(int,sys.stdin.readline().split())

#신호등
tl = [0]*(n+1)

#고장난 신호등 체크(1)
for _ in range(b):
    error_tl = int(sys.stdin.readline())
    tl[error_tl] = 1

# k개안에 고장난 신호등 개수 체크
error_tl_num = [0]
temp = 0
for i in range(1,len(tl)):
    temp += tl[i]
    error_tl_num.append(temp)

#수리해야할 신호등개수
answer = sys.maxsize

for i in range(len(tl)):
    # 이후로 k개의 신호등이 있을때
    if i+k < len(tl):
        #고장난 개수 파악하여 최소면 정답으로 변경
        answer = min(answer,error_tl_num[i+k]- error_tl_num[i])

print(answer)