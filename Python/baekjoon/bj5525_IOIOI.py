import sys

n = int(sys.stdin.readline().rstrip())
m = int(sys.stdin.readline().rstrip())
s = sys.stdin.readline().rstrip()

nstring = "I" +"OI"*n
answer = 0
for i in range(len(s)):
    if i + len(nstring) <= len(s):
        if s[i:i + len(nstring)] == nstring:
            answer +=1
print(answer)