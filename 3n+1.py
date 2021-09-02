#Professor simple solution to 3n+1 question
k = 216091
p = (2<<k)-1
x=p
k=0
while True:
    if p%2==1:
        p=(3*p+1)//2
        k=k+1
    else:
        p=p>>1
        k=k+1
    if p<x:
        break
    print(f'Peaking {k}')
print(k)