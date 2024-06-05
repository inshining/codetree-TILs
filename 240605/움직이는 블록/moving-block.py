N = int(input())
vs = [int(input()) for _ in range(N)]
avg = sum(vs) // len(vs)
# print(avg)
ans = 0
for v in vs:
    if v > avg:
        ans += v - avg
print(ans)