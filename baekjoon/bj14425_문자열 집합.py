import sys

n,m = map(int,sys.stdin.readline().split())
nlist = dict()

#정답
answer = 0

#집합 s 딕셔너리로 생성
for _ in range(n):
    data = sys.stdin.readline().rstrip()
    nlist[data] = 1

for _ in range(m):
    data2 = sys.stdin.readline().rstrip()
    #찾는 문자가 딕셔너리에 있을 경우
    if nlist.get(data2):
        #정답 1 증가
        answer += 1

print(answer)
