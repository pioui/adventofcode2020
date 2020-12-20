import itertools

preambleLenghth = 25
data = [int(line.strip()) for line in open("/home/piyi/Documents/adventofcode2020/input.txt", 'r')]

for checkIndex in range(preambleLenghth, len(data)):
	check = data[checkIndex]
	preamble = data[checkIndex - preambleLenghth: checkIndex]

	comb = list(itertools.combinations(preamble, 2))
	sums = [sum(tup) for tup in comb]

	if check not in sums: 
 		invalid = check
 		invalidIndex = checkIndex

# print(invalid)
# print(invalidIndex)

for first in range(0, invalidIndex):
	for last in range(first+1, invalidIndex):
		partialSum = sum(data[first:last])
		# print(partialSum)
		if partialSum == invalid : 
			weakness = max(data[first:last])+min(data[first:last])
			print(weakness)
			break
