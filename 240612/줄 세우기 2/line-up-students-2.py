N = int(input())

students = []
for k in range(N):
    h,w =map(int, input().split())
    students.append((h,w,k+1))

students.sort(key = lambda x : (x[0], -x[1]))
for row in students:
    print(*row)