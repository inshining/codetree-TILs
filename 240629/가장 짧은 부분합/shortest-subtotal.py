N, S = map(int, input().split())
A = list(map(int, input().split()))

sums = [0] * (N+1)
for i in range(1, N+1):
    sums[i] = sums[i-1] + A[i-1]

start = end = 0

ans = int(1e9)
while start <= end and end <= N:
    if sums[end] - sums[start] < S:
        end += 1
    else:
        ans = min(ans, end - start)
        start += 1
print(ans if ans != int(1e9) else -1)