N = int(input())
energy = list(map(int, input().split()))
costs = list(map(int, input().split()))

R = [0] * N

R[0] = costs[0]
for i in range(1, N):
    R[i] = min(R[i-1], costs[i])

ans = 0
for i in range(N-1):
    ans += energy[i] * R[i]
print(ans)