N = int(input())

y = 0
for _ in range(N):
    
    command, *v = input().split()
    x =0
    if len(v):

        x = int(v[0])
    if command == "add":
        y = y + (1 << x)
    elif command == "delete":
        y = y - (1 << x)
    elif command == "print":
        print(y >> x & 1)
    elif command == "toggle":
        y = y ^ (1 << x)
    elif command == "clear":
        y = 0