s = "#" + input()
p = "#" + input()

dp = [[0] * len(s) for _ in range(len(p))]

for i in range(1, len(p)):
    for j in range(1, len(s)):
        if p[i] == "." or p[i] == s[j]:
            dp[i][j] = dp[i-1][j-1] + 1
        elif p[i] == "*":
            if p[i-1] == "." or p[i-1] == s[j]:
                dp[i][j] = max(dp[i-1][j-1], dp[i][j-1]) + 1
            else:
                dp[i][j] = max(dp[i-1][j], dp[i][j-1])
        else:
            dp[i][j] = max(dp[i-1][j], dp[i][j-1])

ans = (dp[len(p)-1][len(s)-1] == len(s) - 1)
print("true" if ans else "false")