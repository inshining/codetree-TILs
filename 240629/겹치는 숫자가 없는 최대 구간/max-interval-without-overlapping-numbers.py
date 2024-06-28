N = int(input())
A = [0] + list(map(int, input().split()))

count = [0] * (100001)

j = 0
ans = 0
for i in range(N):
    while j + 1 <= N and count[A[j+1]] < 1:
        count[A[j+1]] += 1
        j += 1
    ans = max(ans, j-i + 1)
    count[A[i]] -= 1
print(ans)