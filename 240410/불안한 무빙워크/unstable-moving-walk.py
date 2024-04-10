N, K = map(int, input().split())
moving_walk = list(map(int, input().split()))
persons = [0] * (N*2)
start_index = 0

def move():
    global start_index
    start_index = (start_index -1) % (N * 2)
def walk():
    global start_index
    next_people = [0] * (N * 2)
    end_idx = (start_index + N - 1) % (2 * N)

    next_one = end_idx
    for j in range(1, N):
        cur = (end_idx - j) % (2 * N)
        if persons[cur] and not next_people[next_one] and moving_walk[next_one] > 0:
            next_people[next_one] = 1
            moving_walk[next_one] -= 1
        else:
            next_people[cur] = persons[cur]
        next_one = cur

    for j in range(N * 2):
        idx = (start_index + j) % (N*2)
        persons[idx] = next_people[idx]

def go_up():
    global start_index
    if not persons[start_index] and moving_walk[start_index] > 0:
        moving_walk[start_index] -= 1
        persons[start_index] = 1
def count_block():
    num = 0
    for i in range(2 * N):
        if moving_walk[i] <= 0:
           num += 1
    if num >= K:
        return True
    return False
def go_down():
    global start_index
    end_idx = (start_index + N - 1) % (2 * N)
    if persons[end_idx]:
        persons[end_idx] = 0
i = 1
while True:
    move()
    go_down()
    walk()
    go_down()
    go_up()
    go_down()
    if count_block():
        break
    i += 1
print(i)