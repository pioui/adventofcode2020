
seatLayout =[list(line.strip()) for line in open("/home/piyi/Documents/adventofcode2020/input.txt", 'r')]

numberofRows = len(seatLayout)
numberofCols = len(seatLayout[0])


def vis_occupied(x, y, seats, ydir, xdir):
	x = x+xdir
	y = y+ydir
	if ((x > numberofRows-1) or (y> numberofCols-1) or( x<0) or (y <0)): 
		return 0

	while(seats[x][y] == '.'):
		x = x+xdir
		y = y+ydir
		if ((x > numberofRows-1) or (y> numberofCols-1) or( x<0) or (y <0)): 
			return 0

	if seats[x][y] == '.': return 0
	elif seats[x][y] == 'L': return 0
	elif seats[x][y] == '#': return 1

def num_of_visible(x,y, seats):

	return vis_occupied(x,y,seats, -1,0)+vis_occupied(x,y,seats,-1,-1)+vis_occupied(x,y,seats,-1,1) +vis_occupied(x,y,seats,0,-1)+vis_occupied(x,y,seats,0,1)+vis_occupied(x,y,seats,1,-1)+vis_occupied(x,y,seats,1,0)+vis_occupied(x,y,seats,1,1)


newseatLayout = seatLayout.copy()
change = True

while change is True:
	change = False
	newseatLayout = []

	for row in range(numberofRows):
		newrow = []
		for col in range(numberofCols) :
			if seatLayout[row][col] == 'L' and num_of_visible(row,col, seatLayout) == 0:
				newrow.append('#')
				change = True
			elif seatLayout[row][col] == '#' and num_of_visible(row,col, seatLayout) >=5: 
				newrow.append('L')
				change = True
			else :
				newrow.append(seatLayout[row][col])
		newseatLayout.append(newrow)

	seatLayout = newseatLayout.copy()


count = sum( [ listElem.count('#') for listElem in seatLayout])
print(count)
