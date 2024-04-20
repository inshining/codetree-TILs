N = int(input())
A = list(map(int, input().split()))
B = list(map(int, input().split()))

Al = []
Bl = []
for a in A:
    temp = set()
    for i in range(-2, 3, 1):
        if a + i <= 0:
            temp.add(N + a +i)
        elif a + i > N:
            temp.add(a + i - N)
        else:
            temp.add(a + i)
    Al.append(temp)

for b in B:
    temp = set()
    for i in range(-2, 3 ,1):
        if a + i <= 0:
            temp.add(N + b +i)
        elif a + i > N:
            temp.add(b + i - N)
        else:
            temp.add(b + i)
    Bl.append(temp) 

ans = set()
for i in Al[0]:
    for j in Al[1]:
        for k in Al[2]:
            ans.add(i * 100 + j * 10 + k)
for i in Bl[0]:
    for j in Bl[1]:
        for k in Bl[2]:
            ans.add(i * 100 + j * 10 + k)
print(len(ans))