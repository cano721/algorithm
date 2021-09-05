numberList = [0]*10001

def calNum(number):
    answer = number
    while number > 0:
        answer += number % 10
        number //= 10
    return answer

for i in range(1,10000):
    check = calNum(i)
    if check <= 10000:
        numberList[check] = 1

for number in range(1,10000):
    if numberList[number] == 0:
        print(number)