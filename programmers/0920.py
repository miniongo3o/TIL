cnt=int(input())
li=[]
core=[]
visit=[ [0]*cnt  for z in range(cnt)   ]
for i in range(cnt):
    temp=list(map(int,input().split()))
    li.append(temp)
    for j in range(len(temp)):
        if temp[j]==1:
            core.append([i,j])
            visit[i][j]=1


# 상하좌우

for i in li:
    print(i)

for y,x in core:

    if y==0 or x==0 or y==cnt-1 or x==cnt-1:
        continue
