fileName <- "input.txt"
conn <- file(fileName,open="r")
linn <-readLines(conn)
count_correct = 0

for (i in 1:length(linn)){
  print(linn[i])
  words <- strsplit(linn[i], " ")[[1]]
  minmax_word <-strsplit(words, "-")[[1]]
  character_word <-strsplit(words, "")[[2]][1]
  code_word <-strsplit(words, "")[[3]]

  count_char = 0
  
  min_num = as.numeric(minmax_word[1])
  max_num = as.numeric(minmax_word[2])
  for ( i in 1:length(code_word)){
    if(code_word[i]==character_word){
      count_char = count_char + 1
    }
  }
  if(count_char >= min_num & count_char <= max_num){
    count_correct = count_correct + 1
  }
}
print(count_correct)

close(conn)
