import sys

m = int(sys.stdin.readline())

setList = dict()
for _ in range(m):
    command = list(map(str,sys.stdin.readline().split()))

    if command[0] == "add":
        setList[command[1]] = 1
    elif command[0] == "remove":
        if setList.get(command[1]):
            del setList[command[1]]
    elif command[0] == "check":
        if setList.get(command[1]):
            print(1)
        else:
            print(0)
    elif command[0] == "toggle":
        if setList.get(command[1]):
            del setList[command[1]]
        else:
            setList[command[1]] = 1
    elif command[0] == "all":
        for i in range(1,21):
            setList[i] = 1
    elif command[0] == "empty":
        setList = dict()
