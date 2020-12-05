
def is_colour(colour):
	if (len(colour) != 7): return False
	if colour[0] == '#':
		colour_code = list(colour)
		if all((((ord(cc) >=97) and (ord(cc) <= 102) ) or ((ord(cc) >= 48) and (ord(cc) <= 57) )) for cc in colour_code[1:]):
			return True
	return False

def is_correct_height(mes, value):
	print(mes, value)
	if (mes == 'cm' and value >=150 and value <=193): return True
	if (mes == 'in' and value >=59 and value <=76): return True
	return False

def is_passportid(id):
	id_code = list(id)
	if(len(id_code) != 9): return False
	# if (id_code[0] != '0'): return False
	if all(((ord(cc) >=48) and (ord(cc) <= 57) ) for cc in id_code):
		return True
	return False

def are_valid(passport_details):
	if( ((int(passport_details['byr'])>=1920) and (int(passport_details['byr'])<=2002))
		and ((int(passport_details['iyr'])>=2010) and (int(passport_details['iyr'])<=2020))
		and ((int(passport_details['eyr'])>=2020) and (int(passport_details['eyr'])<=2030))
		and (is_correct_height(passport_details['hgt'][-2:], int(passport_details['hgt'][:-2])))
		and (is_colour(passport_details['hcl']))
		and (any(passport_details['ecl'] == colour for colour in ['amb', 'blu', 'brn', 'gry', 'grn', 'hzl', 'oth']))
		and (is_passportid(passport_details['pid']))): return True
	return False



inputFile = open('input.txt')
data = inputFile.read()
passportList =  list(filter(lambda x : x != '', data.split('\n\n')))

mendatory = ['byr', 'iyr', 'eyr', 'hgt', 'hcl', 'ecl', 'pid']
count_valid = 0
for passport in passportList:
	passport_details = dict((x.split(':')) for x in passport.split())
	if all(keys in [*passport_details] for keys in mendatory):
		if are_valid(passport_details):
			count_valid = count_valid + 1

print(count_valid)

