import sys
from collections import deque

# 문자열 s
string = sys.stdin.readline().rstrip()
flag = 0
que = deque()
stack = ""
answer = ""
for i in range(len(string)):
    if string[i] == "<": #괄호 시작
        flag = 1 #괄호 시작으로 표기
        stack += string[i] # 괄호안에 쌓기
        que.reverse() # 괄호시작전 글 리버스
        answer += "".join(que) # 큐에 있는 목록 정답에 넣기
        que.clear() # 큐 비우기
    elif string[i] == ">": # 괄호 닫기
        flag = 0 # 괄호 닫음으로 표기
        stack += string[i] # 괄호 추가
        answer += stack # 정답에 넣기
        stack = "" # 괄호내용 비우기
    elif flag == 1: # 괄호안에 쌓기
        stack += string[i]
    elif string[i] == " ": # 공백만나면
        que.reverse() # 단어 뒤집기
        answer += "".join(que) # 큐에 있는 목록 정답에 넣기
        que.clear() # 큐 비우기
        answer += " "
    elif i == len(string)-1: #마지막자리에 괄호가 없을경우
        que.append(string[i])
        que.reverse() # 괄호시작전 글 리버스
        answer += "".join(que) # 큐에 있는 목록 정답에 넣기
        que.clear() # 큐 비우기
    else: # 괄호바깥 큐에 쌓기
        que.append(string[i])

print(answer)


