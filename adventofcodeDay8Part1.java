import java.io.BufferedReader;
import java.io.FileReader;
import java.io.File;  // Import the File class
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.LinkedList;
import java.util.HashSet;
import java.util.Set;

import java.util.Map;
import java.util.LinkedList; 
import java.util.Queue; 

public class adventofcodeDay8Part1{
    public static class Node{
        public String operation;
        public int argument ;
        public String getAction() {return operation;}
        public int getAmount() {return argument;}
        public Node(String v , int w){
            operation=v;
            argument=w;
        }
    }
    
    public static void main(String[] args) throws IOException {
        // TODO Auto-generated method stub
        File file = new File("input.txt");
        FileReader fr = new FileReader(file);
        BufferedReader br = new BufferedReader(fr);
        String line;
        String [] tokens;

        ArrayList<Node> instructions = new ArrayList<>();


        // directedGraph g = new directedGraph();
        while( (line = br.readLine()) != null ){
            tokens = line.split(" ");
            instructions.add(new Node(tokens[0], Integer.parseInt(tokens[1])));
        }

        int accumulator = 0;
        int index = 0;

        String operation;
        int argument;

        Set<Integer> doneIndex = new HashSet<>();        

        while( !doneIndex.contains(index)){
            // System.out.println(index);
            doneIndex.add(index);

            operation = instructions.get(index).operation;
            argument = instructions.get(index).argument;

            if(operation.equals("acc")){
                accumulator = accumulator + argument;
                index = index + 1;
            }
            else if(operation.equals("nop")){
                index = index + 1;
            }
            else if(operation.equals("jmp")){
                index = index + argument;
            }
            System.out.println(index);

        }
        System.out.println(index);
        System.out.println(accumulator);
        br.close();
     }



}