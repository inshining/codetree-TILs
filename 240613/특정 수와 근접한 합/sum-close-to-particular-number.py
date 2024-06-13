N, S = map(int, input().split())
values = list(map(int, input().split()))

total = sum(values)

ans = int(1e9)
for i in range(N):
    for j in range(i+1, N):
        ans = min(ans,abs(S - (total - values[i] - values[j])))
print(ans)