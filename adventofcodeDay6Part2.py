inputFile = open('input.txt')
data = inputFile.read()
group_answers =  list(data.split('\n\n'))
count = 0

for answers in group_answers:
	all_answer = answers.split('\n')
	print(all_answer)
	set_list = [set(a_l) for a_l in all_answer ]
	print(set_list)
	count = count + len(set_list[0].intersection(*set_list))

print(count)