def x_straight(y,x,board,m):
    # x<m-4 일때가능.

    if x<=m-4:
        sums=0
        for i in range(4):
            sums+=board[y][x+i]
        return sums
    else:
        return 0
def y_straight(y,x,board,n):

    # y<n-4 일때가능.
    if y<=n-4:
        sums=0
        for i in range(4):
            sums+=board[y+i][x]
        return sums
    else:
        return 0
def rectangle(y,x,board,n,m):
    if y<=n-2 and x<=m-2:
        return board[y][x]+board[y][x+1]+board[y+1][x]+board[y+1][x+1]
    else :
        return 0
def thunder(y,x,board,n,m):
    li=[]

    if x<m-2 and y<n-1:
        li.append(board[y][x]+board[y][x+1]+board[y+1][x+1]+board[y+1][x+2])
    if x>0 and y<n-2:
        li.append(board[y][x]+board[y+1][x]+board[y+1][x-1]+board[y+2][x-1])
    if x>1 and y>0:
        li.append(board[y][x]+board[y][x-1]+board[y-1][x-1]+board[y-1][x-2])
    if x<m-1 and y>1:
        li.append(board[y][x]+board[y-1][x]+board[y-1][x+1]+board[y-2][x+1])


    if x<m-2 and y>0:
        li.append(board[y][x] + board[y][x+1] + board[y - 1][x + 1] + board[y-1][x+2])
    if y<n-2 and x<m-1:
        li.append(board[y][x] + board[y+1][x] + board[y+1][x + 1] + board[y+2][x + 1])
    if x>1 and y<n-1:
        li.append(board[y][x] + board[y][x-1] + board[y+1][x-1] + board[y+1][x-2])
    if y>1 and x>0 :
        li.append(board[y][x] + board[y-1][x] + board[y - 1][x - 1] + board[y - 2][x - 1])

    if len(li)==0:
        return 0
    else:
        return max(li)

def seven(y,x,board,n,m):
    # 7
    li=[]
    if x<m-1 and y<=n-3:
        li.append(board[y][x]+board[y][x+1]+board[y+1][x+1]+board[y+2][x+1] )
    if y<n-1 and x>1:
        li.append(board[y][x]+board[y+1][x]+board[y+1][x-1]+board[y+1][x-2])
    if x>0 and y<1:
        li.append(board[y][x]+board[y][x-1]+board[y-1][x-1]+board[y-2][x-1])
    if y>0 and x<m-2:
        li.append(board[y][x]+board[y-1][x]+board[y-1][x+1]+board[y-1][x+2])

    # mirror seven
    if y<n-1 and x<m-2:
        li.append(board[y][x] + board[y+1][x] + board[y+1][x+1] + board[y+1][x+2])
    if x>0 and y<n-2:
        li.append(board[y][x]+board[y][x-1]+board[y+1][x-1]+board[y+2][x-1] )
    if y>0 and x>1:
        li.append(board[y][x]+board[y-1][x]+board[y-1][x-1]+board[y-1][x-2] )
    if x<m-1 and y >1:
        li.append(board[y][x]+board[y][x+1]+board[y-1][x+1]+board[y-2][x+1] )

    if len(li)==0:
        return 0
    else:
        return max(li)

def mount(y,x,board,n,m):
    li=[]
    # ㅏ
    if x <m-1 and y <n-2:

        li.append(board[y][x]+board[y+1][x]+board[y+2][x]+board[y+1][x+1])
    # ㅓ
    if x != 0 and y <n-2:
        li.append(board[y][x] + board[y + 1][x] + board[y + 2][x] + board[y + 1][x - 1])

    # ㅗ
    if y!=0 and x<m-2:
        li.append(board[y][x]+board[y][x+1]+board[y][x+2]+board[y-1][x+1])
    # ㅜ
    if y!=n-1 and x<m-2:
        li.append(board[y][x] + board[y][x + 1] + board[y][x + 2] + board[y + 1][x + 1])

    if len(li)==0:
        return 0
    else:
        return max(li)




def tetromino(board,n,m):
    dy=[0,1,0,-1]
    dx=[1,0,-1,0]
    answer=[]
    for i in range(n):
        li=[]
        for j in range(m):
            li.append(x_straight(i,j,board,m))
            li.append(y_straight(i,j,board,n))
            li.append(rectangle(i,j,board,n,m))
            li.append(mount(i,j,board,n,m))
            li.append(seven(i,j,board,n,m))
            li.append(thunder(i,j,board,n,m))
            answer.append(max(li))

    return max(answer)

if __name__ =='__main__':
    n,m=map(int,input().split())
    board=[]
    for i in range(n):
        tmp=list(map(int,input().split()))
        board.append(tmp)

    answer=tetromino(board,n,m)


    print(answer)