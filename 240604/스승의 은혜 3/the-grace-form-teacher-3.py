N, B= map(int, input().split())

items = []
for _ in range(N):
    a,b = map(int, input().split())
    items.append([a,b])

ans = 0
for i in range(N):
    temp = []
    items[i][0] //= 2
    for a,b in items:
        temp.append(a+b)
    temp.sort()
    total = 0

    j = 0
    while j < N:
        if total > B:
            break
        ans = max(ans, j)
        total += temp[j]
        j+=1

    if total <= B:
        ans = max(ans, j)
    
    items[i][0] *= 2
print(ans)