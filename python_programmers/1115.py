def solution(board):
    global max_value
    max_value=-1
    global col
    col=[0]*8
    n=len(board)
    horsePosition(board, 0, n)

    return max_value


def isOk(level):
    global col
    for i in range(level):
        if col[level]==col[i]:
            return False
    return True

def horsePosition(arr, row, n):
    global max_value
    if row==n:
        total=0
        for i in range(n):
            total+=arr[i][col[i]]
        if total>max_value:
            max_value=total
        return
    for i in range(n):
        col[row]=i
        if(isOk(row)):
            horsePosition(arr, row + 1, n)