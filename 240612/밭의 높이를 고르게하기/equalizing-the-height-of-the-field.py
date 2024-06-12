N, H, T = map(int, input().split())
arr = list(map(int, input().split()))

board = [0] * N
for i in range(N):
    board[i] = abs(H- arr[i])

ans = int(1e9)
for i in range(0,N- T +1):
    ans = min(ans, sum(board[i: i+T]))
print(ans)