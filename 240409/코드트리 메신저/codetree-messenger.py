N, Q = map(int, input().split())
first_line = list(map(int, input().split()))
parents = [-1] + first_line[1:N+1][:]
powers = [0] + first_line[N+1:][:]
alarms = [True] * (N+1)

def go_up(_from, target, p):
    if not alarms[_from]:
        return
    if p <= 0:
        return
    if parents[_from] == target:
        global ans
        ans += 1
        return
    go_up(parents[_from], target, p-1)


for turn in range(Q-1):
    line = list(map(int, input().split()))
    command = line[0]
    if command == 200:
        _, c = line
        alarms[c] = not alarms[c]
    elif command == 300:
        _, c, power = line
        powers[c] = power
    elif command == 400:
        _, c1, c2 = line
        parents[c1], parents[c2] = parents[c2], parents[c1]
    elif command == 500:
        c = line[1]
        ans = 0
        for i in range(N, c, -1):
            go_up(i, c, powers[i])
        print(ans)