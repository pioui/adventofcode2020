navigationInstructions =[[line.strip()[0],int(line.strip()[1:])] for line in open("/home/piyi/Documents/adventofcode2020/input.txt", 'r')]

print(navigationInstructions)
# cardinalDirections = ['east' - 0, 'north' - 90, 'west' - 180, 'south' - 270]

ferry = {'east': 0, 'north':0}
waypoint = {'east': 10, 'north':1 }

for instruction in navigationInstructions:
	action = instruction[0]
	value = instruction[1]

	if action == 'N':
		waypoint['north'] = waypoint['north']+value
	if action == 'S':
		waypoint['north'] = waypoint['north']-value
	if action == 'E':
		waypoint['east'] = waypoint['east']+value
	if action == 'W':
		waypoint['east'] = waypoint['east']-value

	if action == 'F' :
		ferry['east'] = ferry['east']+value*waypoint['east']
		ferry['north'] = ferry['north']+value*waypoint['north']

	if action == 'R':
		if value == 90 : 
			e = waypoint['east']
			waypoint['east'] = waypoint['north']
			waypoint['north'] = -e
		if value == 180 : 
			waypoint['north'] = -waypoint['north']
			waypoint['east'] = -waypoint['east']
		if value == 270:
			e = waypoint['east']
			waypoint['east'] = -waypoint['north']
			waypoint['north'] = e

	if action == 'L':
		if value == 270 : 
			e = waypoint['east']
			waypoint['east'] = waypoint['north']
			waypoint['north'] = -e
		if value == 180 : 
			waypoint['north'] = -waypoint['north']
			waypoint['east'] = -waypoint['east']
		if value == 90:
			e = waypoint['east']
			waypoint['east'] = -waypoint['north']
			waypoint['north'] = e


		
	print(instruction)
	print(ferry)
	print(waypoint)


print(abs(ferry['north'])+abs(ferry['east']))