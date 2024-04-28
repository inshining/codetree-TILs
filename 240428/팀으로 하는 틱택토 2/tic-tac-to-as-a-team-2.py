board = [list(map(int, list(input()))) for _ in range(3)]

s = set()

for i in range(3):
    temp = set(board[i])
    if len(temp) != 2:
        continue
    
    t = []
    for ss in temp:
        t.append(ss)
    
    t.sort()
    s.add(tuple(t))

for i in range(3):
    temp = set([board[j][i] for j in range(3)])
    if len(temp) != 2:
        continue
    
    t = []
    for ss in temp:
        t.append(ss)
    
    t.sort()
    s.add(tuple(t))


temp = set([board[j][j] for j in range(3)])
if len(temp) == 2:   
    t = []
    for ss in temp:
        t.append(ss)

    t.sort()
    s.add(tuple(t))

temp = set([board[2-j][j] for j in range(3)])
if len(temp) == 2:
    t = []
    for ss in temp:
        t.append(ss)

    t.sort()
    s.add(tuple(t))

print(len(s))