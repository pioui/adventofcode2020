import java.io.BufferedReader;
import java.io.FileReader;
import java.io.File;  // Import the File class
import java.io.IOException;

import java.util.List;
import java.util.LinkedList;
import java.util.HashMap;
import java.util.Map;

public class directedGraph
{
    Map<String, LinkedList<String>> adj;

    public directedGraph() {
        adj = new HashMap<String, LinkedList<String>>();
    }

    public void addNode(String node) 
    {
        adj.putIfAbsent(node, new LinkedList<String>());
    }

    public void addNeighbor(String v1,String v2) {
       this.addNode(v1);
       adj.get(v1).add(v2);
       // System.out.print("node ");
       // System.out.print(v1);
       // System.out.print(" ");
       // System.out.println(v2);

    }

    public List<String> getNeighbors(String v) {
       return adj.get(v);
    }

    public void BFS(String s)
    {
        // Mark all the vertices as not visited(By default
        // set as false)
        Map<String, Boolean> visited = new HashMap<String,Boolean>();
 
        // Create a queue for BFS
        LinkedList<String> queue = new LinkedList<String>();
 
        // Mark the current node as visited and enqueue it
        visited.put(s, true);

        queue.add(s);

 		List<String> neighbors;

 		System.out.println(queue.size());

 		Integer count = 0;


        while (queue.size() != 0)
        {
        	System.out.print("queue: ");
        	System.out.println(queue);
            s = queue.poll();
            System.out.print("search node: ");
            System.out.println(s);
            neighbors = getNeighbors(s);

            if (neighbors != null){
            	for(int i =0; i< neighbors.size(); i++){
            		System.out.print("neigh: ");
            		System.out.println(neighbors.get(i));

	             	// System.out.println(neighbors.get(i));
					if (!visited.containsKey(neighbors.get(i))){
						visited.put(neighbors.get(i), false);		
					}

	            	if (!visited.get(neighbors.get(i))){
	                	visited.put(neighbors.get(i), true);
	                    queue.add(neighbors.get(i));
	                    count ++;
	                }
        		}
            }
            System.out.println();
    	}
    	System.out.println(count);

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

        directedGraph g = new directedGraph();
        while( (line = br.readLine()) != null )
        {
        	tokens = line.split("contain");

        	containerBag = tokens[0].replace("bags", "bag");
        	containerBag = containerBag.replace(" ","");

            g.addNode( tokens[0]);

            removeDot = tokens[1].replace(".","");
        	includedBags = removeDot.split(",");

        	for(int i=0; i< includedBags.length; i++){

        		newBag = includedBags[i];
        		newBag = newBag.replace("bags", "bag");
        		newBag = newBag.replace(" ","");
        		newBag = newBag.split("", 2)[1];

   	            g.addNode( newBag);
            	g.addNeighbor(newBag, containerBag);
        	}
        }
        g.BFS("shinygoldbag");

        br.close();
     }



}