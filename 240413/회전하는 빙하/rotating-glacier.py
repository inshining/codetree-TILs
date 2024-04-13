from collections import deque
N, Q = map(int,input().split())
board = [list(map(int,input().split())) for _ in range(2 ** N)]
levels = list(map(int,input().split()))

dy = [-1, 0, 1, 0]
dx = [0, 1, 0, -1]
def out(y,x):
	size = 2 ** N
	return y < 0 or size <= y or x < 0 or size <= x
def inner_rotate(r,c,m):
	next_board = [[0] * m for _ in range(m)]

	copy_board  = [[0] * m for _ in range(m)]

	for y in range(m):
		for x in range(m):
			copy_board[y][x] = board[y+r][x+c]

	mid = m //2

	for y in range(m):
		for x in range(m):
			if 0 <= y < mid and 0 <= x < mid:
				next_board[y][x+mid] = copy_board[y][x]
			elif 0 <= y < mid and mid <= x < m:
				next_board[y+mid][x] = copy_board[y][x]
			elif mid <= y < m and mid <= x < m:
				next_board[y][x-mid] = copy_board[y][x]
			else:
				next_board[y - mid][x ] = copy_board[y][x]
	for y in range(m):
		for x in range(m):
			board[y+r][x+c]  = next_board[y][x]

def rotate(n):
	if n == 1:
		return
	for r in range(0, len(board), n):
		for c in range(0, len(board), n):
			inner_rotate(r,c,n)
def melting():
	size = 2 ** N
	next_board = [[0] * size for _ in range(size)]
	for y in range(size):
		for x in range(size):
			if board[y][x] == 0:
				continue
			num = 4
			for i in range(4):
				ny = y + dy[i]
				nx = x + dx[i]
				if out(ny,nx):
					num -= 1
				elif board[ny][nx] == 0:
					num -= 1

			if num < 3:
				next_board[y][x] -= 1

	for y in range(size):
		for x in range(size):
			board[y][x] += next_board[y][x]

def cal_group():
	size = 2 ** N
	visited = [[False] * size for _ in range(size)]
	max_v = 0
	for y in range(size):
		for x in range(size):
			if board[y][x] ==0:
				continue
			if visited[y][x]:
				continue
			visited[y][x] = True
			q = deque()
			q.append((y,x))
			num = 1
			while q:
				r,c = q.popleft()

				for i in range(4):
					nr = r + dy[i]
					nc = c + dx[i]
					if out(nr, nc):
						continue
					if visited[nr][nc]:
						continue
					if board[nr][nc] == 0:
						continue
					visited[nr][nc] = True
					q.append((nr,nc))
					num += 1
			max_v = max(max_v, num)
	return max_v

for l in levels:
	rotate(2 ** l)
	melting()

ans = 0
for i in range(2**N):
	ans += sum(board[i])
print(ans)
print(cal_group())