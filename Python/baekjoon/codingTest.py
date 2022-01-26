n,m,k = map(int,input().split())
team = 0
while True :
    if n<2 or m<1:
        break
    n -= 2
    m -= 1
    team += 1

remain = (n + m) - k
if remain < 0:
    abs(remain)
else:
    print(team)

while remain < 0:
    team -= 1
    num = 3
    remain += 3
print(team)