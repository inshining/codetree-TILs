N, M = map(int, input().split())

A = set(map(int, input().split()))
B= set(map(int, input().split()))

u = 0
for e in A:
    if e in B:
        u += 1

print(len(A) - u + len(B) - u)