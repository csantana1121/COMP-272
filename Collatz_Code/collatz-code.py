k=216091
p=(2<<k)-1
x=p
steps=0
while True:
        if p&1==1:
                p=((p<<1)+p+1)>>1
                steps=steps+1
        else:
                p=p>>1
                steps=steps+1
        if p<x:
                break
print(steps)