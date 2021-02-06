def rime(n):
    num=[1]*(n+1)
    for i in range(2,n+1):
        if num[i]==1:
            for j in range(i+i,n+1,i):
                num[j]=0
        if n%i==0:
            num[i]=3
    if num[n]!=0:
        return 1
    else:
        for i in range(len(num)):
            if i<2:
                continue
            if num[i]==3:
                return i


a=[1,2,3,4,5]
print(a[1+1:])
print(a[:1])