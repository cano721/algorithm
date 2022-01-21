from collections import deque
import sys

t = int(sys.stdin.readline())

for _ in range(t):
    # 문서의개수 n 원하는 문서의 현재 위치 m
    n,m = map(int,sys.stdin.readline().split())

    #중요도 리스트
    importance = list(map(int,sys.stdin.readline().split()))
    # 디큐 구조
    que = deque()

    #출력번호
    answer = 0

    #큐 채우기
    for idx in range(len(importance)):
        que.append([importance[idx],idx])

    
    while que:
        #현재 문서
        document = que.popleft()
        #현재 문서가 가장 큰 중요치가 아니면
        if que and document[0] < max(que)[0]:
            que.append(document)
        else:
            #맞으면 인쇄
            answer += 1
            #현재 인쇄한 문서가 원하던 문서면 정답 출력
            if document[1] == m:
                print(answer)
                break