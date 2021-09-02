startnum=0
index = 0
global greatestpeak
greatestpeak = 0
while True:
    index = startnum
    print(f'Indexing for {index}')
    steps = 0
    highestnum = 0
    while True:
        if index%2 == 0 and index != 0:
            index = index // 2
            # print(index)
        else:
            index = (3*index)+1
            # print(index)
        steps += 1 
        if index > highestnum:
            highestnum = index
        if index > greatestpeak:
            greatestpeak = index
        if index == 1:
            break

    startnum += 1
    print(f'Total number of steps: {steps}')
    print(f'Highest peak this cycle: {highestnum}')
    print(f'Greatest peak so far: {greatestpeak}')
