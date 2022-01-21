# 스트링을 쌓고 쌓은 스트링이
# 크로아티아 알파벳으로 변경이 가능하면 정답 +1
# 크로아티아 알파벳 변경여부 확인은 딕셔너리로 체크


import sys

#크로아티아 알파벳 체킹 딕셔너리
croatia = {"c=":1,"c-":1,"d-":1,"lj":1,"nj":1,"s=":1,"z=":1}

word = sys.stdin.readline().rstrip()

#현재 쌓인 스트링
string = ""

#정답
answer = 0

#단어 돌기
for i in word:
    string += i
    #스트링 3개짜리 확인
    if string == "dz=":
        answer += 1
        string = ""
    #3개되면 뒤에꺼 두개 확인
    elif len(string) > 2:
        string = string[-2:]
        #날라간 단어는 갯수로 체크
        answer += 1

    #현재 쌓인 스트링이 크로아티아 알파벳인지 체크
    if croatia.get(string):
        answer +=1
        string = ""

#남은 단어 더하기
answer += len(string)
print(answer)

