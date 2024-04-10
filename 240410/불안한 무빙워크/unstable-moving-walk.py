N, K = map(int, input().split())
moving_walk = list(map(int, input().split()))
persons = [1] + [0] * (N-1)

def move():
    back = moving_walk.pop(-1)
    moving_walk.insert(0, back)

    next_people = [0] * N
    for i in range(N-2, -1, -1):
        next_people[i+1] = persons[i]
    for i in range(N):
        persons[i] = next_people[i]

def walk():
    next_people = [0] * N
    for i in range(N-2, -1, -1):
        if persons[i]:
            if not next_people[i+1] and moving_walk[i+1] > 0:
                next_people[i+1] = 1
                moving_walk[i+1] -= 1
    for i in range(N):
        persons[i] = next_people[i]

def go_up():
    if not persons[0] and moving_walk[0] > 0:
        moving_walk[0] -= 1
        persons[0] = 1
def count_block():
    num = 0
    for i in range(N):
        if moving_walk[i] <= 0:
           num += 1
    if num >= K:
        return True
    return False
def go_down():
    if persons[N-1]:
        persons[N-1] = 0
i = 1
while True:
    move()
    go_down()
    walk()
    go_down()
    go_up()
    if count_block():
        break
    i += 1
print(i)