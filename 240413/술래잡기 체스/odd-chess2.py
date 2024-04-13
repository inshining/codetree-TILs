N = 4
H = 16
TAGGER = (-2, -2)
BLANK = (-1,-1)
dead = [False] * (H+1)
hs = [(0,0,0)] + [0] * (H)
board = [[0] * N for _ in range(N)]

dy = [0, -1, -1, 0, 1, 1, 1, 0, -1]
dx = [0, 0, -1, -1, -1, 0, 1, 1, 1]
for y in range(N):
	line = list(map(int, input().split()))
	for i in range(0,8,2):
		p, d = line[i], line[i+1]
		x=i // 2
		board[y][x] = (p,d)

def out(y,x):
	return y <0 or N <= y or x < 0 or N <= x

def move(idx):
	for y in range(N):
		for x in range(N):
			pn, pd = board[y][x]
			if pn == idx:
				for j in range(8):
					nd = (pd + j) % len(dx)
					if nd == 0:
						nd = 1
					ny = y + dy[nd]
					nx = x + dx[nd]
					if out(ny, nx):
						continue
					if board[ny][nx] == TAGGER:
						continue

					board[y][x] = (pn, nd)
					board[y][x], board[ny][nx] = board[ny][nx], board[y][x]
					return


def move_all():
	for i in range(1, H+1):
		move(i)

def choose_one(ty,tx, td, hs,dead):
	board = [[0] * N for _ in range(N)]
	for i in range(1, H+1):
		if i in dead:
			continue
		r,c,_ = hs[i]
		board[r][c] = i

	can = []
	i = 1
	while True:
		ny = ty + dy[td] * i
		nx = tx + dx[td] * i
		if out(ny,nx):
			break
		if board[ny][nx] > 0:
			can.append((ny,nx))
		i += 1
	return can

def is_tagger_going(y,x):
	return not out(y, x) and board[y][x] != BLANK


def done(y,x,d):
	for i in range(1, N+1):
		ny,nx = y + dy[d] * i, x + dx[d] * i
		if is_tagger_going(ny,nx):
			return False
	return True
def go(y,x,d, score):
	global ans
	if done(y,x,d):
		ans = max(ans, score)
		return
	for dist in range(1, N+1):
		ny, nx = y + dy[d] * dist, x + dx[d] * dist
		if not is_tagger_going(ny,nx):
			continue

		temp = [
			[board[i][j] for j in range(N)]
			for i in range(N)
		]

		extra_score, next_dir = board[ny][nx]
		board[ny][nx], board[y][x] = TAGGER, BLANK

		move_all()

		go(ny,nx, next_dir, score+extra_score)

		for i in range(N):
			for j in range(N):
				board[i][j] = temp[i][j]

ans = -1
score, td = board[0][0]
board[0][0] = TAGGER
move_all()

go(0,0,td,score)
print(ans)