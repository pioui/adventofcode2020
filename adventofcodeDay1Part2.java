import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.util.Scanner; // Import the Scanner class to read text files
import java.util.ArrayList;
import java.util.List;
import java.util.Collections;

public class adventofcodeDay1Part2 {
  public static void main(String[] args) {
      long startTime = System.currentTimeMillis();
      File readFile = new File("/home/piyi/input.txt");
    try{
      Scanner fileReader = new Scanner(readFile);

      List<Integer> numbers = new ArrayList<>();

      while (fileReader.hasNextLine()) {
        String data = fileReader.nextLine();
        int intData = Integer.parseInt(data);
        numbers.add(intData);
      }

      fileReader.close();
      Collections.sort(numbers);

      int minIndex = 0;
      int midIndex = 1;
      int maxIndex = numbers.size()-1;
      int sum = numbers.get(minIndex)+ numbers.get(midIndex)+ numbers.get(maxIndex);

      while(sum != 2020){
        if(sum > 2020){
          maxIndex--;
        }
        if(sum < 2020){
          if(numbers.get(minIndex)+ numbers.get(midIndex+1)+ numbers.get(maxIndex) > 2020){
            minIndex++;
          }
          else if (numbers.get(minIndex)+ numbers.get(midIndex+1)+ numbers.get(maxIndex) < 2020){
            midIndex++;
          }
        }

        sum = numbers.get(minIndex)+ numbers.get(midIndex)+ numbers.get(maxIndex);
      }
      System.out.println(numbers.get(minIndex)* numbers.get(midIndex)* numbers.get(maxIndex));
    }  
  
  catch(Exception E){
        System.out.println(E);
    System.out.println("NO");
  }
        long endTime = System.currentTimeMillis();
        long elapsedTime = endTime - startTime;
        System.out.println( (float) elapsedTime/1000);
  }    
}
