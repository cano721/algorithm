def solution(sortedArray, findValue):
    answer = 0
    
    answer = twoPoint(sortedArray,0,len(sortedArray)-1,findValue)
    
    print(answer)
    return answer
    

def twoPoint(sortedArray,left,right,check):
    
    while left <= right:
        midNum = (left+right)//2
        
        if sortedArray[midNum] < check:
            left = midNum+1
        elif sortedArray[midNum] > check:
            right = midNum-1
        else:
            return midNum
    
    return -1



sortedArray = [1, 2, 5, 7, 10, 15, 18, 20]
findValue = 17
solution(sortedArray, findValue)