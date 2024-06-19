n = int(input())
l = list(map(int, input().split()))
dp = [-1] * (sum(l) + 1)
dp[0] = 0

for i in l:
    for j in range(1, sum(l) + 1):
        if j >= i:
            if dp[j-i] == -1:
                continue

            dp[j] = max(dp[j], dp[j-i] + i)

total = sum(l)

ans = total
for i in range(1, total):
    if dp[i] > 0:
        ans = min(ans, total - dp[i])
print(ans)