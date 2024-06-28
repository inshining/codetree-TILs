n, q = map(int, input().split())
A = list(map(int, input().split()))
A.sort()
qs = [list(map(int, input().split())) for _ in range(q)]
def bi(target):
    min_idx = n
    left, right = 0, n - 1
    while left <= right:
        mid = (left + right) // 2
        if target <= A[mid]:
            min_idx = min(min_idx, mid)
            right = mid - 1
        else:
            left = mid + 1
    return min_idx

for a, b in qs:
    start = bi(a)
    end = bi(b)
    ans= end - start
    if A[end] == b:
        ans += 1
    print(ans)