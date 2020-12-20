
joltageRating =[int(line.strip()) for line in open("/home/piyi/Documents/adventofcode2020/day10_input.txt", 'r')]

joltageRating.sort(reverse=False)

print('Sorted list (in Descending):', joltageRating)

joltageRating.append(max(joltageRating)+3)
joltageRating.append(0)
print(joltageRating)

ones=0
threes = 0
lastAdapter = 0

for adapter in joltageRating:
	if (adapter-lastAdapter == 1) : 
		ones = ones +1
		lastAdapter = adapter

	if (adapter-lastAdapter == 2) : 
		lastAdapter = adapter

	if (adapter-lastAdapter == 3) : 
		threes = threes +1
		lastAdapter = adapter
print(ones)
print(threes)
print(ones*threes)