from collections import defaultdict

d = defaultdict(int)

n = int(input())
for _ in range(n):
    x,y = map(int, input().split())
    if x in d.keys():
        d[x] = min(d[x], y)
    
    else:
        d[x] = y

ans = sum(d.values())
print(ans)