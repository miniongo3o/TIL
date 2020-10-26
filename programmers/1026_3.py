def solution(m, n, board):
    answer = 0
    for i in range(m-1):
        for j in range(n-1):
            if board[i][j]==board[i+1][j]==board[i][j+1]==board[i+1][j+1]:
                print(i,j,board[i][j])

    for i in board:
        print(i)



    return answer

def moving(m,n,board):
    for i in range(n):
        for j in range(m):


solution(4,5,["CCBDE", "AAADE", "AAABF", "CCBBF"])


#CCBDE
#AAADE
#AAABF
#CCBBF


