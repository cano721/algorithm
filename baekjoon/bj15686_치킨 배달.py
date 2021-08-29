# 각 집의 좌표와 치킨집의 좌표가 담긴 리스트를 만들기
# 치킨집을 m개 골랐을때 치킨거리와 도시치킨거리를 구해서
# 정답과 비교하여 최소값 저장

from collections import defaultdict
import sys

# 도시크기 n 치킨집갯수 m
n,m = map(int,sys.stdin.readline().split())

#도시 생성
city = [0]*(n+1)
for i in range(1,n+1):
    city[i] = [0] + list(map(int,sys.stdin.readline().split()))

# 집 좌표 리스트
homes = []
# 치킨집 좌표 리스트
chickens = []

# 집 좌표,치킨집 좌표 리스트에 담기
for i in range(1,n+1): 
    for j in range(1,n+1):
        if city[i][j] == 1:
            homes.append([i,j])
        if city[i][j] == 2:
            chickens.append([i,j])

#치킨집 고른 여부
visited = [0] * len(chickens)
#정답값
answer = sys.maxsize

# 치킨집 m개 고르기 stage가 고른갯수 i는 이전좌표를 다시 돌지않기 위한 변수
def solve(stage,i):
    global answer
    if stage == m:
        city_street = 0
        for home in homes:
            # 각 집의 치킨거리
            min_street = sys.maxsize
            for idx,chicken in enumerate(chickens):
                if visited[idx] == 1:
                    #집과 치킨집의 거리 구하기
                    distance = abs(home[0] - chicken[0]) + abs(home[1] - chicken[1])
                    #최소값으로 변경
                    min_street = min(distance,min_street)
            # 도시 치킨거리 구하기
            city_street += min_street
        # 최소 도시 치킨거리
        answer = min(answer,city_street)
        return

    #치킨집을 돌며 고르기
    for i in range(i,len(chickens)):
        if visited[i] == 0:
            visited[i] = 1
            solve(stage+1,i+1) # 다음 치킨집 고르러 가기
            visited[i] = 0

solve(0,0)
print(answer)








