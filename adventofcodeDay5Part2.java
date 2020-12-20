import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.util.Scanner; // Import the Scanner class to read text files
import java.util.ArrayList;
import java.util.List;
import java.util.Collections;
import java.lang.Math;

public class adventofcodeDay5Part2 {
  public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        File readFile = new File("/home/piyi/input.txt");
    try{
        Scanner fileReader = new Scanner(readFile);
        int max = 0;
        int seatID = 0;
        List<Integer> seatIDs = new ArrayList<>();

        while (fileReader.hasNextLine()) {
          String data = fileReader.nextLine();
          String[] arrOfStr = data.split("", -2); 
          int column = 0;
          int row = 0;

          for( int i=0; i < 7; i++ ){
            if( arrOfStr[i].equals("B")) 
              {
                row = row + (int) Math.pow(2, 6-i);
              }
          }
          for( int i=7; i < 10; i++ ){
            if( arrOfStr[i].equals("R"))
              {

                column = column + (int) Math.pow(2, 9-i);
              }
          }

          seatID = row * 8 + column;
          seatIDs.add(seatID);
        }
        fileReader.close();

        for (int i = Collections.min(seatIDs); i<Collections.max(seatIDs);i++){
          if (seatIDs.contains(i-1) && seatIDs.contains(i+1) && !seatIDs.contains(i)){
            System.out.println(i);
            break;
          }
        }
    }
    catch(Exception E){
        System.out.println(E);
    }
  }
}