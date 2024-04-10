from collections import deque
N, M, K = map(int, input().split())

board = [[0] * (N+1) for _ in range(N+1)]
graph = [[0] * (N+1) for _ in range(N+1)]
dy = [0, -1, 0, 1]
dx = [-1, 0, 1, 0]

for i in range(1, N+1):
	board[i] = [0] + list(map(int, input().split()))

aircons = []
for y in range(1, N+1):
	for x in range(1, N+1):
		if board[y][x] > 1:
			aircons.append((y,x,board[y][x]-2))

up_blocks = set()
left_blocks = set()
for _ in range(M):
	y,x,s = map(int, input().split())
	if s == 0:
		up_blocks.add((y,x))
	elif s == 1:
		left_blocks.add((y,x))

def out(y,x):
	return y < 1 or N < y or x < 1 or N < x

def is_pass(d, y,x, ny,nx):
	if d == 0 and (y, x) not in left_blocks:
		return True
	if d == 1 and (y, x) not in up_blocks:
		return True
	if d == 2 and (ny, nx) not in left_blocks:
		return True
	if d == 3 and (ny,nx) not in up_blocks:
		return True

def double_path(side_d, d, y,x):
	ny = y + dy[side_d]
	nx = x + dx[side_d]
	return not out(ny, nx) and not out(ny + dy[d], nx + dx[d]) and is_pass(side_d, y, x, ny, nx) and is_pass(d, ny, nx, ny + dy[d], nx + dx[d])


def cool_wind(y,x,d):
	new_board = [[0] * (N+1) for _ in range(N+1)]
	visited =[[False] * (N+1) for _ in range(N+1)]
	q = deque()

	ny = y + dy[d]
	nx = x + dx[d]
	visited[ny][nx] = True
	new_board[ny][nx] = 5
	q.append((ny,nx))

	right_d = (d+1) % 4
	left_d = (d-1) % 4

	while q:
		y,x = q.popleft()
		if new_board[y][x] == 1:
			continue
		ny = y + dy[d]
		nx = x + dx[d]
		if not out(ny,nx) and not visited[ny][nx] and is_pass(d, y,x,ny,nx):
			visited[ny][nx] = True
			new_board[ny][nx] = new_board[y][x] -1
			q.append((ny,nx))

		if double_path(right_d, d, y, x):
			ny = y + dy[right_d] + dy[d]
			nx = x + dx[right_d] + dx[d]
			if not visited[ny][nx]:
				visited[ny][nx] = True
				new_board[ny][nx] = new_board[y][x] - 1
				q.append((ny,nx))

		if double_path(left_d, d, y, x):
			ny = y + dy[left_d] + dy[d]
			nx = x + dx[left_d] + dx[d]
			if not visited[ny][nx]:
				visited[ny][nx] = True
				new_board[ny][nx] = new_board[y][x] - 1
				q.append((ny,nx))

	for y in range(1, N+1):
		for x in range(1, N+1):
			graph[y][x] += new_board[y][x]
def spread():
	sheet = [[0] * (N+1) for _ in range(N+1)]
	for y in range(1, N+1):
		for x in range(1, N+1):
			v= graph[y][x]
			for i in range(4):
				ny = y + dy[i]
				nx = x + dx[i]
				if out(ny,nx):
					continue
				if not is_pass(i, y,x,ny,nx):
					continue
				if v > graph[ny][nx]:
					diff = (v-graph[ny][nx]) // 4
					sheet[y][x] -= diff
					sheet[ny][nx] += diff
	for y in range(1, N+1):
		for x in range(1, N+1):
			graph[y][x] += sheet[y][x]

def clean_exterial():
	for y in range(1, N+1):
		for x in range(1, N+1):
			if y == 1 or y == N or x == 1 or x == N:
				if graph[y][x]:
					graph[y][x] -= 1

def check_office():
	for y in range(1, N+1):
		for x in range(1, N+1):
			if board[y][x] == 1 and graph[y][x] < K:
				return False
	return True

turn = 1
while turn < 100:
	for airc in aircons:
		cool_wind(*airc)
	spread()
	clean_exterial()
	if check_office():
		break
	turn +=1

turn = turn if turn < 100 else -1
print(turn)
# for row in graph:
# 	print(row)