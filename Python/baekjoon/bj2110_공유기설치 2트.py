import sys

# 집간의 설치 거리를 기준으로 이분탐색 진행
# 거리 이후의 집마다 설치하여 공유기 설치개수를 기준으로
# start end값 설정

#집의개수 n 공유기 개수 c
n,c = map(int,sys.stdin.readline().split())

#집 좌표 설정
homes = []
for i in range(n):
    homes.append(int(sys.stdin.readline()))
homes.sort()

#공유기간의 거리 설정
start = 1
end = homes[-1]-homes[0]

#정답
answer = 0

def binarySearch(start,end):
    global answer
    while start<=end:
        #공유기 거리
        mid = (start+end) // 2
        #공유기 개수
        cnt = 1
        #처음설치집이후 거리
        distance = homes[0]+mid
        #집돌기
        for i in range(1,n):
            #현재집이 설치한집에서 일정거리 이상일경우
            if homes[i] >= distance:
                #공유기설치
                cnt+=1
                #거리설정
                distance = homes[i] + mid
        
        if cnt >= c:
            start = mid +1
            answer = mid
        else:
            end = mid -1

binarySearch(start,end)
print(answer)