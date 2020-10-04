n = int(input())
horisontal = n
vertical = n
number = 1
list = [[int(i) for i in range(n)] for j in range(n)]
while horisontal != 0 and vertical != 0:
    for i in range(len(list)):
        for j in range(len(list[i])):
            list[i][j] =