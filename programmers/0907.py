# 프로그래머스 여행경로 DFS
final = []


def solution(tick):
    answer = []
    temp = []
    visit = [0] * len(tick)
    tick.sort()
    dfs("ICN", temp, 0, tick, visit, answer)
    print(final)
    return answer


def dfs(start, temp, cnt, tickets, visit, answer):
    temp.append(start)
    if cnt == len(tickets):
        answer = temp
        final.append(answer)
        return answer
    for i in range(len(tickets)):
        if tickets[i][0] == start and visit[i] == 0:
            visit[i] = 1
            success = dfs(tickets[i][1], temp, cnt + 1, tickets, visit, answer)
            if success:
                return True
            visit[i] = 0
    temp.pop()
    return False
