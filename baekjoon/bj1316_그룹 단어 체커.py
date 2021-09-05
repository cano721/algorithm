import sys
from typing import DefaultDict

n = int(sys.stdin.readline())

#단어리스트
words = []
for _ in range(n):
    words.append(sys.stdin.readline().rstrip())

#정답갯수
answer = n

for word in words:
    checkDic = DefaultDict(int)
    for i in range(len(word)):
        #연달아서 나온 알파벳이면 패스
        if i >0:
            if word[i] == word[i-1]:
                continue
        #처음 나온 알파벳이거나 연달아 나온 알파벳이 아니면
        #체크딕셔너리에 +1
        checkDic[word[i]] += 1
        #현재 알파벳이 두번 나온거면 정답 -1하고 다음 워드 확인
        if checkDic[word[i]] >1:
            answer -= 1
            break

print(answer)