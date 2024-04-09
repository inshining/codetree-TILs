N, Q = map(int, input().split())
first_line = list(map(int, input().split()))
parents = [0] + first_line[1:N+1][:]
powers = [0] + first_line[N+1:][:]
alarms = [True] * (N+1)
val = [0] * (N+1)

MAX_D = 22
dp = [[0] * MAX_D for _ in range(N+1)]

def init():
    for i in range(1, N+1):
        if powers[i] > 20:
            powers[i] = 20

    for idx in range(1, N+1):
        cur = idx
        x = powers[idx]
        dp[cur][x] += 1
        while parents[cur] and x:
            cur = parents[cur]
            x -= 1
            if x:
                dp[cur][x] += 1
            val[cur] += 1
def toggle_alarm(c):
    toggle = alarms[c]
    p = parents[c]
    num = 1
    while p:
        for i in range(num, MAX_D):
            val[p] += (-dp[c][i]) if toggle else dp[c][i]
            if i - num > 0:
                dp[p][i-num] += (-dp[c][i]) if toggle else dp[c][i]
        if not alarms[p]:
            break
        num += 1
        p = parents[p]
    alarms[c] = not alarms[c]

def change_power(c, power):
    before_p = powers[c]
    power = min(power, 20)
    powers[c] = power

    dp[c][before_p] -= 1

    if alarms[c]:
        cur = parents[c]
        num = 1
        while cur:
            if before_p >= num:
                val[cur] -= 1
            if before_p > num:
                dp[cur][before_p-num] -= 1
            if not alarms[cur]:
                break
            num += 1
            cur = parents[cur]

    dp[c][power] += 1

    if alarms[c]:
        cur = parents[c]
        num = 1
        while cur:
            if power >= num:
                val[cur] += 1
            if power > num:
                dp[cur][power-num] += 1
            if not alarms[cur]:
                break
            num += 1
            cur = parents[cur]

def change_chatter(chat1, chat2):
    ac1 = alarms[chat1]
    ac2 = alarms[chat2]

    if ac1:
        toggle_alarm(chat1)
    if ac2:
        toggle_alarm(chat2)

    parents[chat1], parents[chat2] = parents[chat2], parents[chat1]

    if ac1:
        toggle_alarm(chat1)
    if ac2:
        toggle_alarm(chat2)

def retrieve_chat(c):
    print(val[c])

init()

for _ in range(Q-1):
    q = list(map(int, input().split()))
    command = q[0]
    if command == 200:
        c = q[1]
        toggle_alarm(c)
    elif command == 300:
        _, c, power = q
        change_power(c, power)
    elif command == 400:
        _, c1, c2 = q
        change_chatter(c1, c2)
    elif command == 500:
        c = q[-1]
        retrieve_chat(c)