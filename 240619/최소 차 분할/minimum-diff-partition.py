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

vs = [0]
ans = total
for i in l:
    temp = []
    for v in vs:
        temp.append(v + i)
    vs.extend(temp)

ans = int(1e9)
for i in range(1, len(vs) - 1):
    ans = min(ans, abs(total - (vs[i] * 2)))
# for i in range(1, total):
    # if dp[i] > 0:
    #     ans = min(ans, abs(total - (dp[i] * 2)))
print(ans)