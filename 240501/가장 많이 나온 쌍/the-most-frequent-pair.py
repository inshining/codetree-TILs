from collections import Counter

N, M = map(int, input().split())
arr = []
for _ in range(M):
    a, b = tuple(map(int, input().split()))
    if a > b:
        a ,b = b, a
    
    arr.append((a,b))

c = Counter(arr)
print(c.most_common(1)[0][1])