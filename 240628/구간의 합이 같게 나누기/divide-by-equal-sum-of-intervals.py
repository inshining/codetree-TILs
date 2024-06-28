from bisect import bisect_left
N = int(input())
A = list(map(int, input().split()))

L = [0] * (N+1)
R = [0] * (N+1)

for i in range(1, N+1):
    L[i] = L[i-1] + A[i-1]

for i in range(N-1, -1, -1):
    R[i] = R[i+1] + A[i]
target_v = L[N] // 4
if L[N] % 4 > 0:
    print(0)
else:
    ans = 0
    for i in range(1, N):
        if target_v != L[i]:
            continue
        for j in range(N-1, 0, -1):
            if target_v != R[j]:
                continue
            for k in range(i+1, N):
                if L[k] != (2 * target_v):
                    continue
                if (j - k) >= 1:
                    ans += 1
    print(ans)
    # dic = {
    #     1 : list(),
    #     2 : list(),
    #     3 : list(),
    # }
    # ans = 0
    # for i in range(1, N):
    #     if target_v and L[i] % target_v == 0:
    #         mo = L[i] // target_v 
    #         dic[mo].append(i)
    # for i in dic[1]:
    #     pos = bisect_left(dic[2], i)
    #     for j in range(pos, len(dic[2])):
    #         num3 = bisect_left(dic[3], dic[2][j])
    #         ans += len(dic[3])- num3

    # print(ans)