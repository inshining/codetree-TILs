n, m = map(int, input().split())
A = set(map(int, input().split()))
B = set(map(int, input().split()))

union = set()
for x in B:
    if x in A:
        union.add(x)
ans = 0
for x in A:
    if x in union:
        continue
    ans += 1

for x in B:
    if x not in union:
        ans += 1

print(ans)