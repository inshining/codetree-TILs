import heapq
Q = int(input())

MAX_R = 10000001
N, M, P = 0, 0, 0
rabbits = []
scores = {}
distance = [0] * MAX_R

def init(inputs):
    global N, M, P, rabbits
    N, M, P, *temp = inputs
    for i in range(0, len(temp), 2):
        pid, d = temp[i], temp[i+1]
        rabbits.append((0, 0, 0, 0, pid))
        distance[pid] = d
        scores[pid] = 0
    heapq.heapify(rabbits)
def race(K, S):
    dy = [-1, 0, 1, 0]
    dx = [0, 1, 0, -1]
    can = set()
    for _ in range(K):
        r = heapq.heappop(rabbits)
        current_jump, _, r, c, pid = r
        rd = distance[pid]
        dir_q = []
        y_num = rd % ((N-1) * 2)
        x_num = rd % ((M-1) * 2)
        for i in range(4):
            nr, nc = r, c
            if dy[i] != 0:
                y_i = 0
                while y_i < y_num:
                    if nr + dy[i] < 0 or N <= nr + dy[i]:
                        i = (i+2) % 4
                    nr = nr + dy[i]
                    y_i += 1
            if dx[i] != 0:
                x_i = 0
                while x_i < x_num:
                    if nc + dx[i] < 0 or M <= nc + dx[i]:
                        i = (i+2) % 4
                    nc = nc + dx[i]
                    x_i +=1
            heapq.heappush(dir_q, (-(nr + nc), -nr, -nc))

        _, nr, nc = heapq.heappop(dir_q)
        nr = -nr
        nc = -nc

        heapq.heappush(rabbits, (current_jump+1, nr+nc, nr, nc, pid))
        for r_id in scores.keys():
            if pid ==r_id:
                continue
            scores[r_id] += nr + nc +2

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
        print(result)
        break