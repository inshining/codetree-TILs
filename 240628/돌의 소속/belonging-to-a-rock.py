N, Q = map(int, input().split())
A = [int(input()) for _ in range(N)]
group = [map(int, input().split()) for _ in range(Q)]
dp = [[0] * 3 ] * (N+1)

for i in range(1, N+1):
    v = A[i-1]
    dp[i] = dp[i-1][:]
    dp[i][v-1] += 1

for a, b in group:
    temp = [0] * 3
    for i in range(3):
        temp[i] = dp[b][i] - dp[a-1][i]
    print(*temp)