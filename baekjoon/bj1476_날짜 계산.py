import sys

e,s,m = map(int,sys.stdin.readline().split())
enum,snum,mnum = 0,0,0
answer = 0

while True:
    answer +=1
    enum += 1
    snum += 1
    mnum += 1
    if enum >=16:
        enum -= 15
    if snum >= 29:
        snum -= 28
    if mnum >=20:
        mnum -= 19
    if enum == e and snum == s and mnum == m:
        break

print(answer)