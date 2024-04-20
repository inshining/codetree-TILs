N = int(input())
a1, a2, a3 = tuple(map(int, input().split()))
b1, b2, b3 = tuple(map(int, input().split()))

ans = 0
for i in range(1, N+1):
    for j in range(1, N+1):
        for k in range(1, N+1):
            if (abs(a1 - i) <=2 or abs(a1-i) >= N-2) and (abs(a2 - j) <= 2 or abs(a2-j) >= N-2) and (abs(a3-k) <= 2 or abs(a3-k) >= N-2):
                ans += 1
            elif (abs(b1 - i) <=2 or abs(b1-i) >= N-2) and (abs(b2 - j) <= 2 or abs(b2-j) >= N-2) and (abs(b3-k) <= 2 or abs(b3-k) >= N-2):
                ans += 1
print(ans)