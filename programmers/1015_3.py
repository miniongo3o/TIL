import sys
n = int(sys.stdin.readline().strip())
li = []
answer = 0

for i in range(n):
    li.append(int(sys.stdin.readline().strip()))
li.sort(reverse=True)

for idx, i in enumerate(li, 1):
    money = i - (idx - 1)
    if money <= 0:
        break
    answer += money

print(answer)

