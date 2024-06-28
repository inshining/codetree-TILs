N, M = map(int, input().split())
A = list(map(int, input().split()))
B = list(map(int, input().split()))

def is_check():
    j = 0
    for i in range(M):
        while j < N and A[j] != B[i]:
            j += 1
        if j == N:
            return False
        j += 1
    return True

ans = is_check()
print("Yes" if ans else "No")