# 일정부분에 괄호를 쳐서 최소 수로 만들것
#-가 한번이라도 나오면 그 뒤부턴 괄호를 통해 다 음수값으로 가능

import sys
flag = 0 # 마이너스가 한번이라도 들어가는가

#숫자 인덱스 분리 투포인터
start = 0
end = 0

#식
string = sys.stdin.readline().rstrip()

answer =0

for idx,i in enumerate(string):
    if i == "-":
        if flag == 0:
            flag = 1
            answer += int(string[start:end])
            start = end+1
            end += 1
        else:
            answer -= int(string[start:end])
            start = end+1
            end += 1

    elif i == "+":
        if flag == 0:
            answer += int(string[start:end])
            start = end+1
            end += 1
        else:
            answer -= int(string[start:end])
            start = end+1
            end += 1
    else:
        end += 1
        if idx == len(string)-1:
            if flag == 0:
                answer += int(string[start:end])
                start = end+1
                end += 1
            else:
                answer -= int(string[start:end])
                start = end+1
                end += 1

print(answer)