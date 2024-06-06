N = int(input())
W, B = 0, 0

for _ in range(N):
    a,b = input().split()
    a = int(a)
    if b == "L":
        W += a
        B = B - a if B > a else 0

    else: 
        B += a
        W = W - a if W > a else 0
    
print(W, B)