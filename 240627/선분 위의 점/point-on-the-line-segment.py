N, M = map(int, input().split())
A = list(map(int, input().split()))
targets = [list(map(int, input().split())) for _ in range(M)]
A.sort()

def find(t):
    left = 0
    right = len(A) - 1
    max_idx = -1

    while left <= right:
        mid = (left + right) // 2
        if A[mid] <= t:
            max_idx = max(max_idx, mid)
            left = mid +1

        else:
            right = mid - 1
    return max_idx

for a,b in targets:
    end = find(b)
    start = find(a)
    print(end, start)
    # ans = end - start
    # if end < N and A[end] == b:
    #     ans += 1
    # print(ans)