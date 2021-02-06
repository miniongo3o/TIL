
def solution(A, B):
    answer = 0
    A.sort()
    B.sort(reverse=True)

    sums = 0
    for i, j in zip(A, B):
        sums += (i * j)
    answer = sums

    return answer