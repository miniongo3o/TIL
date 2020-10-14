import sys


def func():
    n, m = sys.stdin.readline().split()
    dic={}
    answer=[]
    for i in range(int(n)):
        temp=sys.stdin.readline().split()
        temp=temp[0]
        dic[temp]=True
    for i in range(int(m)):
        temp=sys.stdin.readline().split()
        if temp[0] in dic:
            answer.append(temp[0])
    return answer


if __name__ =="__main__":

    answer=func()

    answer.sort()
    print(len(answer))
    for i in answer:
        print(i)


# import sys
#
# n, m = map(int, sys.stdin.readline().split())
# a = set()
# b = set()
#
# for i in range(n):
#     a.add((sys.stdin.readline().split())[0])
#
# for i in range(m):
#     b.add((sys.stdin.readline().split())[0])
#
# l = list(a & b)
# print(len(l))
# for e in sorted(l):
#     print(e)