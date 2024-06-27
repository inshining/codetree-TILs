N, M = map(int, input().split())
A = list(map(int, input().split()))
targets = [int(input()) for _ in range(M)]

def find(t):
    idx = -1
    left, right = 0, len(A) - 1
    while left <= right:
        mid = (left + right) // 2
        if A[mid] == t:
            idx = mid
            break
        if A[mid] > t:
            right = mid -1
        else:
            left = mid + 1
    return idx + 1 if idx != -1 else -1

for t in targets:
    print(find(t))