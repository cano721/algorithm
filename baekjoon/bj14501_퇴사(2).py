def solution(numbers):
    answer = 0
    check = [i for i in range(0,10)]
    for i in check:
        if not i in numbers:
            answer += i
    print(answer)
    return answer

numbers = [1,2,3,4,6,7,8,0]
solution(numbers)