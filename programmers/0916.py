def solution(pri, loc):
    ans=[]
    # answer는 'loc'번째 문서가 출력되는 순서이므로, idx,i로 묶어서 처리.
    li=[ [idx,i] for idx,i in enumerate(pri)]
    while len(li)!=0:
        # 주어진 우선순위 중에서 '가장 큰 값'과 현재 '확인하는 문서의 우선순위'가 일치하는지 확인.
        mx=max(pri)
        tmp=li.pop(0)
        # 일치한다면 임시 리스트에 넣어주고, 해당하는 index의 우선순위는 0으로 교체해준다.(그래야 계속 다른 max구할수있음)
        if mx==tmp[1]:
            ans.append(tmp[0])
            pri[tmp[0]]=0
        else:
            # 일치하지않으면, 해당 문서를 제일 뒤로 보내고 다시 반복.
            li.append(tmp)
    # 임시리스트는 우선순위가 높은 순서대로 [ 'index', '우선순위'] 형태로 입력되어있음.
    # 'loc'번째 문서의 출력 순서를 임시리스트에서 검색
    answer=ans.index(loc)+1
    return answer