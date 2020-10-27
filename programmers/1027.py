# 프로그래머스 스킬트리
def solution(skill, skill_trees):
    answer = 0
    for i in skill_trees:
        temp = ""
        for j in i:
            if j in skill:
                temp += j
        if temp in skill:
            cnt=0
            for i in range(len(temp)):
                if temp[i]==skill[i]:
                    cnt+=1

            if cnt==len(temp):
                answer+=1

    return answer
print(solution("CBD",["BACDE", "CBADF", "AECB", "BDA"]))