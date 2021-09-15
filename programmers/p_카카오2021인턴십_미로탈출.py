import sys
from heapq import *
import copy
from typing import DefaultDict

def solution(n, start, end, roads, traps):
    answer = 0
    # 연결그래프
    maps = DefaultDict(list)
    for v1,v2,time in roads:
        maps[v1].append([v2,time,True])
        maps[v2].append([v1,time,False])

    #트랩 체크
    trapCheck = [0]*(n+1)

    for i in traps:
        trapCheck[i] = 1
    
    def dijkstra():
        times = [sys.maxsize]*(n+1)

        times[start] = 0
        que = []
        heappush(que,[times[start],start,True])

        while que:
            curtime,curroom,flag = heappop(que)

            # if times[curroom] < curtime:
            #     continue
            # 현재 방문한 방이 함정이면
            if trapCheck[curroom]:
                if flag:
                    flag = False
                else:
                    flag = True
            
            if curroom == end:
                break
            #     #화살표 방향 체인지
            #     for i in range(1,n+1):
            #         if maps[i][curroom]:
            #             maps[curroom][i] = maps[i][curroom]
            #             maps[i][curroom] = 0
            #         elif maps[curroom][i]:
            #             maps[i][curroom] = maps[curroom][i]
            #             maps[curroom][i] = 0
            
            for next,nextTime,trap in maps[curroom]:
                
                #함정이면 함정길, 아니면 정상길 가기
                if trap == flag:
                    time = nextTime + curtime
                    if trapCheck[next]:
                        # 이동한 시간이 지금 저장된 시간보다 적다면
                        if time < times[next]:
                            #변경
                            times[next] = time
                        # 트랩이면 저장된시간보다 적지않아도 이동
                        heappush(que,[time,next,flag])
                    else:
                        # 이동한 시간이 지금 저장된 시간보다 적다면
                        if time < times[next]:
                            #변경
                            times[next] = time
                            #이동할 곳으로 넣어주기
                            heappush(que,[time,next,flag])
            
        return times[end]

    answer = dijkstra()

    print(answer)
    return answer

n = 4
start, end = 1 , 4
roads = 	[[1, 2, 1], [3, 2, 1], [2, 4, 1]]
traps = [2, 3]

solution(n, start, end, roads, traps)