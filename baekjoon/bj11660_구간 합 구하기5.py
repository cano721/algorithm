import sys,copy

# 맵 크기 n 테스트케이스 m
n,m = map(int,sys.stdin.readline().split())

#맵 생성
maps = []
for i in range(n):
    maps.append(list(map(int,sys.stdin.readline().split())))

# 누적 합 리스트
sumList = copy.deepcopy(maps)
for i in range(n):
    for j in range(n):
        if i==0 and j == 0:
            pass
        elif i == 0:
            sumList[0][j] += sumList[0][j-1]
        elif j == 0:
            sumList[i][0] += sumList[i-1][0]
        else:
            sumList[i][j] += sumList[i-1][j] + sum(maps[i][:j])

# 
for _ in range(m):
    x1,y1,x2,y2 = map(int,sys.stdin.readline().split())

    if x1 ==1 and y1 == 1:
        print(sumList[x2-1][y2-1])
    elif x1 == 1:
        print(sumList[x2-1][y2-1] - sumList[x2-1][y1-2])
    elif y1 == 1:
         print(sumList[x2-1][y2-1] - sumList[x1-2][y2-1])
    else:
        print(sumList[x2-1][y2-1] - sumList[x1-2][y2-1] - sumList[x2-1][y1-2] + sumList[x1-2][y1-2])
    
