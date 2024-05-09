line = input()
arr = []
ans = 0
def cal():
    global ans
    d = {}
    for i in range(6):
        k=chr(97+i)
        d[k] = arr[i]
    
    num = 0
    for i in range(len(line)):
        s = line[i]
        if i == 0:
            num = d[s]
    
        elif not(97 <= ord(s) < 110):
            if s == '+':
                num += d[line[i+1]]
            elif s == '-':
                num -= d[line[i+1]]
            elif s == '*':
                num *= d[line[i+1]]
    ans = max(ans, num)
        

def go(idx):
    if idx >= 6:
        cal()
        return 
    for i in range(1, 5):
        arr.append(i)
        go(idx+1)
        arr.pop(-1)
go(0)
print(ans)