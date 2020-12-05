inputFile = open('input.txt')
data = inputFile.read()
passportList =  list(filter(lambda x : x != '', data.split('\n\n')))

mendatory = ['byr', 'iyr', 'eyr', 'hgt', 'hcl', 'ecl', 'pid']
count_valid = 0
for passport in passportList:
	passport_details = dict((x.split(':')) for x in passport.split())
	if all(keys in [*passport_details] for keys in mendatory):
		count_valid = count_valid+1

print(count_valid)