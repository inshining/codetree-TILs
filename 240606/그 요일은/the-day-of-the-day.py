m1,d1,m2,d2 = map(int, input().split())
A = input()

months = {
    1 : 31,
    2 : 29,
    3 : 31,
    4 : 30,
    5 : 31, 
    6 : 30,
    7 : 31, 
    8 : 31,
    9 : 30,
    10 : 31,
    11 : 30,
    12 : 31
}

def add_day(m, d, num):
    days = d + num
    if months[m] < days:
        days -= months[m]
        m += 1
    return m, days 


days = ["Mon", "Tue", 'Wed', 'Thu', 'Fri', 'Sat', "Sun"]

mon, day = add_day(m1,d1, days.index(A))
ans= 0
if mon > m2 or (mon == m2 and day > d2):
    ans = 0
elif mon == m2 and day == d2:
    ans = 1
else:
    pre_m = mon
    pre_d = day 
    while (pre_m < m2) or ( pre_m == m2 and pre_d <= d2):
        ans += 1
        pre_m, pre_d = add_day(pre_m, pre_d, 7)

print(ans)