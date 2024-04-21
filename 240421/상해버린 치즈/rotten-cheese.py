N, M, D, S = map(int, input().split())
records = [dict() for _ in range(M+1)]
sicks = dict()
for i in range(D):
    p,m,t = map(int, input().split())
    records[m][p] = t

for i in range(S):
    p, t = map(int, input().split())
    sicks[p] = t

ans = 0
for i in range(1, M+1):
    persons = records[i]
    isEat = True
    for sick_person in sicks.keys():
        if sick_person not in persons:
            isEat = False
    if not isEat:
        continue

    isCan = True
    for k in persons.keys():
        if k in sicks and sicks[k] <= persons[k]:
            isCan = False
            break
    if isCan:
        ans = max(ans, len(persons))
print(ans)