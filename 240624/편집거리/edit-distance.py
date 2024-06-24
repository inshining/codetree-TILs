A = "#" + input()
B = "#" + input()
dp = [[0] * (len(B)) for _ in range(len(A))]

dp[0][0] = 0
for i in range(1, len(A)):
    dp[i][0] = i

for j in range(1, len(B)):
    dp[0][j] = j

for i in range(1, len(A)):
    for j in range(1, len(B)):
        if A[i] == B[j]:
            dp[i][j] = dp[i-1][j-1]
        else:
            dp[i][j] = min(dp[i-1][j-1], dp[i-1][j], dp[i][j-1]) + 1

print(dp[len(A)-1][len(B)-1])