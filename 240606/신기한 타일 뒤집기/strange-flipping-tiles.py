N = int(input())
W, B = 0, 0

last = ""
for _ in range(N):
    a,b = input().split()
    a = int(a)
    if b == "L":
        
        W += a
        if last == "L":
            W -= 1
        
        B = B - a if B > a else 0
        last = "L"
    else: 
        B += a
        if last == "B":
            B -= 1
        W = W - a if W > a else 0
        
        last = "B"
print(W, B)