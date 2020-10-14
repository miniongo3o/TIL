li=[]
n=input()
for idx,i in enumerate(range(int(n))):
    tmp=input()
    cnt=0
    for j in tmp:
        if j.isdigit():
            cnt+=int(j)
    li.append((tmp,cnt))


li.sort(key=lambda x:(len(x[0]),x[1],x[0]))

for k in li:
    print(k[0])