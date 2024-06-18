n = int(input())
a = list(map(int, input().split()))

up = [1] * n
down = [1] * n

for i in range(1, n):
    for j in range(i):
        if a[i] > a[j]:
            up[i] = max(up[i], up[j] + 1)

        if a[i] < a[j]:
            down[i] = max(down[i], down[j] + 1)

ans = max(up)
ans = max(ans, max(down))

for i in range(1, n):
    ans = max(ans, max(up[:i]) + max(down[i:]) - 1)
print(ans)