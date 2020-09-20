def solution(cit):
    answer=0
    cit.sort()
    for idx,n in enumerate(cit):
        if n > len(cit)-idx-1:
            return len(cit)-idx
    return