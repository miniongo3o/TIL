# 프로그래머스 알고리즘 - 더 맵게
import heapq
def solution(sco, K):
    answer = 0
    heapq.heapify(sco)
    while True:
        temp=heapq.heappop(sco)
        if temp>=K:
            heapq.heappush(sco,temp)
            break
        else:
            if len(sco)==0:
                return -1
            temp2=heapq.heappop(sco)
            heapq.heappush(sco,temp+(temp2*2))
            answer+=1

    return answer



print(solution([2,1,3,9,10,12],7))