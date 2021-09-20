import sys

m = int(sys.stdin.readline())

setList = set()
for _ in range(m):
    command = list(map(str,sys.stdin.readline().split()))

    if command[0] == "add":
        setList.add(command[1])
    elif command[0] == "remove":
        setList.discard(command[1])
    elif command[0] == "check":
        if command[1] in setList:
            print(1)
        else:
            print(0)
    elif command[0] == "toggle":
        if command[1] in setList:
            setList.discard(command[1])
        else:
            setList.add(command[1])
    elif command[0] == "all":
        setList = set( i for i in range(1,21))
    elif command[0] == "empty":
        setList.clear()