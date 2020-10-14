def solution(n):
    answer = 0
    li = ""
    temp = 0
    cnt = 0

    if n < 3:
        return n

    while True:
        temp = n % 3
        li += str(temp)
        n = n // 3
        if n < 3:
            li += str(n)
            break

    k = len(li) - 1
    for i in li:
        answer += int(i) * (3 ** k)
        k -= 1
    return answer
