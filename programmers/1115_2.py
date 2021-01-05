def solution(ck, k):
    answer = []
    li=[]
    check("",ck,ck[0],li)
    li = check("", [1, 4, 2, 6, 5, 3], 0, [])
    li.sort(key=lambda x: len(x))
    length = len(li[-1])
    li = [i for i in li if len(i) == length]
    li.sort()
    answer=[ int(i) for i in li[k-1] ]


    return answer


def check(string,arr,num,li):
    # string이 주어진다.
    # idx 이후의 arr값중에서,
    # arr[idx]보다 크면 붙여서 리턴.

    for i in arr:
        if i>num:
            a=string + str(i)
            li.append(a)
            idx=arr.index(i)
            check(a,arr[idx:],arr[idx],li)

    # li.sort(key=lambda x:len(x))
    # length=len(li[-1])
    # li=[ i for i in li if len(i)==length]
    # li.sort()
    return li


solution([1,4,2,6,5,3],2)
