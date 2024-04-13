from collections import deque
L, N, Q = map(int, input().split())
board = [[0] * (L+1) for _ in range(L+1)]

for i in range(1, L+1):
	board[i] = [0] + list(map(int, input().split()))

hp = [0] * (N+1)
damage = [0] * (N+1)
knights = {}
for i in range(1, N+1):
	r,c,h,w,k = map(int, input().split())
	knights[i] = (r,c,h,w)
	hp[i] = k

dy = [-1, 0, 1, 0]
dx = [0, 1, 0, -1]
def out(y,x):
	return y < 1 or L < y or x < 1 or L < x
def make_power(pid, d):
	r,c,h,w = knights[pid]
	q = deque()
	if d == 0:
		y = r -1
		for x in range(c, c+w):
			q.append((y,x))
	elif d == 1:
		x = c + w
		for y in range(r, r+h):
			q.append((y,x))
	elif d == 2:
		y = r + h
		for x in range(c, c+w):
			q.append((y,x))
	elif d == 3:
		x = c -1
		for y in range(r, r+h):
			q.append((y,x))
	return q
def get_pid(y,x):
	for i in range(1, N+1):
		if damage[i] >= hp[i]:
			continue
		r,c,h,w = knights[i]
		if r <= y < r +h and c <= x < c+w:
			return i
	return 0

def is_pushed(pid, d):
	if damage[pid] >= hp[pid]:
		return False
	q = make_power(pid, d)
	while q:
		y,x = q.popleft()
		if out(y,x):
			return False
		if board[y][x] == 2:
			return False
		other = get_pid(y,x)
		if other > 0:
			other_q = make_power(other, d)
			q.extend(other_q)
	return True

def push_knight(pid, d):
	move_l = set()
	q = make_power(pid,d)
	while q:
		y,x = q.popleft()
		if not out(y,x):
			other = get_pid(y,x)
			if other > 0:
				move_l.add(other)
				other_q = make_power(other, d)
				q.extend(other_q)
	return move_l
def move_it(pid, d):
	r,c,h,w = knights[pid]
	nr = r + dy[d]
	nc = c + dx[d]
	knights[pid] = (nr,nc, h,w)

def damage_all(l):
	for i in l:
		r,c,h,w = knights[i]

		trap = 0
		for y in range(r, r+h):
			for x in range(c, c+w):
				if board[y][x] == 1:
					trap += 1
		damage[i] += trap

def move_all(pid, d, l):
	move_it(pid, d)
	for i in l:
		move_it(i, d)

for _ in range(Q):
	pid, d = map(int, input().split())
	if is_pushed(pid, d):
		move_l = push_knight(pid, d)
		move_all(pid, d, move_l)
		damage_all(move_l)

ans = 0
for i in range(1, N+1):
	if damage[i] < hp[i]:
		ans += damage[i]
print(ans)