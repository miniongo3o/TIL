# 함수 선언부
def printPoly(p_x):
    term=len(p_x)-1 #최고 차항
    polystr="P(x) = "

    for i in range(len(p_x)):
        coef=p_x[i] # 계수
        if coef>=0:
            polystr+='+'
        polystr+=str(coef)+'x^'+str(term)+' '
        term-=1

    return polystr

def calcPoly(xValue,p_x):
    term=len(p_x)-1 #최고 차항
    answer=0
    for i in range(len(p_x)):
        coef=p_x[i] # 계수
        answer+=(xValue**term)*coef
        term-=1
    return answer
# 전역 변수부
px=[4,3,0,2]
# 4x^2 + 3x^2 + 0x^1 + 2x^0


# 메인 코드부
if __name__=='__main__':
    print(printPoly(px))
    print(calcPoly(5,px))