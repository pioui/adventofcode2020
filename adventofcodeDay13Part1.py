inputFile = open("input.txt", "r")
earliestTimestamp = int(inputFile.readline())

notes = inputFile.readline().split(',')
notes = list(filter(lambda a: a != 'x', notes))

earliestBusTime = float("inf")
busID = 0
for bus in notes:
	div = earliestTimestamp // int(bus)
	busTime = (div+1) * int(bus)
	if earliestBusTime > busTime:
		earliestBusTime = busTime
		busID = int(bus)


waiting = earliestBusTime - earliestTimestamp


print(waiting*busID)