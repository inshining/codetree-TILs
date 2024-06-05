s = input()

m = { chr(k+ ord('a')) : 0 for k in range(6)}

ans = 0
def cal():
    v = m[s[0]]

    for i in range(1, len(s), 2):
        if s[i] == '+':
            v += m[s[i+1]]
        elif s[i] == '-':
            v -= m[s[i+1]]
        elif s[i] == '*':
            v *= m[s[i+1]]
    global ans
    ans = max(ans, v)
def go(idx):
    if idx >= 6:
        cal()
        return

    for i in range(1, 5):
        m[chr(idx + ord('a'))] = i
        go(idx+1)

go(0)
print(ans)