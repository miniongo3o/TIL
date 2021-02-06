def solution(s):
    answer = 0
    li = []
    for i in s:
        if len(li) == 0:
            li.append(i)
        else:
            if li[-1] == i:
                li.pop()
                continue
            else:
                li.append(i)

    if len(li) == 0:
        return 1
    else:
        return 0
