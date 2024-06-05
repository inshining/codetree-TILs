N = int(input())
vs = list(map(int, input().split()))

def is_sort():
    for i in range(N-1):
        if vs[i] > vs[i+1]:
            return False
    return True

ans = 0
while not is_sort():
    v = vs.pop(0)
    
    e = 0
    for i in range(N-2, 0, -1):
        if vs[i-1] > vs[i]:
            e = i
    
    ins = e
    while ins < N-1:
        if v < vs[ins]:
            break
        ins += 1
    vs.insert(ins, v)
    ans += 1
print(ans)