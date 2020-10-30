#tmp = [5,10,1,1,20,1]인데,
# return[1, 3, 2]해야돼

def solution(tmp):
    answer=[]

    idx=0
    # 순회를 시작할 인덱스. 처음에는 0으로 시작!

    while True:
        # 무한 루프를 도는데, 만약 현재 인덱스의 값보다 큰 값이 없다면, 현재부터 끝까지의 원소 갯수를 answer에 append하고 break.
        if max(tmp[idx:])==tmp[idx]:
            answer.append(len(tmp[idx:]))
            break


        cnt=0
        for i in range(idx+1,len(tmp)):
            cnt+=1
            # 순회하면서 자신보다 크지않으면 1씩 증가시킨다.
            if tmp[idx]<tmp[i]:
                # 만약 다음 인덱스(i)의 값이 현재 인덱스(idx)의 값보다 클 경우, 순회 시작 인덱스를 i로 바꿔서 다시 순회를 시작해야한다.
                idx=i
                answer.append(cnt)
                break
    return answer




def stack():
    tmp=[5,10,1,1,20,1]
    pop=-1
    cnt=0
    answer=[]

    for i in range(len(tmp),-1,-1):
        cnt+=1

        if pop<tmp[i]:
            answer.append(cnt)
            cnt=0
            pop=
        else:


    answer.append(cnt)
    return answer






print(solution([7,3,9]))
print(solution([5,10,1,1,20,1]))