N, M = map(int, input().split())
A = list(map(int, input().split()))
targets = [list(map(int, input().split())) for _ in range(M)]

def find(t):
    left = 0
    right = len(A) - 1
    min_idx = N

    while left <= right:
        mid = (left + right) // 2
        if A[mid] >= t:
            min_idx = min(min_idx, mid)
            right = mid -1

        else:
            left = mid + 1
    return min_idx

for a,b in targets:
    end = find(b)
    start = find(a)
    ans = end - start
    if end < N and A[end] == b:
        ans += 1
    print(ans)