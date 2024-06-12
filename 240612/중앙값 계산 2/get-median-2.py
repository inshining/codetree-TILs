n = int(input())

values = list(map(int, input().split()))
data = []
result = []
for i in range(n):
    k = values[i]
    data.append(k)
    if i % 2 == 0:
        data.sort()
        result.append(data[len(data)//2])
print(*result)