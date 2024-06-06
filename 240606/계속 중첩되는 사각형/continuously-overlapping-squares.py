N = int(input())

board = [[0] * 201 for _ in range(201)]

red = True
for _ in range(N):
    x1, y1, x2, y2 = map(int, input().split())
    x1 += 100
    y1 += 100
    x2 += 100
    y2 += 100
    v = "R"
    if not red:
        v = "B"

    for y in range(y1, y2):
        for x in range(x1, x2):
            board[y][x] = v
    red = not red

ans = 0
for y in range(201):
    for x in range(201):
        if board[y][x] == 'B':
            ans += 1
print(ans)
# for y in range(201):
#     for x in range(201):
#         if board[y][x] == 'B'