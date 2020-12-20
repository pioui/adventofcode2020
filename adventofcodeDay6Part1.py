inputFile = open('input.txt')
data = inputFile.read()
group_answers =  list(data.split('\n\n'))
count = 0


for answers in group_answers:

	all_answer = answers.replace('\n','')
	all_answer_set = set(''.join(all_answer))
	count = count+len(all_answer_set)


print(count)
