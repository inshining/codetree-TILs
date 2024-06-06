a, b = map(int, input().split())
N = input()

def at10(s):
    v = 0
    for x in range(len(s)):
        v *= a
        v += int(s[x])
    return v

def ten_to_b(v):
    l = []
    while v > 0:
        l.append(str(v % b))
        v = v // b 
    l = l[::-1]
    return "".join(l)

print(ten_to_b(at10(N)))