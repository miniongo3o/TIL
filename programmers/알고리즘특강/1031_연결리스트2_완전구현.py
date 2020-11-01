# 함수 선언부
class Node():
    def __init__(self):
        self.data=None
        self.link=None
def deleteNode(findData):
    global memory,head,pre,current
    if head.data==findData:
        current=head
        head=head.link
        del(current)
        return
    current=head
    while current.link!=None:
        pre=current
        current=current.link
        if current.data==findData:
            pre.link=current.link
            del(current)
            return

def find_node(finddata):
    #찾으면 True 없으면 False
    global pre,current,memory,head

    cur=head
    while cur!=None:
        if cur.data==finddata:
            return True
        cur=cur.link
    return False

def printNode(head):
    cur=head
    while cur!=None:
        print(cur.data,end=' ')
        cur=cur.link
    print()
def insert_node(findData,inserData):
    global memory,head, pre, current

    if findData==head.data: ## 첫 노드가 찾는 데이터인 경우
        node=Node()
        node.data=inserData

        node.link=head
        head=node
        return

    # 두번째 노드 이후일 떄
    current=head
    while current.link!=None:
        pre=current
        current=current.link
        if current.data==findData:
            node=Node()
            node.data=inserData
            node.link=current
            pre.link=node
            return
    # 마지막까지 못 찾을 때, 마지막에 삽입
    node=Node()
    node.data=inserData
    current.link=node




# 전역 변수부
memory=[]
head,pre,current=None,None,None
dataAry=['다현','정연','쯔위','사나',"지효"]

# 메인 코드부
if __name__=="__main__":
    node=Node()
    node.data=dataAry[0]
    head=node
    memory.append(node)


    for data in dataAry[1:]:
        pre = node
        node=Node()
        node.data=data
        pre.link=node
    printNode(head)
    insert_node("다현","화사")
    insert_node("사나", "솔라")
    insert_node("마동석", "문별")

    printNode(head)

    deleteNode("솔라")
    printNode(head)
    print(find_node("화사"))
    print(find_node("솔라"))
    print(find_node("사나"))



