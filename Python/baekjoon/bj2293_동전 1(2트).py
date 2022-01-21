import sys

#동전갯수 n 가치의 합 k원
n,k = map(int,sys.stdin.readline().split())

#동전 가치
coins = []
for _ in range(n):
    coins.append(int(sys.stdin.readline()))

