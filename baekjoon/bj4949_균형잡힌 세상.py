import sys

while True:
    string = sys.stdin.readline().rstrip()

    #종단조건
    if string == ".":
        break

    stack = []
    flag = True
    for i in string:
        if i == "(" or i == "[":
            stack.append(i)
        elif i == ")":
            if len(stack) < 1:
                flag = False
                break
            check = stack.pop()
            if check != "(":
                flag = False
                break
        elif i == "]":
            if len(stack) < 1:
                flag = False
                break
            check = stack.pop()
            if check != "[":
                flag = False
                break
    
    if len(stack) >0:
        flag = False
    
    if flag:
        print("yes")
    else:
        print("no")