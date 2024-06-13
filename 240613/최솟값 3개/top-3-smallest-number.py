import heapq

n = int(input())
l = list(map(int, input().split()))

    
q = []
ans = 1
for x in l:
    if len(q) < 3:
        ans *= x
        heapq.heappush(q, -x)
    else:
        if -q[0] > x:
            ans //= -heapq.heappop(q)
            ans *= x
            heapq.heappush(q, -x)

    if len(q) < 3:
        print(-1)
    else:
        print(ans)