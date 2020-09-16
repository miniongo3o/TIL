def solution(pri, loc):
    ans=[]
    li=[ [idx,i] for idx,i in enumerate(pri)]

    while len(li)!=0:
        mx=max(pri)
        tmp=li.pop(0)
        if mx==tmp[1]:
            ans.append(tmp[0])
            pri[tmp[0]]=0
        else:
            li.append(tmp)

    answer=ans.index(loc)+1



    return answer


print("answer is ",solution([2,1,3,2],2))
print("answer is ",solution([1, 1, 9, 1, 1, 1]	,0))