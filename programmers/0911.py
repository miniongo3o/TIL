def solution(tri):
#


    answer=0
    h=len(tri)

    result=0
    for i in range(1,h):
        for j in range(len(tri[i])):

            if j==0 :
                tri[i][j]+=tri[i-1][j]
            elif j==i:
                tri[i][j]+=tri[i-1][j-1]
            else:
                a=tri[i][j]+tri[i-1][j]
                b=tri[i][j]+tri[i-1][j-1]
                tri[i][j]=max(a,b)





    return max(tri[h-1])