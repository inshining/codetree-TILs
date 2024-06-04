X, Y = map(int, input().split())

def pal(s):
    for i in range(len(s) // 2):
        if s[i] != s[len(s) - 1 - i]:
            return False
    return True

ans = 0
for k in range(X, Y+1):
    if pal(str(k)):
        ans += 1
print(ans)