n, m = map(int, input().split())
A = [-1] + list(map(int, input().split()))
B = [0] + list(map(int, input().split()))

dp = [[list() for _ in range(len(B))] for _ in range(len(A))]

for i in range(1, len(A)):
    for j in range(1, len(B)):
        if A[i] == B[j]:
            dp[i][j] = dp[i-1][j-1][:]
            dp[i][j].append(A[i])
        else:
            
            if len(dp[i-1][j]) > len(dp[i][j-1]):
                dp[i][j] = dp[i-1][j][:]
            elif len(dp[i-1][j]) < len(dp[i][j-1]):
                dp[i][j] = dp[i][j-1][:]
            else:
                who_win = True
                for k in range(len(dp[i-1][j])):
                    if dp[i-1][j][k] < dp[i][j-1][k]:
                        break
                    elif dp[i-1][j][k] > dp[i][j-1][k]:
                        who_win = False
                        break
                if who_win:
                    dp[i][j] = dp[i-1][j][:]
                else:
                    dp[i][j] = dp[i][j-1][:]
print(*dp[n][m])