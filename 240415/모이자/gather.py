N = int(input())
l = list(map(int, input().split()))

vals = []
for i in range(len(l)):
    mid = i
    num =0
    for j in range(len(l)):
        dist = abs(j - i)
        num += dist * l[j]
    
    vals.append(num)

print(min(vals))