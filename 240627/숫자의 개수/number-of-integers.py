N, M = map(int, input().split())
A = list(map(int, input().split()))
targets = [int(input()) for _ in range(M)]

def lowerBound(t):
    min_idx = N
    left = 0
    right = len(A) - 1
    while left <= right:
        mid = (left + right) // 2

        if A[mid] >= t:
            min_idx = min(min_idx, mid)
            right = mid - 1
        else:
            left = mid + 1
    return min_idx

def uppderBound(t):
    min_idx = N
    left = 0
    right = len(A) - 1
    while left <= right:
        mid = (left + right) // 2

        if A[mid] > t:
            min_idx = min(min_idx, mid)
            right = mid - 1
        else:
            left = mid + 1

    return min_idx

for t in targets:
    a = lowerBound(t)
    b = uppderBound(t)
    print(b- a)