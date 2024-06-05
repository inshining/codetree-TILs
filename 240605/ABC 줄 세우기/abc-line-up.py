N = int(input())
alpha = list(input().split())
ans = 0
for i in range(N):
    for j in range(N-i-1):
        if alpha[j] > alpha[j+1]:
            alpha[j], alpha[j+1] = alpha[j+1], alpha[j]
            ans += 1
print(ans)