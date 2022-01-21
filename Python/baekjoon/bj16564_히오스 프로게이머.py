# n의 범위가 백만 k 범위 1억
# 시간복잡도 걸림
# 팀 목표레벨 t를 기준으로 이분탐색 진행


import sys

def binarySearch(start,end,level,n,k):
    global answer
    while start<= end:
        #사용할 수 있는 레벨업수
        curK = k
        # 팀 목표 레벨
        mid = (start+end)//2

        for i in range(n):
            # 경험치 다 쓰면 나가기
            if curK < 0:
                break
            # 팀 목표레벨보다 낮다면 레벨업
            if level[i] < mid:
                curK -= (mid-level[i])
        
        #경험치 남았으면 목표레벨 증가
        if curK >= 0:
            start = mid +1
            answer = mid
        #경험치 부족이면 목표레벨 감소
        else:
            end = mid -1    


# 캐릭터 개수 n 레벨총합 k
n,k = map(int,sys.stdin.readline().split())

# 캐릭터 레벨 리스트
level = [0]*n

for i in range(n):
    level[i] = int(sys.stdin.readline())

# 팀 목표레벨 최소,맥스
start = 1
end = 1_000_000_000

#정답
answer = 0 

binarySearch(start,end,level,n,k)
print(answer)