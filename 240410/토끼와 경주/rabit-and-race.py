import heapq
Q = int(input())

MAX_R = 10000001
N, M, P = 0, 0, 0
rabbits = []
scores = {}
distance = [0] * MAX_R
round_score = 0

def init(inputs):
    global N, M, P, rabbits
    N, M, P, *temp = inputs
    for i in range(0, len(temp), 2):
        pid, d = temp[i], temp[i+1]
        rabbits.append((0, 0, 0, 0, pid))
        distance[pid] = d
        scores[pid] = 0
    heapq.heapify(rabbits)
def go_up(y,x,rd):
    rd %= 2 * (N-1)

    if rd >= y:
        rd -= y
        y = 0
    else:
        y -= rd
        rd = 0
    if rd >= N - y -1:
        rd -= (N - y - 1)
        y = N-1
    else:
        y += rd
        rd = 0

    y -= rd
    return y, x
def go_down(y,x,rd):
    rd  %= 2 * (N-1)

    if rd >= N - y -1:
        rd  -= (N - y -1)
        y = N-1
    else:
        y += rd
        rd = 0
    if rd >= y:
        rd -= y
        y = 0
    else:
        y -= rd
        rd = 0
    y += rd
    return y, x
def go_left(y,x,rd):
    rd %= 2 * (M-1)
    if rd >= x:
        rd -= x
        x = 0
    else:
        x -= rd
        rd = 0
    if rd >= M - x -1:
        rd -= (M - x -1)
        x = M -1
    else:
        x += rd
        rd = 0
    x -= rd
    return y,x
def go_right(y,x,rd):
    rd %= 2 * (M-1)
    if rd >= M - x - 1:
        rd -= (M -x-1)
        x = M-1
    else:
        x += rd
        rd = 0
    if rd >= x :
        rd -= x
        x = 0
    else:
        x -= rd
        rd =0
    x += rd
    return y,x
def race(K, S):
    K = min(100, K)
    dy = [-1, 0, 1, 0]
    dx = [0, 1, 0, -1]
    can = set()
    for _ in range(K):
        rabbit = heapq.heappop(rabbits)
        current_jump, _, r, c, pid = rabbit
        rd = distance[pid]
        dir_q = []
        nr,nc = go_up(r,c,rd)
        heapq.heappush(dir_q, (-(nr + nc), -nr, -nc))
        nr,nc = go_down(r,c,rd)
        heapq.heappush(dir_q, (-(nr + nc), -nr, -nc))
        nr,nc = go_left(r,c,rd)
        heapq.heappush(dir_q, (-(nr + nc), -nr, -nc))
        nr,nc = go_right(r,c,rd)
        heapq.heappush(dir_q, (-(nr + nc), -nr, -nc))
        _, nr, nc = heapq.heappop(dir_q)
        nr = -nr
        nc = -nc

        heapq.heappush(rabbits, (current_jump+1, nr+nc, nr, nc, pid))
        scores[pid] -= nr + nc + 2
        global  round_score
        round_score += nr + nc + 2

        can.add(pid)

    reward = []
    for _, _, r,c,pid in rabbits:
        if pid in can:
            heapq.heappush(reward, (-(r+c), -r, -c,-pid))
    _,_,_,pid = heapq.heappop(reward)
    pid = -pid
    scores[pid] += S

for _ in range(Q):
    line = list(map(int, input().split()))
    command = line[0]
    if command == 100:
        init(line[1:])
    elif command == 200:
        _, K, S = line
        race(K, S)
    elif command == 300:
        _, pid_t, L = line
        distance[pid_t] *= L
    elif command == 400:
        result = -1
        for k, v in scores.items():
            result = max(result, v)
        result += round_score
        print(result)
        break