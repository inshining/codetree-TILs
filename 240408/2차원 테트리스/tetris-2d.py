K = int(input())

score = 0
yellow = [[0] * 4 for _ in range(6)]
red = [[0] * 6 for _ in range(4)]

def find_red_pos(y):
    x = 0
    while x < 5:
        if red[y][x + 1] == 1:
            break
        x += 1
    return x

def find_yellow_pos(x):
    y = 0
    while y < 5:
        if yellow[y+1][x] == 1:
            break
        y += 1
    return y

def stack_red(t, y):
    if t == 1:
        x = find_red_pos(y)
        red[y][x] = 1
    elif t == 2:
        x = find_red_pos(y)
        red[y][x], red[y][x-1] = 1, 1
    elif t == 3:
        y1, y2 = y, y+1
        x1 = find_red_pos(y1)
        x2 = find_red_pos(y2)
        x = min(x1,x2)
        red[y1][x], red[y2][x] = 1, 1

def stack_yellow(t, x):
    if t == 1:
        y = find_yellow_pos(x)
        yellow[y][x] = 1
    elif t == 2:
        x1, x2 = x, x+1
        y1 = find_yellow_pos(x1)
        y2 = find_yellow_pos(x2)
        y = min(y1,y2)
        yellow[y][x1], yellow[y][x2] = 1, 1
    elif t == 3:
        y = find_yellow_pos(x)
        yellow[y][x], yellow[y-1][x] = 1, 1

def clean_red():
    global  score
    l = []
    for x in range(6):
        if 1 == red[0][x] == red[1][x] == red[2][x] == red[3][x]:
            l.append(x)
    if l:
        score += len(l)
        next_red = [[0] * 6 for _ in range(4)]
        idx = 5
        for x in range(5, -1, -1):
            if x in l:
                continue
            for y in range(4):
                next_red[y][idx] = red[y][x]
            idx -= 1
        for y in range(4):
            for x in range(6):
                red[y][x] = next_red[y][x]
def clean_yellow():
    global score
    l = []
    for y in range(6):
        if sum(yellow[y]) == 4:
            l.append(y)

    if l:
        score += len(l)
        next_yellow = [[0] * 4 for _ in range(6)]
        idx = 5
        for y in range(5, -1, -1):
            if y in l:
                continue
            for x in range(4):
                next_yellow[idx][x] = yellow[y][x]
            idx -= 1
        for y in range(6):
            for x in range(4):
                yellow[y][x] = next_yellow[y][x]

def check_light_red():
    num = 0
    for x in range(2):
        for y in range(4):
            if red[y][x]:
                num += 1
                break
    if num:
        next_red = [[0] * 6 for _ in range(4)]
        for x in range(6-num):
            for y in range(4):
                next_red[y][x+num] = red[y][x]

        for y in range(4):
            for x in range(6):
                red[y][x] = next_red[y][x]

def check_light_yellow():
    num = 0
    for y in range(2):
        for x in range(4):
            if yellow[y][x]:
                num += 1
                break
    if num:
        next_yellow = [[0] * 4 for _ in range(6)]
        for y in range(6-num):
            for x in range(4):
                next_yellow[y+num][x] = yellow[y][x]

        for y in range(6):
            for x in range(4):
                yellow[y][x] = next_yellow[y][x]

for _ in range(K):
    t, y,x = map(int, input().split())
    stack_red(t, y)
    stack_yellow(t, x)
    clean_yellow()
    clean_red()
    check_light_yellow()
    check_light_red()

print(score)
rest = 0

rest += sum(red, []).count(1)
rest += sum(yellow, []).count(1)

print(rest)