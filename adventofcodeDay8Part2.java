import java.io.BufferedReader;
import java.io.FileReader;
import java.io.File;  // Import the File class
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.LinkedList;
import java.util.HashSet;
import java.util.*;

import java.util.Set;

import java.util.Map;
import java.util.LinkedList; 
import java.util.Queue; 

public class adventofcodeDay8Part2{
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

    public static void rm(Stack t){
        t.pop();
    }
    
    public static void main(String[] args) throws IOException {
        // TODO Auto-generated method stub
        File file = new File("input.txt");
        FileReader fr = new FileReader(file);
        BufferedReader br = new BufferedReader(fr);
        String line;
        String [] tokens;
        int accumulator = 0;
        String operation;
        int argument;
        int index;
        int goestoIndex;
        Set<Integer> doneIndex = new HashSet<>();  
        Stack<Integer> loopIndex = new Stack<Integer>();
        ArrayList<Node> instructions = new ArrayList<>();


        // Read lines to an Array
        while( (line = br.readLine()) != null ){
            tokens = line.split(" ");
            instructions.add(new Node(tokens[0], Integer.parseInt(tokens[1])));
        }

        int instructionsSize = instructions.size();


        // Find the index of operation to change
        for( index = instructionsSize-1; index>=0; index--){
            operation = instructions.get(index).operation;
            argument = instructions.get(index).argument;
            if(operation.equals("jmp") && argument<0){
                loopIndex.push(index);
            }
            if(operation.equals("jmp") && argument>0){
                goestoIndex = index+argument;
                while ( !loopIndex.empty() ){
                    System.out.println(loopIndex);
                    System.out.println(loopIndex.peek());
                    System.out.println(goestoIndex);
                    if(loopIndex.peek() >= goestoIndex) break;
                    loopIndex.pop();
                }
            }
        }

        System.out.println(loopIndex);


        if(loopIndex.size() == 1){
        instructions.set(loopIndex.peek(), new Node("nop", instructions.get(loopIndex.peek()).argument));
        }
        else{
            int minIndex =  loopIndex.empty() ? 0 : loopIndex.pop();
            int maxIndex = minIndex;
            while (!loopIndex.empty()){
                maxIndex = loopIndex.pop();
            }
            for( index = maxIndex; index >=0; index--){
                operation = instructions.get(index).operation;
                argument = instructions.get(index).argument;
                if(operation.equals("nop") && argument+index > maxIndex){
                    instructions.set(index, new Node("jmp", instructions.get(index).argument));
                    break;
                }
            }
        }


        index = 0;      

        while( !doneIndex.contains(index)){
            // System.out.println(index);
            if (index > instructionsSize-1 ) break;
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
        }
        System.out.println(index);
        System.out.println(accumulator);
        br.close();

    }
}


