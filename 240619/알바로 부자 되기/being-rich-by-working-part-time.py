n = int(input())
part_times = [list(map(int, input().split())) for _ in range(n)]

part_times.sort()
dp = [0] * n
for i in range(len(part_times)):
    dp[i] = part_times[i][2]
    for j in range(i):
        if part_times[i][0] > part_times[j][1]:
            dp[i] = max(dp[i], dp[j] + part_times[i][2])

print(max(dp))