def spread(temp):
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

    return newarr

def cooling(y,temp):
    first_air=y
    second_air=y+1
    def right_move(yy):
        temp[yy]
        pass




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
spread(temp)




