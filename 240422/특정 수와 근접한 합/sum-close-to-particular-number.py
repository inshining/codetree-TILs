N, S = map(int, input().split())
arr = list(map(int, input().split()))

total = sum(arr)

ans = int(1e9)
for i in range(N):
    for j in range(i+1, N):
        ans = min(ans, abs(S - (total - arr[i] - arr[j])))
print(ans)