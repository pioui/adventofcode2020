
joltageRating =[int(line.strip()) for line in open("/home/piyi/Documents/adventofcode2020/input.txt", 'r')]
joltageRating.append(max(joltageRating)+3)
joltageRating.sort(reverse = False)

print(joltageRating)

# power = len(joltageRating)
# last_adapter = 0
# for index in range(0,len(joltageRating)):
# 	if (joltageRating[index] > last_adapter+3):
# 		power = power -1
# 		last_adapter = joltageRating[index-1]
# 	print(last_adapter, joltageRating[index], power)
# print(power)

storage = {0:1, }

for adapter in joltageRating:
    storage[adapter] = 0
    if adapter - 1 in storage: storage[adapter] = storage[adapter] + storage[adapter - 1]
    if adapter - 2 in storage: storage[adapter] = storage[adapter] + storage[adapter - 2]
    if adapter - 3 in storage: storage[adapter] = storage[adapter] + storage[adapter - 3]

print(storage)
print(storage[max(joltageRating)])
