f = open("input.txt", "r")
count = 0
pos = 3
firstLine = f.readline()
length = len(firstLine) - 2

for line in f:
	if(pos > length):
		pos = pos - length - 1
	print(line[pos])

	if(line[pos] is '#'):
		count = count+1
	pos = pos + 3

print(count)
