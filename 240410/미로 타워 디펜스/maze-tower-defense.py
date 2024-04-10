dy = [0, 1, 0, -1]
dx = [1, 0, -1, 0]
N, M = map(int, input().split())
board = [list(map(int, input().split())) for _ in range(N)]
def get_route(y,x):
	q = []
	dis = 1
	ny, nx = y,x
	d = 2
	q.append((ny,nx))

	while True:
		for _ in range(2):
			for _ in range(dis):
				ny = ny + dy[d]
				nx = nx + dx[d]
				q.append((ny,nx))
				if ny == 0 and nx == 0:
					return q
			d = (d-1) % 4
		dis += 1
def out(y,x):
	return y < 0 or N <= y or x < 0 or N <=x
def attack_monster(d, p):
	y, x= N//2, N//2
	score = 0
	for i in range(1, p+1):
		ny = y + dy[d] * i
		nx = x + dx[d] * i
		if out(ny,nx):
			continue
		v = board[ny][nx]
		score += v
		board[ny][nx] = 0
	return score

def rearrange():
	next_board = [[0] * N for _ in range(N)]
	idx = 1
	for i in range(1, len(path)):
		y, x= path[i]
		if board[y][x]:
			next_board[path[idx][0]][path[idx][1]] = board[y][x]
			idx += 1

	for y in range(N):
		for x in range(N):
			board[y][x] = next_board[y][x]

def get_dup(idx):
	y,x = path[idx]
	v = board[y][x]
	if v <= 0:
		return 1
	num = 1
	for i in range(idx+1, len(path)):
		ny, nx = path[i]
		if v == board[ny][nx]:
			num += 1
		else:
			break
	return num

def delete_dul():
	next_board = [[0] * N for _ in range(N)]
	write_idx = 1
	idx = 1
	score = 0
	while idx < len(path):
		y, x = path[idx]
		val = board[y][x]
		if board[y][x] == 0:
			break
		num = get_dup(idx)
		if  num >= 4:
			idx += num
			score += (num * val)
		else:
			for _ in range(num):
				wy, wx = path[write_idx]
				next_board[wy][wx] = val
				write_idx += 1
			idx += num

	for y in range(N):
		for x in range(N):
			board[y][x] = next_board[y][x]
	return score

def regenerate():
	line = []
	idx = 1
	next_board = [[0] * N for _ in range(N)]
	while idx < len(path):
		y, x = path[idx]
		val = board[y][x]
		if val == 0:
			break
		num = get_dup(idx)
		line.append(num)
		line.append(val)
		idx += num

	for i in range(len(line)):
		y,x = path[i+1]
		next_board[y][x] = line[i]
		if y == 0 and x == 0:
			break

	for y in range(N):
		for x in range(N):
			board[y][x] = next_board[y][x]

path = get_route(N//2, N//2)

ans = 0
for _ in range(M):
	d, p = map(int, input().split())
	ans += attack_monster(d, p)
	rearrange()
	while True:
		round_v = delete_dul()
		ans += round_v
		if round_v == 0:
			break
	regenerate()

print(ans)