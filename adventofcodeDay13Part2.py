import sympy


inputFile = open("input.txt", "r")
earliestTimestamp = int(inputFile.readline())

notes = inputFile.readline().split(',')

a = []
n = []
N = 1
for i in range(0,len(notes)):
	if notes[i]!='x':
		n.append(int(notes[i]))
		a.append(int(notes[i])-i)
		N = N * int(notes[i])

x = 0
for i in range(0,len(n)):
	x = x + a[i]* N // n[i] * sympy.mod_inverse(N // n[i], n[i])

timestamp = x % N

print(int(timestamp))