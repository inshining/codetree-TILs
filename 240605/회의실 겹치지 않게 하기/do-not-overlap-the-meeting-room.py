N = int(input())
meetings = [tuple(map(int, input().split())) for _ in range(N)]
meetings.sort(key = lambda x : (x[1], x[0]))
end = 0
ans =0 
for s, e in meetings:
    if end <= s:
        # ans += 1
        end = e
    else:
        ans += 1
print(ans)