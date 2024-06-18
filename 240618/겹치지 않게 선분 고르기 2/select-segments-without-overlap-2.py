n = int(input())

l = []
for _ in range(n):
    l.append(tuple(map(int, input().split())))

l.sort(key = lambda x : (x[1], x[0]))
ans = 0
end = 0
for a, b in l:
    if end < a:
        ans += 1
        end = b
print(ans)