N, K = map(int, input().split())
A = list(map(int, input().split()))

sums = [0] * (N+1)

for i in range(1, N+1):
    sums[i] = sums[i-1] + A[i-1]

ans = 0
for i in range(K, N+1):
    ans = max(ans, sums[i] - sums[i-K])
print(ans)