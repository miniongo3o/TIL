# 프로그래머스 올바른 괄호
def solution(s):
    answer = True

    stack = []
    for i in s:
        if i == '(':
            stack.append(i)
        else:
            if len(stack) != 0:
                stack.pop()
            else:
                return False

    if len(stack) != 0:
        return False

    return True