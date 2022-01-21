import sys,math

n = sys.stdin.readline().rstrip()

answer = 0
check = [0]*10
# 숫자 사용 개수 체크리스트
for num in n:
    check[int(num)] += 1

# 6과 9는 나중에 계산할것
for i in range(10):
    if i == 6 or i == 9:
        continue
    # 사용한 갯수중에 최대값으로 갱신
    else:
        answer = max(answer,check[i])
# 6과 9 사용 갯수 더한후에 2로 나누고 올림처리
nineSix = math.ceil((check[6] + check[9])/2)
# 기존 사용개수와 6과9개수중 최대값으로 갱신
answer = max(answer, nineSix)
print(answer)