# 스택에 저장해두었다가 닫힐때 계산

import sys

string = sys.stdin.readline().rstrip()

stack = []

def check(string):
    result = 0

    for i in string:

        if i == "]":
            temp = 0
            while stack:
                top = stack.pop()
                if top =="[":
                    if temp == 0:
                        stack.append(3)
                    else:
                        stack.append(3*temp)
                    break
                elif top == "(":
                    print("0")
                    return
                else:
                    if temp == 0:
                        temp = int(top)
                    else:
                        temp = temp+ int(top)

        elif i == ")":
            temp = 0
            while stack:
                top = stack.pop()
                if top =="[":
                    print("0")
                    return
                elif top == "(":
                    if temp == 0:
                        stack.append(2)
                    else:
                        stack.append(2*temp)
                    break
                else:
                    if temp == 0:
                        temp = int(top)
                    else:
                        temp = temp+ int(top)


        else:
            stack.append(i)
    
    for i in stack:
        if i == "(" or i=="[":
            print(0)
            return
        else:
            result += i
    
    print(result)

check(string)
