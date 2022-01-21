from itertools import combinations
from collections import Counter


def solution(orders, course):
    answer = []

    for c in course:
        temp = []
        for order in orders:
            combi = combinations(sorted(order),c)
            temp += combi
        odict = Counter(temp)

        if odict:
            maxNum = max(list(odict.values()))
            if maxNum >= 2:
                for key,value in odict.items():
                    if odict[key] == maxNum:
                        answer.append(''.join(key))

    return sorted(answer)


orders = ["ABCFG", "AC", "CDE", "ACDE", "BCFG", "ACDEH"]
course = [2,3,4]
solution(orders, course)
