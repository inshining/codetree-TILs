N = int(input())
vs = list(map(int, input().split()))

end = 0
for i in range(N-1, 0, -1):
    if vs[i-1] > vs[i]:
        end = i
        break
print(end)