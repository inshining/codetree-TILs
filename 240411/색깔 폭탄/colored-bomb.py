from collections import deque
N, M = map(int, input().split())
board = [list(map(int, input().split())) for _ in range(N)]
NO_BOMB = -100
dy = [-1, 0, 1, 0]
dx = [0, 1, 0, -1]

def out(y,x):
	return y < 0 or N <= y or x < 0 or N <= x

def bfs(y,x):
	red = set()
	pos = [(y, x)]
	val = board[y][x]
	q = deque()

	visited[y][x] = True
	q.append((y, x))
	while q:
		y, x = q.popleft()
		for i in range(4):
			ny = y + dy[i]
			nx = x + dx[i]
			if out(ny, nx):
				continue
			if visited[ny][nx]:
				continue
			if board[ny][nx] == -1:
				continue
			if board[ny][nx] == val:
				visited[ny][nx] = True
				q.append((ny, nx))
				pos.append((ny, nx))
			elif board[ny][nx] == 0 and (ny, nx) not in red:
				red.add((ny, nx))
				q.append((ny, nx))
	num = len(pos) + len(red)
	if num >= 2:
		pos.sort(key=lambda x: (-x[0], x[1]))
		return pos, red
	return -1

def delete_bomb(path, red):
	for y,x in path:
		board[y][x] = NO_BOMB
	for y,x in red:
		board[y][x] = NO_BOMB
def find_bomb():
	can = []
	for y in range(N):
		for x in range(N):
			if board[y][x] > 0 and not visited[y][x]:
				one = bfs(y,x)
				if one != -1:
					pos, red = one
					can.append((pos, red))
	sorting = []
	for i in range(len(can)):
		pos, red = can[i]
		num = len(pos) + len(red)
		sorting.append((num, len(red), pos[0][0], pos[0][1], i))
	sorting.sort(key=lambda x : (-x[0], x[1], -x[2], x[3]))
	if len(sorting):
		pid = sorting[0][4]
		return can[pid]
	return -1
def gravity():
	next_board = [[-100] * N for _ in range(N)]
	for x in range(N):
		idx = N-1
		for y in range(N-1, -1, -1):
			if board[y][x] == -1:
				next_board[y][x] = board[y][x]
				idx = y - 1
				continue
			if board[y][x] != NO_BOMB:
				next_board[idx][x] = board[y][x]
				idx -= 1
	for y in range(N):
		for x in range(N):
			board[y][x] = next_board[y][x]
def rotate():
	next_board = [[-100] * N for _ in range(N)]
	for y in range(N):
		for x in range(N):
			next_board[y][x] = board[x][N-1-y]
	for y in range(N):
		for x in range(N):
			board[y][x] = next_board[y][x]

score = 0
while True:
	visited = [[False] * N for _ in range(N)]
	bomb = find_bomb()
	if bomb == -1:
		break
	pos, red = bomb
	num = len(pos) + len(red)
	score += num ** 2
	delete_bomb(pos, red)
	gravity()
	rotate()
	gravity()

print(score)