N = 4
H = 16
dead = [False] * (H+1)
directions = [0] * (H+1)
board = [[0] * N for _ in range(N)]

dy = [0, -1, -1, 0, 1, 1, 1, 0, -1]
dx = [0, 0, -1, -1, -1, 0, 1, 1, 1]
for y in range(N):
	line = list(map(int, input().split()))
	for i in range(0,8,2):
		p, d = line[i], line[i+1]
		board[y][i//2] = p
		directions[p] = d

def kill(y,x):
	p = board[y][x]
	dead[p] = True
	board[y][x] = 0
	return directions[p]
def out(y,x):
	return y <0 or N <= y or x < 0 or N <= x

def other_move():
	hoses = [[-1,-1]] * (H+1)
	for y in range(N):
		for x in range(N):
			if board[y][x] > 0:
				hoses[board[y][x]] = [y,x]
	for i in range(1, H+1):
		if dead[i]:
			continue
		y,x = hoses[i]
		d = directions[i]
		for j in range(8):
			nd = (d+j) % len(dx)
			ny = y + dy[nd]
			nx = x + dx[nd]
			if out(ny,nx):
				continue
			if (ny,nx) == (Ty, Tx):
				continue

			counter = board[ny][nx]
			board[ny][nx] = i
			board[y][x] = counter
			hoses[counter] = [y,x]
			directions[i] = nd
			break

def choose_one():
	can = []
	i = 1
	while True:
		ny = Ty + dy[Td] * i
		nx = Tx + dx[Td] * i
		if out(ny,nx):
			break
		if board[ny][nx] > 0:
			can.append((board[ny][nx], ny,nx))
		i += 1
	return can

Ty, Tx = 0, 0
Td = kill(Ty, Tx)
while True:
	other_move()
	can = choose_one()
	if can:
		can.sort(key=lambda x : -x[0])
		_, y,x = can[0]
		Ty, Tx = y,x
		Td = kill(y,x)
	else:
		break
ans = 0
for i in range(1, H+1):
	if dead[i]:
		ans += i
print(ans)