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
    return min_idx + 1 if A[min_idx] == t else -1

for t in targets:
    print(find(t))