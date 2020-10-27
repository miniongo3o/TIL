# 백준 감시카메라
y,x=map(int,input().split())

# 1 : 상하/좌우
# 2 : 




arr=[]
camera=[]
for i in range(y):
    temp=list(map(int,input().split()))
    for j in range(len(temp)):
        if 0<temp[j]<6:
            camera.append([i, j])

    arr.append(temp)

for i in arr:
    print(i)


print(camera)



