l = list(map(int, input().split()))

total = sum(l)
ans = 1000000 * 6
for i in range(6):
    for j in range(i+1, 6):
        for k in range(6):
            for c in range(k +1, 6):
                if i ==k or i ==c or j ==k or j ==c:
                    continue
                A = l[i] + l[j]
                B = l[k] + l[c]
                C = total - A - B
                ans = min(ans, max([A, B, C]) - min([A,B,C]))
print(ans)