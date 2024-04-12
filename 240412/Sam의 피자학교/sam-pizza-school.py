from collections import deque
N, K = map(int, input().split())
board = [[0] * N for _ in range(N)]
board[N-1] = list(map(int, input().split()))


def add_mil():
	y = N-1
	min_v = min(board[y])
	for x in range(N):
		if board[y][x] == min_v:
			board[y][x] += 1

def out(y,x):
	return y < 0 or N <= y or x < 0 or N <= x

def roll_up():
	start_x = 0
	jump = 1
	jumping_timing = 1
	height = 1
	turn = 0
	while True:
		if turn % 2:
			height += 1
		ty = N - 2
		if start_x + height >= N:
			break
		for x in range(start_x, -1,-1):
			tx = start_x + 1
			for y in range(N-1, -1, -1):
				if not board[y][x]:
					break
				if out(ty,tx):
					return False
				board[ty][tx] = board[y][x]
				board[y][x] = 0
				tx += 1
			ty -= 1
		if jumping_timing >= 2:
			jumping_timing = 0
			jump += 1
		jumping_timing += 1
		start_x += jump
		turn += 1

dy = [-1, 0, 1, 0]
dx = [0, 1, 0, -1]
def cal_mill():
	next_board = [[0] * N for _ in range(N)]
	visited = [[False] * N for _ in range(N)]
	q = deque()

	visited[N-1][N-1] = True
	q.append((N-1, N-1))

	while q:
		y,x = q.popleft()

		for i in range(4):
			ny = y + dy[i]
			nx = x + dx[i]
			if out(ny,nx):
				continue
			if board[ny][nx] == 0:
				continue

			val = abs(board[y][x] - board[ny][nx]) // 5
			if board[y][x] >= board[ny][nx]:
				next_board[y][x] -= val
			else:
				next_board[y][x] += val

			if not visited[ny][nx]:
				visited[ny][nx] = True
				q.append((ny,nx))


	q = deque()
	visited = [[False] * N for _ in range(N)]

	q.append((N-1, N-1))
	visited[N-1][N-1] = True
	while q:
		y,x = q.popleft()
		board[y][x] += next_board[y][x]
		for i in range(4):
			ny = y + dy[i]
			nx = x + dx[i]
			if out(ny,nx):
				continue
			if board[ny][nx] == 0:
				continue
			if not visited[ny][nx]:
				visited[ny][nx] = True
				q.append((ny,nx))

def flatten():

	start_x = 0
	while True:
		if board[N-1][start_x] != 0:
			break
		start_x += 1

	write_x = 0
	for x in range(start_x, N):
		for y in range(N-1, -1, -1):
			if board[y][x] == 0:
				break
			val = board[y][x]
			board[y][x] = 0
			board[N-1][write_x] = val
			write_x += 1

def fold():
	start_y = 1
	midX = N // 2 - 1
	while True:
		midY = N - start_y
		for difY in range(0, start_y):
			for difX in range(0, N-midX-1):
				board[midY-difY-1][midX+1+difX] = board[midY+difY][midX-difX]
				board[midY+difY][midX-difX] = 0
		midX += (midX +1) // 2
		start_y = start_y * 2
		if N==midX :
			break

turn = 1
while True:
	#1
	add_mil()
	#2
	roll_up()
	#3
	cal_mill()
	flatten()
	#4
	fold()
	cal_mill()
	flatten()
	if max(board[N-1]) - min(board[N-1]) <= K:
		break
	turn += 1
print(turn)