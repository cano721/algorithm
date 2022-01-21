from collections import defaultdict
import sys,math

n = int(sys.stdin.readline())

nlist = []
ndict = defaultdict(int)
for _ in range(n):
    num = int(sys.stdin.readline())
    nlist.append(num)
    ndict[num] += 1

# 산술평균
print(round(sum(nlist)/n))
midNum = n//2
# 중앙값
print(sorted(nlist)[midNum])
# 최빈값
answerList = sorted(ndict.items(), key=lambda x:(x[1],-x[0]), reverse=True)
if len(answerList) > 1:
    if answerList[1][1] == answerList[0][1]:
        print(answerList[1][0])
    else:
        print(answerList[0][0])
else:
    print(answerList[0][0])

# 범위
print(max(nlist) - min(nlist))

