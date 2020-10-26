def solution(record):
    answer = []
    chatting=[]
    nick={}
    for i in record:

        if i[0]=="E":
            msg,uid,name=i.split()
            if uid not in nick:
                nick[uid]=name
            else:
                nick[uid]=name
            chatting.append(['E',uid])
        elif i[0]=="L":
            msg, uid= i.split()
            chatting.append(['L',uid])
        else:
            msg,uid,name=i.split()
            nick[uid]=name

    for i in chatting:
        if i[0]=='L':
            answer.append(nick[i[1]]+"님이 나갔습니다.")
        else:
            answer.append(nick[i[1]]+"님이 들어왔습니다.")
    return answer


def solution(record):
    answer = []
    chatting = {}
    printer = ["님이 들어왔습니다.", "님이 나갔습니다."]
    for i in record:
        i = i.split()
        if i[0] in ["Change", "Enter"]:
            chatting[i[1]] = i[2]
    for i in record:
        i = i.split()
        if i[0] == "Enter":
            answer.append(chatting[i[1]] + printer[0])
        elif i[0] == "Leave":
            answer.append(chatting[i[1]] + printer[1])

    return answer
print(solution(["Enter uid1234 Muzi", "Enter uid4567 Prodo","Leave uid1234","Enter uid1234 Prodo","Change uid4567 Ryan"]))

a="neter uid1234 muzi"
