N, B = map(int, input().split())

gifts = []
for _ in range(N):
    p,s = map(int, input().split())
    gifts.append((p,s))

ans = 0
for i in range(N):
    temp = []
    for j in range(N):
        if i == j:

            a,b = gifts[j]
            a //= 2
        else:
            a,b = gifts[j]
        
        temp.append(a+b)
    temp.sort()
    total = 0
    for k in range(N):
        total += temp[k]
        if total <= B:
            ans = max(ans, k+1)
        else:
            break
print(ans)