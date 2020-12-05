def tree_counter(filename, right, down):
	file = open(filename, "r")
	count = 0
	pos = right
	for i in range(0,down): firstLine = file.readline()
	length = len(firstLine) - 2

	for line in file:
		if(pos > length):
			pos = pos - length - 1

		if(line[pos] is '#'):
			count = count+1
		pos = pos + right
		for i in range(0,down-1): file.readline()


	return count

print(tree_counter("input.txt",1, 1)* tree_counter("input.txt",3, 1)*tree_counter("input.txt",5, 1)*tree_counter("input.txt",7, 1)*tree_counter("input.txt",1, 2))