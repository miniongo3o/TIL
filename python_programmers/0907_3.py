# 프로그래머스 카펫
def solution(bro, yel):
    # 가운데 노란색의 최소 크기는 1, 둘러싸고 있는 갈색은 +2(=3) 이므로 3부터 탐색 시작.
    # 가로가 세로보다 길기 때문에 넓이의 절반 전까지만 탐색.
    for i in range(3,(yel+bro)//2):
        if ((yel+bro) % i ==0) and yel== ((yel+bro)//i-2)*(i-2):
            return [(yel+bro)//i,i]
        # 여기서 i는 전체의 세로길이. => 전체/i = 가로길이
        # 확인해야 할 조건은 2가지.
        # 1.해당 숫자가 yellow+brown 합의 약수인가
        # 2. ( 전체 가로 - 2 )*(전체 세로 -2) = yellow 인가