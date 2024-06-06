N = int(input())
W, B = 0, 0

last = ""
for _ in range(N):
    a,b = input().split()
    a = int(a)
    if b == "L":
        v = a
        if last == "L":
            v -= 1
        W += v
        B = B - v if B > v else 0
        last = "L"
    else: 
        v = a
        if last == "B":
            v -= 1
        B += v
        W = W - v if W > v else 0
        
        last = "B"
print(W, B)