
import java.util.*;
import java.io.*;
public class DirectedGraph  {
    ArrayList<DirectedNodeList> dGraph;
    int numVertex;
   boolean [] marked;
   int number;
   ArrayList<Integer> component;
   int[] finishing;
   HashMap<Integer, ArrayList<Integer>> SCC;
   int maxlen;

   // int number;
   //Look at #4 for answer to 3 can just HashMap<Integer,Arraylist<Integer>>
   // intialize Hashmap POGGIES
   //create an arraylist to store each component coming out of recrusive DFT
    
    
    public DirectedGraph() {
        dGraph = new ArrayList<>();
        numVertex=0;
        
    }
    
    public DirectedGraph(int n) {
      numVertex =n;
      dGraph = new ArrayList<>(n);
      marked= new boolean[n];
      finishing = new int[n];
      SCC = new HashMap<>();
      maxlen =0;
      for (int i=0;i<numVertex;i++)
       dGraph.add(new DirectedNodeList());
    }
    
    public void addEdge(int u, int v) {
       // assume all vertices are created
       // directed edge u to v will cause outdegree of u to go up and indegree of v to go up.
       
       if (u>=0 && u<numVertex && v>=0 && v<numVertex) { 
	      if (u!=v) {
           getNeighborList(u).addToOutList(v);
           getNeighborList(v).addToInList(u);
		  }
        }
        else throw new IndexOutOfBoundsException();
    }
    
    public DirectedNodeList getNeighborList(int u) {
        return dGraph.get(u);
    }
    
    public void printAdjacency(int u) {
       DirectedNodeList dnl = getNeighborList(u);
       System.out.println ("vertices going into "+u+"  "+dnl.getInList());
       System.out.println ("vertices going out of "+u+"  "+dnl.getOutList());
       System.out.println();
    }
    
    public void postOrderDepthFirstTraversal() {
       for (int i=0;i<numVertex;i++) 
       if (!marked[i])
           postOrderDFT (i);
       
    }
    public void postOrderDFT(int v){
        
        marked[v]=true;
        
        for (Integer u:dGraph.get(v).getInList())
        // replace dGraph.get(v).getInList()
        if (!marked[u]) postOrderDFT(u);
            finishing[number++] = v;
       //save this finishing value into an array finishing[k] last element is the last finishing vertex.
       // finishing[number++] = v
    }
    
    public void depthFirstTraversal() {
       for (int i=finishing.length -1;i>0;i--) {
       if (!marked[finishing[i]]){
       // leaders come out here :namely i
       // intialize arraylist empty make global arraylist or something
            component = new ArrayList<>();
            dFT (finishing[i]);
            SCC.put(finishing[i], component);
            maxlen = Math.max(maxlen, component.size());
       }
    }
           //[it the arraylist in the hashmap at key i]
           // have a set array and go through adding the leader to all the elements of the now
           // full arraylist that has the connected components for that leader.
           //then you can create the find method using this array. Create on fly with hashmap.
           // Have to create a seperate DirectedGraph java file that stores edges HashDirectedGraph
           // edges being key value of the integer leader and Directed NodeList object ex.
           //Hashmap<Integer, DirectedNodeList> hDGraph; underlying data structure.
        
       
    }
    public void dFT(int v){
        //strongly connected components come out here
        // System.out.println(v);
        //add v to arraylist
        component.add(v);
        marked[v]=true;
        
        for (Integer u:dGraph.get(v).getOutList())
        if (!marked[u]) dFT(u);
       
    }
    
    
    // For number 4: Try to make a find[u] and find[v] for each edge and then if 
    /*find[u] != find[v] then add that edge. Otherwise if they are equal ignore the edge.
    The find method returns the leader. In the code create a set array
    */
    public ReducedGraph reduceGraph(){
        ReducedGraph rd = new ReducedGraph(numVertex,SCC);
        
    }
    public static void main(String[] args) {
        int n =6;
        DirectedGraph dg = new DirectedGraph(n);
        dg.addEdge(0,1);
        dg.addEdge(0,2);
        dg.addEdge(2,4);
        dg.addEdge(1,4);
        dg.addEdge(2,3);
        dg.addEdge(3,5);
        dg.addEdge(4,5);
        File text = new File("Slashdot0902.txt");
        int max = 0;
        try{
            Scanner scanner = new Scanner(text);
            scanner.nextLine();
            scanner.nextLine();
            scanner.nextLine();
            scanner.nextLine();
            while(scanner.hasNextLine()){
                String line = scanner.nextLine();
                String[] arrOfStr = line.split("\t");
                for(String val : arrOfStr){
                    if(Integer.parseInt(val) > max){
                        max = Integer.parseInt(val);
                    }
                }
        }
        } catch ( FileNotFoundException ex){
            ex.printStackTrace();
        }
        System.out.println(max);
        DirectedGraph driver = new DirectedGraph(max+1);
        try{
            Scanner scanner = new Scanner(text);
            scanner.nextLine();
            scanner.nextLine();
            scanner.nextLine();
            scanner.nextLine();
            while(scanner.hasNextLine()){
                String line = scanner.nextLine();
                String[] arrOfStr = line.split("\t");
                driver.addEdge(Integer.parseInt(arrOfStr[0]), Integer.parseInt(arrOfStr[1]));
        }
        } catch ( FileNotFoundException ex){
            ex.printStackTrace();
        }
        
        
        
      /*  
        dg.addEdge(0,1);
        dg.addEdge(0,2);
        dg.addEdge(1,2);
        dg.addEdge(1,3);
        dg.addEdge(2,4);
        dg.addEdge(2,3);
        dg.addEdge(3,1);
        dg.addEdge(4,1);
        dg.addEdge(4,3);
        dg.addEdge(4,0);
        dg.addEdge(3,0);
        */
        
       // for (int i=0;i<dg.numVertex;i++)
       //  dg.printAdjacency(i);
        // System.out.println ("regular depth first traversal");
        // dg.depthFirstTraversal();
        // System.out.println ();
        // dg.marked= new boolean[n];
        // System.out.println("post order depth first traversal");
        // dg.postOrderDepthFirstTraversal();
        
        // System.out.println ("regular depth first traversal");
        // driver.depthFirstTraversal();
        // System.out.println ();
        driver.marked= new boolean[max+1];
        System.out.println("post order depth first traversal");
        driver.postOrderDepthFirstTraversal();
        System.out.println(driver.finishing.length);
        System.out.println(driver.finishing[max]);
        // for(int val: driver.finishing)
        //     System.out.println(val);
        driver.marked = new boolean[max+1];
        driver.depthFirstTraversal();
        System.out.println("Number of Strongly Connected Components: "+driver.SCC.size());
        System.out.println("Max size among all strongly connected Components: "+driver.maxlen);
        ReducedGraph rg = driver.reduceGraph();
        
        
    }
    

   
}
