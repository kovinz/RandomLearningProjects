class Acc:
    def __init__(self):
        self.listing = dict()

    def add(self, name_vstr, hour_1, minute_1, hour_2, minute_2, *people):
        self.listing[name_vstr] = [(int(hour_1), int(minute_1)), (int(hour_2), int(minute_2)), *people]

    def get(self):
        for name_vstr in self.listing:
            print(name_vstr.upper(), 'begins at', str(self.listing[name_vstr][0][0]) + ':'
                  + str(self.listing[name_vstr][0][1]), 'ends in', str(self.listing[name_vstr][1][0])
                  + ':' + str(self.listing[name_vstr][1][1]), '\nAttenders:', end='')
            for name in self.listing[name_vstr][2:]:
                print(name, end=' ')
            print()


class Person:
    def __init__(self):
        self.listing_of_people = dict()

    def add(self, hour_1, minute_1, hour_2, minute_2, *trying_to_go):
        can_go = []
        checker = True
        counter = 0
        before = False
        for name in trying_to_go:
            if name not in self.listing_of_people:
                can_go.append(name)
                self.listing_of_people[name] = [(int(hour_1), int(minute_1)), (int(hour_2), int(minute_2))]
            else:
                first_time = int(hour_1) * 60 + int(minute_1)
                second_time = int(hour_2) * 60 + int(minute_2)
                for time in self.listing_of_people[name]:
                    counter += 1
                    timing = (time[0] * 60 + time[1])
                    if counter % 2 == 1:
                        if timing < first_time:
                            before = True
                            continue
                        elif timing > second_time:
                            continue
                        else:
                            checker = False
                    else:
                        if timing < first_time:
                            before = False
                            continue
                        elif timing > second_time and before is False:
                            continue
                        else:
                            before = False
                            checker = False
                if checker:
                    can_go.append(name)
                    self.listing_of_people[name].append((int(hour_1), int(minute_1)))
                    self.listing_of_people[name].append((int(hour_2), int(minute_2)))
                checker = True
                counter = 0

        return can_go

    def get(self, name):
        counter = 0
        print(name.upper(), 'has accs which')
        for time in self.listing_of_people[name]:
            counter += 1
            if counter % 2 == 1:
                print('begins at:', str(time[0]) + ':' + str(time[1]), end=' ')
            else:
                print('ends at:', str(time[0]) + ':' + str(time[1]))


people = Person()
vstrechi = Acc()
who_can = dict()
while True:
    cmd = input().split()
    if cmd[0] == 'add':
        hour_1, minute_1 = cmd[2].split(':')
        hour_2, minute_2 = cmd[3].split(':')
        if not (0 <= int(hour_1) < 24 or 0 <= int(hour_2) < 24 or 0 <= int(minute_1) < 60 or 0 <= int(minute_2) < 60):
            continue
        who_can = people.add(hour_1, minute_1, hour_2, minute_2, *cmd[4:])
        vstrechi.add(cmd[1], hour_1, minute_1, hour_2, minute_2, who_can)
    elif cmd[0] == 'get':
        vstrechi.get()
    elif cmd[0] == 'get_person':
        people.get(cmd[1])
