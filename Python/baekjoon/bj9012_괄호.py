import sys

t = int(sys.stdin.readline())

for _ in range(t):
    case = sys.stdin.readline().rstrip()

    # VPS인지 체크
    flag = True
    # 몇개의 괄호가 열렸는지 저장
    stack = []
    for i in case:
        # 괄호가 열리면 스택에 저장
        if i == "(":
            stack.append(i)
        else:
            # 닫히면 스택에서 빼기
            if len(stack) > 0:
                check = stack.pop()
            else:
                flag = False
                break
    
    # 다 돌았는데 스택에 남아있다면 VPS가 아님
    if len(stack) > 0:
        flag = False

    if flag:
        print("YES")
    else:
        print("NO")