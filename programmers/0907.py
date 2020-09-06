# 프로그래머스 여행경로 DFS
final = []


def solution(tick):
    answer = []
    temp = []
    visit = [0] * len(tick)
    # 가능한 경로가 많을 때, 알파벳 우선순위가 있으므로 정렬
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
            # 핵심포인트. dfs가 성공했다면 True를 반환 -> 계속 이어감.
            # False를 반환했다면, 연결이 되지 않는다. -> i는 방문하지 않은 것.
            visit[i] = 0
    temp.pop()
    return False
