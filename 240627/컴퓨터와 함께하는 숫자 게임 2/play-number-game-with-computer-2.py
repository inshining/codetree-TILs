M = int(input())
A, B = map(int, input().split())
def find(left, right, t):
    cnt = 1
    while left <= right:
        mid = (left + right) // 2
        if mid == t:
            break
        elif mid < t:
            left = mid + 1
        else:
            right = mid - 1
        cnt += 1
    return cnt

minv, maxv = int(1e9), -1
for t in range(A, B+1):
    k = find(1, M, t)
    minv = min(minv, k)
    maxv = max(maxv, k)
print(minv, maxv)