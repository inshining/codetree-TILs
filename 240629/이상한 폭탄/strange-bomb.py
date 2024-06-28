N, K = map(int, input().split())
nums = [int(input()) for _ in range(N)]
dic = {}
R = [0] * N 

for i in range(N-1, -1, -1):
    if nums[i] not in dic:
        R[i] = -1
    else:
        R[i] = dic[nums[i]]
    dic[nums[i]] = i

ans = -1
for i in range(N):
    if R[i] != -1:
        ans = max(ans, nums[i])
print(ans)