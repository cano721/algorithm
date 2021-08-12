# 100 10^2 10만 10^6 100 10^2 = 10^10 ..

# 전체는 못돔
# 큐로 앞가 뒤에서 빼기
# r은 적립해놨다가 홀수일때 한번만 뒤집기
import sys
from collections import deque

def ac(nlist,p):
    #리버스개수 파악
    cnt = 0
    #큐 만들기
    if nlist == "":
        que = deque()
    else:
        que = deque(nlist)

    #명령어 실행
    for command in p:
        if command == "R":
            cnt +=1
        else:
            #지울게 없으면 에러
            if len(que) == 0:
                return "error"
            
            #리버스개수에 따른 첫숫자 버리기
            if cnt %2 == 0:
                que.popleft()
            else:
                que.pop()
    
    if cnt %2 == 1:
        que.reverse()
    
    return que


            

#테스트케이스 수
t = int(sys.stdin.readline())

#테스트 케이스 반복
for _ in range(t):
    p = list(sys.stdin.readline().rstrip())
    n = int(sys.stdin.readline())
    nlist = sys.stdin.readline().rstrip()
    if n == 0:
        nlist = ""
    else:
        nlist = nlist[1:-1].split(",")
    result = ac(nlist,p)

    if result == "error":
        print(result)
    else:
        answer = "[" + ",".join(result) + "]"
        print(answer)