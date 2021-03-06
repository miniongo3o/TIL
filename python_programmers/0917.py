# 프로그래머스 순위
def solution(n, results):
    answer = 0
    win = {x: set() for x in range(1, n + 1)}
    lose = {x: set() for x in range(1, n + 1)}
    for winner, loser in results:
        win[winner].add(loser)
        lose[loser].add(winner)

    for i in range(1,n+1):
        for winner in lose[i]:
            win[winner].update(win[i])
        for loser in win[i]:
            lose[loser].update(lose[i])
    print(lose)
    print(win)
    for i in range(1,n+1):
        if len(win[i])+len(win[i])==n-1:
            answer+=1

    return answer

solution(5,[[4, 3], [4, 2], [3, 2], [1, 2], [2, 5]]	)