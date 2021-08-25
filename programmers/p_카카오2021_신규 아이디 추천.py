# 구현 문제

def solution(new_id):
    answer = ''
    #1단계 대문자 소문자로 치환
    for word in new_id:
        if word.isupper():
            answer +=word.lower()
        else:
            answer += word
    #2단계
    answer2 = ''
    for word in answer:
        if word.isdecimal() or word.islower() or word == "-" or word == "_" or word == ".":
            answer2 += word
    
    #3단계
    answer3 = ''
    count = 0
    for word in answer2:
        if word == ".":
            if count == 0:
                count += 1
                answer3 += word
        else:
            count = 0
            answer3 += word
    
    #4단계
    answer4 = ''
    for idx,word in enumerate(answer3):
        if idx == 0 or idx == len(answer3)-1:
            if word == ".":
                continue
            else:
                answer4 += word
        else:
            answer4 += word


    #5단계
    if len(answer4) == 0:
        answer4 = 'a'

    #7단계
    while len(answer4) <= 2:
        answer4 += answer4[-1]
    
    #6단계
    if len(answer4) >15:
        answer4 = answer4[0:15]

    #6단계 이후 4단계로 한번 더 체크
    answer5 = ''
    for idx,word in enumerate(answer4):
        if idx == 0 or idx == len(answer4)-1:
            if word == ".":
                continue
            else:
                answer5 += word
        else:
            answer5 += word
    

    return answer5

new_id = "abcdefghijklmn.p"
print(solution(new_id))