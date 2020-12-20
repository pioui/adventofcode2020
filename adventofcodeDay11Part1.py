



seatLayout =[list(line.strip()) for line in open("/home/piyi/Documents/adventofcode2020/input.txt", 'r')]
print(seatLayout)

numberofRows = len(seatLayout)
numberofCols = len(seatLayout[0])


def occupied(x, y, seats):
	if ((x > numberofRows-1) or (y> numberofCols-1) or( x<0) or (y <0)): 
		return 0
	elif seats[x][y] == '.': return 0
	elif seats[x][y] == 'L': return 0
	elif seats[x][y] == '#': return 1

def num_of_adj_occupied(x,y, seats):
	return occupied(x-1,y,seats)+occupied(x-1,y-1,seats)+occupied(x-1,y+1,seats) +occupied(x,y-1,seats)+occupied(x,y+1,seats)+occupied(x+1,y-1,seats)+occupied(x+1,y,seats)+occupied(x+1,y+1,seats)

print(numberofCols)
print(numberofRows)
newseatLayout = seatLayout.copy()
change = True

while change is True:
	change = False
	newseatLayout = []

	for row in range(numberofRows):
		newrow = []
		for col in range(numberofCols) :
			print( num_of_adj_occupied(row,col, seatLayout))
			if seatLayout[row][col] == 'L' and num_of_adj_occupied(row,col, seatLayout) == 0:
				newrow.append('#')
				change = True
			elif seatLayout[row][col] == '#' and num_of_adj_occupied(row,col, seatLayout) >=4: 
				newrow.append('L')
				change = True
			else :
				newrow.append(seatLayout[row][col])
		newseatLayout.append(newrow)

	print(newseatLayout)
	print(seatLayout)
	seatLayout = newseatLayout.copy()


count = sum( [ listElem.count('#') for listElem in seatLayout])
print(count)
