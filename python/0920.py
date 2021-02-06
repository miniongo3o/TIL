# 백준 미세먼지 안녕!
def spread(temp,first_y):
    # 1. 5분의 1씩 퍼진다. 벽인 경우, 공기청정기인 경우 퍼지지 않는다.
    # 2. 소수점은 버린다.
    newarr=[ [0 for _ in temp[0]] for __ in temp  ]
    width=len(temp[0])
    height=len(temp)
    dx=[1,0,-1,0]
    dy=[0,1,0,-1]
    for i in range(height):
        for j in range(width):

            if temp[i][j]>0:
                first = temp[i][j]
                sums = 0
                for dir in range(4):
                    ny=i+dy[dir]
                    nx=j+dx[dir]

                    if nx >= 0 and ny >= 0 and nx < width and ny < height and temp[ny][nx]!=-1:
                        newarr[ny][nx]+=(first//5)
                        sums+=(first//5)
                newarr[i][j]+=first-sums
    newarr[first_y][0]=-1
    newarr[first_y+1][0] = -1
    # for i in newarr:
    #     print(i)
    return newarr

def cooling(y,temp):
    first_air,second_air=y,y+1
    max_x,max_y = len(temp[0]) - 1,len(temp)-1
    changed,changed2,tmp0=0,0,0


    # RIGHT MOVING
    for i in range(1,len(temp[0])):

        # first air
        tmp0=temp[first_air][i]
        temp[first_air][i]=changed
        changed=tmp0

        # second air
        tmp1=temp[second_air][i]
        temp[second_air][i]=changed2
        changed2=tmp1

    # UP
    for i in range(first_air-1,-1,-1):
        tmp0 = temp[i][max_x]
        temp[i][max_x]=changed
        changed=tmp0
    # DOWN
    for i in range(second_air+1,max_y+1):
        tmp0 = temp[i][max_x]
        temp[i][max_x]=changed2
        changed2=tmp0


    # LEFT MOVING
    for i in range(max_x-1,0,-1):
        tmp0=temp[0][i]
        temp[0][i]=changed
        changed=tmp0

        tmp1=temp[max_y][i]
        temp[max_y][i]=changed2
        changed2=tmp1
    # DOWN
    for i in range(first_air):
        tmp0=temp[i][0]
        temp[i][0]=changed
        changed=tmp0

    # UP
    for i in range(max_y,second_air,-1):
        tmp0=temp[i][0]
        temp[i][0]=changed2
        changed2=tmp0


    return temp
    # for i in temp:
    #     print(i)


##

    return 1
h,w,t=input().split()
h,w,t=int(h),int(w),int(t)
temp=[]
for i in range(h):
    tmp=list(map(int,input().split()))
    temp.append(tmp)

air=[]
for i in range(h):
    if temp[i][0]==-1:
        air.append([i,0])
        air.append([i+1,0])
        break

for i in range(t):
    temp=spread(temp,air[0][0])
    temp=cooling(air[0][0],temp)


answer=0
for i in temp:
    answer+=sum(i)

answer+=2
print(answer)




##