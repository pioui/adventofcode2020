navigationInstructions =[[line.strip()[0],int(line.strip()[1:])] for line in open("/home/piyi/Documents/adventofcode2020/input.txt", 'r')]

print(navigationInstructions)
# cardinalDirections = ['east' - 0, 'north' - 90, 'west' - 180, 'south' - 270]

ferry = {'east': 0, 'north':0, 'orientation': 0}


for instruction in navigationInstructions:
	action = instruction[0]
	value = instruction[1]

	if action == 'N':
		ferry['north'] = ferry['north']+value
	if action == 'S':
		ferry['north'] = ferry['north']-value
	if action == 'E':
		ferry['east'] = ferry['east']+value
	if action == 'W':
		ferry['east'] = ferry['east']-value

	if action == 'F' and ferry['orientation'] == 0:
		ferry['east'] = ferry['east']+value
	if action == 'F' and ferry['orientation'] == 180:
		ferry['east'] = ferry['east']-value
	if action == 'F' and ferry['orientation'] == 90:
		ferry['north'] = ferry['north']+value
	if action == 'F' and ferry['orientation'] == 270:
		ferry['north'] = ferry['north']-value

	if action == 'R':
		ferry['orientation'] = abs(ferry['orientation'] - value + 360) % 360
	if action == 'L':
		ferry['orientation'] = abs(ferry['orientation'] + value + 360) % 360
		
	print(instruction)
	print(ferry)
print(abs(ferry['north'])+abs(ferry['east']))