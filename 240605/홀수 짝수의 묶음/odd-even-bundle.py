N = int(input())
vs = list(map(int, input().split()))

ans = 0
def go(s, turn):
    # print(s)
    if s >= N:
        global ans
        ans = max(ans, turn)
        return
    
    num = 0
    for i in range(s, N):
        num += vs[i]
        if turn % 2 == 0 and num % 2 == 0:
            go(i+1, turn + 1)
        if turn % 2 == 1 and num % 2 == 1:
            go(i+1, turn + 1)
go(0, 0)
print(ans)