A = input()
cnt = 0
dp = [0] * len(A)
for i in range(len(A)-1):
    if A[i] == A[i+1] == "(":
        cnt += 1
    elif A[i] == A[i+1] == ")":
        dp[i] = cnt
print(sum(dp))