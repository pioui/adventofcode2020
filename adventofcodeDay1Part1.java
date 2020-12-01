import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.util.Scanner; // Import the Scanner class to read text files
import java.util.ArrayList;
import java.util.List;
import java.util.Collections;

public class adventofcodeDay1Part1 {
  public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        File readFile = new File("/home/piyi/input.txt");
    try{
        Scanner fileReader = new Scanner(readFile);
        List<Integer> inputNumbers = new ArrayList<>();

        while (fileReader.hasNextLine()) {
          String data = fileReader.nextLine();
          int intData = Integer.parseInt(data);
          inputNumbers.add(intData);
        }

        fileReader.close();
        Collections.sort(inputNumbers);

        int minIndex = 0;
        int maxIndex = inputNumbers.size()-1;
        int sum = inputNumbers.get(minIndex)+ inputNumbers.get(maxIndex);

        while(sum != 2020){
          if(sum > 2020){
            maxIndex--;
          }
          if(sum < 2020){
            minIndex++;
          }
          sum = inputNumbers.get(minIndex)+ inputNumbers.get(maxIndex);
        }
        System.out.println(inputNumbers.get(minIndex)*inputNumbers.get(maxIndex));
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
