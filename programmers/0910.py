# 프로그래머스 가장 먼 노드
def solution(n, edge):
    answer = 0
    conn= [ [ 0 for i in range(n+1) ] for i in range(n+1) ]
    # conn=[[0]*(n+1)]*(n+1) 얘는 왜 안됐을까? 행이 다중복됐음...
    visit = [0] * (n + 1)
    for i in edge:
        y=i[0]
        x=i[1]
        conn[y][x]=1
        conn[x][y]=1

    for i in range(1,n+1):
        if conn[1][i]:
            dfs(i,0,visit,conn,n)

    return visit.count(max(visit))

def dfs(start,cnt,visit,conn,n):
    cnt+=1
    if visit[start]==0:
        visit[start]=cnt
        for i in range(2, n + 1):
            if conn[start][i]:
                dfs(i, cnt, visit,conn,n)

    else:
        if visit[start]<=cnt:
            return
        elif visit[start] > cnt: #새로운 경로가 더짧을때
            visit[start]=cnt
            for i in range(2, n + 1):
                if conn[start][i]:
                    dfs(i, cnt, visit, conn, n)
    # 각 dfs 마다 cnt ++

    # 이미 들른 곳이라면 최소값을.

solution(6,[[3, 6], [4, 3], [3, 2], [1, 3], [1, 2], [2, 4], [5, 2]])