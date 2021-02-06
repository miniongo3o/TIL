# 프로그래머스 2xn 타일링
def solution(n):
    a, b = 1, 1
    for i in range(n):
        a, b = b, a + b

    return a % 1000000007