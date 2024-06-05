# from collections import defaultdict
N = int(input())

h = dict()

for _ in range(N):
    x, y = map(int, input().split())
    if x in h.keys():
        if h[x] > y:
            h[x] = y
    else:
        h[x] = y

print(sum(h.values()))
# print(h)