from collections import deque
def shift(a,b,c): return (b,c,a)
k,n = map(int,input().split())
Q = deque([(0,1,k)])
v = {0}
while True:
    a,b,c = Q.popleft()
    if (a-b)*(b-c) != 0:
        if a not in v and b not in v and c not in v:
            print(a,b,c); n -= 1
            v.add(a); v.add(b); v.add(c)
            if n == 0: quit()
    for _ in range(3):
        temp = k*(a+b)-c
        if temp > 0: Q.append(tuple(sorted([a,b,temp])))
        a,b,c = shift(a,b,c)