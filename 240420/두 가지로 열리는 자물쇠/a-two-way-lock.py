N = int(input())
A = list(map(int, input().split()))
B = list(map(int, input().split()))

Al = []
Bl = []
for a in A:
    temp = set()
    for i in range(-2, 3, 1):
        if a + i <= 0:
            num = N + a +i
        elif a + i > N:
            num = a + i - N
        else:
            num = a + i
        if 0 < num <= N:
            temp.add(num)
    Al.append(temp)

for b in B:
    temp = set()
    for i in range(-2, 3 ,1):
        if a + i <= 0:
            num = N + b +i
        elif a + i > N:
            num = b + i - N
        else:
            num = b + i
        if 0 < num <= N:
            temp.add(num)
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