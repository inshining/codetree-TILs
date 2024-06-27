N, M = map(int, input().split())
A = list(map(int, input().split()))
targets = list(map(int, input().split()))
ans = []

def find(t):
    left = 0
    right = len(A) - 1
    min_idx = N

    while left <= right:
        mid = (left + right) // 2
        if A[mid] >= t:
            min_idx = min(min_idx, mid)
            right = mid - 1
        else:
            left = mid + 1
    ans = -1
    if min_idx < N and A[min_idx] == t:
        ans = min_idx + 1
    return ans

for t in targets:
    print(find(t))