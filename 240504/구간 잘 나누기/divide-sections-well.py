from itertools import combinations
N, M = map(int, input().split())
arr = list(map(int, input().split()))

blocks = [i for i in range(1, N)]

ans = int(1e9)
for com in combinations(blocks, M-1):
    start = 0
    val = 0
    for x in com:
        val = max(val, sum(arr[start: x]))
        start = x
    val = max(val, sum(arr[start:]))
    ans = min(ans, val)
print(ans)