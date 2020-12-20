import java.io.BufferedReader;
import java.io.FileReader;
import java.io.File;  // Import the File class
import java.io.IOException;

import java.util.List;
import java.util.LinkedList;
import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;


public class graph {
    public class Node{
        public String bagColour;
        public int timesContained ;
        public String getBagColour() {return bagColour;}
        public int gettimesContained() {return timesContained;}
        public Node(String v , int w){
            bagColour=v;
            timesContained=w;
        }
    }
    private Map<String,ArrayList<Node>> adjListsMap= new HashMap<>();

    //add vertex
    public void addColour(String v){
        ArrayList<Node> bagContent = new ArrayList<>();
        adjListsMap.putIfAbsent(v,bagContent);
    }
    //adding edge
    public void addEdge(String u , String v, int w ){
        if(adjListsMap.containsKey(u)){
            (adjListsMap.get(u)).add(new Node(v,w));
        }
        else {
            throw new IndexOutOfBoundsException();
        }
    }
    //getting neighbours
    public ArrayList<Node> getNeighbors(String bagColour ){
        return new ArrayList<>(adjListsMap.get(bagColour));
    }

    public int numberOfBagsIncluded(String bagColour){
        if (bagColour == "other") return 0;

        ArrayList<Node> bagContent = this.getNeighbors(bagColour);
        if (bagContent == null) return 0;
        
        int sum = 0;
        System.out.println(bagColour);

        for( Node bag: bagContent){
            System.out.println(bag.getBagColour());
            sum = sum + bag.gettimesContained() * (1+numberOfBagsIncluded(bag.getBagColour()));
            System.out.println(sum);
        }
        return sum;
    }

    public static void main(String[] args) throws IOException {
        // TODO Auto-generated method stub
        File file = new File("input.txt");
        FileReader fr = new FileReader(file);
        BufferedReader br = new BufferedReader(fr);
        String line;
        String [] tokens;

        String containerBag;
        String [] includedBags;
        String removeDot;
        String removeSpace;
        String newBag;
        String weight;

        graph g = new graph();
        while( (line = br.readLine()) != null )
        {
            tokens = line.split("contain");

            containerBag = tokens[0].replace("bags", "");
            containerBag = containerBag.replace("bag", "");
            containerBag = containerBag.replace(" ","");
            // System.out.println(containerBag);

            g.addColour(containerBag);

            removeDot = tokens[1].replace(".","");
            includedBags = removeDot.split(",");

            for(int i=0; i< includedBags.length; i++){

                newBag = includedBags[i];
                newBag = newBag.replace("bags", "");
                newBag = newBag.replace("bag", "");

                if (newBag.charAt(0) == ' '){
                    newBag = newBag.substring(1);
                }
                weight = newBag.split(" ", 2)[0];
                newBag = newBag.split(" ", 2)[1];
                newBag = newBag.replace(" ","");

                // System.out.println(weight);
                // System.out.println(newBag);

                if(!weight.equals("no")){
                    g.addColour(newBag);
                    g.addEdge(containerBag, newBag, Integer.parseInt(weight));
                }
            }
        }
        g.getNeighbors("shinygold");
        int res = g.numberOfBagsIncluded("shinygold");
        System.out.println(res);
        br.close();
    }

    

}