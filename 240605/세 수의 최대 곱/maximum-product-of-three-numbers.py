N = int(input())
vs = list(map(int, input().split()))
vs.sort()

a = vs[-1] * vs[-2] * vs[-3]
b = vs[0] * vs[1] * vs[-1]
print(max(a,b))