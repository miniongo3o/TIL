m,n=map(int,input().split())
dic={1:'one',2:'two',3:'three',4:'four',5:'five',6:'six',7:'seven',8:'eight',9:'nine',0:'zero'}
dic2={}
for i,j in dic.items():
    dic2[j]=int(i)
li=[ dic[i] if i<10 else dic[i//10]+" "+dic[i%10] for i in range(m,n+1)]


li.sort()
answer=[]
for idx,i in enumerate(li,1):
    if ' ' not in i:
        print(dic2[i],end=' ')

    else:
        first,second=i.split()
        #answer.append(dic2[first]*10+dic2[second])
        print(dic2[first]*10+dic2[second],end=' ')

    if idx%10==0:
        print()

#
# for idx,i in enumerate(answer,1):
#     if idx%10==0:
#         print(i)
#     else:
#         print(i,end=' ')