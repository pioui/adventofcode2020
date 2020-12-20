import itertools

preambleLenghth = 25
data = [int(line.strip()) for line in open("/home/piyi/Documents/adventofcode2020/input.txt", 'r')]

for checkIndex in range(preambleLenghth, len(data)):
	check = data[checkIndex]
	preamble = data[checkIndex - preambleLenghth: checkIndex]

	comb = list(itertools.combinations(preamble, 2))
	sums = [sum(tup) for tup in comb]

	if check not in sums: print(check)


