from collections import deque
N, M, C = map(int, input().split())
board = [[0] * (N+1) for _ in range(N+1)]

for i in range(1, N+1):
	board[i] = [0] + list(map(int, input().split()))


car = tuple(map(int, input().split()))
sons = [list(map(int, input().split())) for _ in range(M)]
finished = [False] * M

dy = [-1, 0, 1, 0]
dx = [0, 1, 0, -1]
def out(y,x):
	return y < 1 or N < y or x < 1 or N < x
def find_path(y,x):
	maps = [[-1] * (N+1) for _ in range(N+1)]
	maps[y][x] = 0

	q = deque()

	q.append((y,x))
	while q:
		y,x = q.popleft()
		for i in range(4):
			ny = y + dy[i]
			nx = x + dx[i]

			if out(ny,nx):
				continue
			if board[ny][nx] == 1:
				continue
			if maps[ny][nx] >= 0:
				continue
			maps[ny][nx] = maps[y][x] + 1
			q.append((ny,nx))
	return maps
for _ in range(M):
	path = find_path(*car)
	can = []
	for idx, s in enumerate(sons):
		if finished[idx]:
			continue
		sy,sx,_,_ = s
		can.append((path[sy][sx], sy,sx, idx))
	can.sort(key=lambda x : (x[0],x[1], x[2]))
	dist, ty, tx, pid = can[0]

	if dist >= C:
		C = -1
		break

	C -= dist
	path =find_path(ty,tx)
	_,_,end_y,end_x = sons[pid]
	dist = path[end_y][end_x]
	if dist > C:
		C = -1
		break
	finished[pid] =True

	C -= dist
	C += dist * 2
	car = (end_y,end_x)
print(C)