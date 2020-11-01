# 데이터 추가
##선형 리스트 구현
## 카톡 친구들의 선형 리스트
katok = [] #빈 배열

# 배열의 제일 뒤에 친구를 추가하는 함수
def  add_data(friend) :
    katok.append(None) # 빈칸 추가
    kLen = len(katok) # 배열의 현재 크기 확인
    katok[kLen-1] = friend #  배열 제일 뒤에 친구 추가

add_data('다현')
add_data('정연')
add_data('쯔위')
add_data('사나')
add_data('지효')
print(katok)

#####################################################################
# 데이터 삽입
katok = ['다현', '정연', '쯔위', '사나', '지효']


def insert_data(position, friend):
    katok.append(None)  # 빈칸 추가
    kLen = len(katok)

    for i in range(kLen - 1, position, -1):
        katok[i] = katok[i - 1]
        katok[i - 1] = None

    katok[position] = friend


insert_data(2, '솔라')
print(katok)
insert_data(5, '재남')
print(katok)
#####################################################################
# 데이터 삭제
def delete_data(position):
    klen=len(katok)
    katok[position]=None
    for i in range(position+1,klen):
        katok[i-1]=katok[i]
        katok[i]=None

    del(katok[klen-1])

delete_data(3)
print(katok)

#####################################################################
