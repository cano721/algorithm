# 오른쪽에만 붙일 수 있으므로
# 앞에서 몇개를 제외한 문자열이 팰린트롬인지 확인
# 그 후 제외한 문자갯수만큼 원래 문자열 개수에 추가하여 출력

import sys

s = sys.stdin.readline().rstrip()


for i in range(len(s)):
    if s[i:]==s[i:][::-1]:
        print(len(s)+i)
        break