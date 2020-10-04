
list = []
while(1):
    tmp = [str(i) for i in input().split()]
    if 'end' in tmp:
        break
    else:
         tmp = [int(i) for i in tmp]
         list.append(tmp)

for i in range(len(list)):
    for j in range(len(list[i])):
        bot = i - 1
        if bot == -1:
            bot = len(list) - 1
        top = i + 1
        if top == len(list):
            top = 0
        right = j - 1
        if right == -1:
            right = len(list[i]) - 1
        left = j + 1
        if left == len(list[i]):
            left = 0
        print(list[bot][j] + list[top][j] + list[i][left] + list[i][right], end = ' ')
    print()