def solution(S):
    if "aaa" in S:
        return -1

    cnt = 0
    for i in range(len(S)):
        if S[i] != "a":
            cnt += 1

    max_a = cnt * 2 + 2

    max_a -= S.count("aa") * 2

    a_count = S.count("a")
    a_count_double = S.count("aa") * 2

    if a_count > a_count_double:
        max_a -= (a_count - a_count_double)

    return max_a


# In[55]:


solution("aabab")


# In[111]:


def solution(S):
    dic = {}
    for i in range(len(S)):
        temp_list = list(S[i])
        for j in range(len(temp_list)):
            if j not in dic:
                dic[j] = [temp_list[j]]
            else:
                if temp_list[j] in dic[j]:
                    target = dic[j].index(temp_list[j])
                    return [target, i, j]
                dic[j].append(temp_list[j])
    return []


# In[112]:


solution(["abc", "bca", "dbe"])


# In[167]:


def solution(A):
    length = len(A)
    A.sort()
    check = [0] * (length + 1)
    check[0] = 1
    temp_list = []
    for i in range(length):
        if check[A[i]] == 0:
            check[A[i]] = 1
        else:
            temp_list.append(i)

    temp_check = []
    for i in range(len(check)):
        if check[i] == 0:
            temp_check.append(i)
    answer = 0
    for i in range(len(temp_list)):
        answer += abs(A[temp_list[i]] - temp_check[i])
    return answer


# In[168]:


solution([1, 2, 1])
