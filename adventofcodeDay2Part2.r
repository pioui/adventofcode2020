fileName <- "input.txt"
input <- file(fileName,open="r")
line <-readLines(input)
countCorrect = 0

for (i in 1:length(line)){
  print(line[i])
  words <- strsplit(line[i], " ")[[1]]
  mixmaxString <-strsplit(words, "-")[[1]]
  characterKey <-strsplit(words, "")[[2]][1]
  password <-strsplit(words, "")[[3]]
  
  firstPosition = as.numeric(mixmaxString[1])
  secondPosition = as.numeric(mixmaxString[2])
    if(password[firstPosition] == characterKey && password[secondPosition] != characterKey){
      countCorrect = countCorrect + 1
    }
    if(password[firstPosition] != characterKey && password[secondPosition] == characterKey){
      countCorrect = countCorrect + 1    
}
print(countCorrect)
}
close(input)
