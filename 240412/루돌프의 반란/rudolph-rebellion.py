from collections import deque
N, M, P, C, D = map(int, input().split())
RY, RX = map(int, input().split())
santas = dict()
stuns = [0] * (P+1)
scores = [0] * (P+1)

dy = [-1, -1, 0, 1, 1, 1, 0, -1]
dx = [0, 1, 1, 1, 0, -1, -1, -1]

def out(y,x):
	return y < 1 or N < y or x < 1 or N < x

for _ in range(P):
	pid, y,x = map(int, input().split())
	santas[pid] = (y,x)

def cal_distance(y1, x1, y2, x2):
	return (y1-y2) ** 2 + (x1-x2) ** 2
def choose_santa():
	can = []
	for i in range(1, P+1):
		y,x = santas[i]
		if out(y,x):
			continue
		dis = cal_distance(y,x,RY, RX)
		can.append((dis, y,x, i))
	can.sort(key=lambda  x: (x[0], -x[1], -x[2]))
	_, y,x,pid = can[0]
	return y,x,pid
def rudolph_move(r,c):
	path = []
	for i in range(8):
		ny = RY + dy[i]
		nx = RX + dx[i]
		if out(ny,x):
			continue
		dis = cal_distance(r,c,ny,nx)
		path.append((dis, ny,nx, i))
	path.sort(key=lambda x : x[0])
	_,ny,nx, d = path[0]
	return ny,nx,d

def s_move(y,x):
	min_d = -1
	min_dis = cal_distance(y,x, RY,RX)


	S = set()
	for i in range(1, P+1):
		S.add(santas[i])

	for i in range(0, 8,2):
		ny = y + dy[i]
		nx = x + dx[i]
		if out(ny,nx):
			continue
		if (ny,nx) in S:
			continue
		dis = cal_distance(ny,nx, RY,RX)
		if min_dis > dis:
			min_d = i
			min_dis = dis
	if min_d == -1:
		return y,x, min_d

	return y + dy[min_d], x + dx[min_d], min_d

def santa_move():
	# santa_s = set()
	# for i in range(1, P+1):
	# 	r,c = santas[i]
	# 	if out(r,c):
	# 		continue
	# 	santa_s.add((r,c))

	for i in range(1, P+1):
		r,c = santas[i]
		if out(r,c):
			continue
		if stuns[i] > turn:
			continue
		ny,nx, san_d = s_move(r,c)
		santas[i] = (ny,nx)
		if (ny,nx) == (RY,RX):
			revers_d = (san_d + 4) % 8
			bump(i,revers_d, D)

def bump(pid,d,power):
	r, c = santas[pid]
	nr = r + dy[d] * power
	nc = c + dx[d] * power
	santas[pid] = (nr, nc)
	stuns[pid] = turn + 2
	scores[pid] += power

	if out(nr,nc):
		return

	board = [[0] * (N+1) for _ in range(N+1)]
	for i in range(1, P+1):
		if i == pid:
			continue
		r,c = santas[i]
		if out(r,c):
			continue
		board[r][c] = i

	move_s = []
	q = deque()
	q.append((nr,nc))
	while q:
		r, c = q.popleft()
		if out(r,c):
			continue
		if board[r][c] > 0:
			move_s.append(board[r][c])
			q.append((r+dy[d], c+dx[d]))
	if move_s:
		for bump_pid in move_s:
			r,c = santas[bump_pid]
			nr = r +dy[d]
			nc = c + dx[d]
			santas[bump_pid] = (nr, nc)
def is_finish():
	for i in range(1, P+1):
		r,c = santas[i]
		if not out(r,c):
			return False
	return True
def plus_one():
	for i in range(1, P+1):
		r, c= santas[i]
		if not out(r,c):
			scores[i] += 1
for turn in range(1, M+1):
	sy,sx, pid = choose_santa()
	RY, RX, RD = rudolph_move(sy,sx)
	if santas[pid] == (RY, RX):
		bump(pid, RD, C)
	santa_move()
	if is_finish():
		break
	plus_one()
print(*scores[1:])