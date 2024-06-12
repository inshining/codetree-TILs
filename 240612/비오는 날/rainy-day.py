N = int(input())

data = []
for _ in range(N):
    date, week, weather = input().split()
    a,b,c = map(int, date.split("-"))
    if weather == "Rain":
        data.append([a,b,c,date, week, weather])

data.sort(key = lambda x : (x[0], x[1], x[2]))

print(*data[0][3:])