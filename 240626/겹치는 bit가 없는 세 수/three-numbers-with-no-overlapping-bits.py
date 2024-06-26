from itertools import combinations
N = int(input())
A = list(map(int, input().split()))

ans = 0
for combi in combinations(A, 3):
    a,b,c = combi

    if (a & b) == (a& c) == (b & c) == 0:
        ans = max(ans, a+b+c)
print(ans)