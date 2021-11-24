import java.util.*;
import java.io.*;
public class Kruskal  {
    
    
    int[] findSet;
    ArrayList<MyLinkedList<Integer>> vertexSets;
   static int numVertex;
   static int numEdges;
    static ArrayList<WeightedEdge> edgeSet;
   static int totalChanges;
   static PriorityQueue<WeightedEdge> pq;
   int[] setArr;
   int[] height;
   int count;
    
    public Kruskal(int n, int m){
        numVertex =n;
        numEdges=m;
        totalChanges=0;
        count=0;
       findSet = new int[n]; 
       setArr=new int[n];
       height=new int[n];
       Arrays.fill(height, 0);
       vertexSets = new ArrayList<>(n);
       for (int i=0;i<n;i++) {
           findSet[i]=i;
           setArr[i]=i;
           
           vertexSets.add(new MyLinkedList<Integer>());
           vertexSets.get(i).addFirst(i);
        }
       // edgeSet = new ArrayList<>();
    }
    
    public int getComponentSize(int u){
       return vertexSets.get(u).size(); 
    }
    
    
    public int findComponent(int u) {
       return findSet[u]; 
    }
    
    public void changeComponent(MyLinkedList<Integer> my, int max){
        totalChanges+=my.size();
         if (!my.isEmpty()){
            Node<Integer> temp = my.getFirst();
            do {
            findSet[temp.getInfo()]=max;  
            temp = temp.getNext();  
        } while (temp!=null);
    }
        else {
               System.out.println("empty list ...");
            throw new NoSuchElementException();
        }
        
    }
    
    public static void readAndStoreGraph(String fileName, String filename2) {
     
        try{
        Scanner sc =new Scanner(new File(fileName));
        Scanner sc2 =new Scanner(new File(filename2));
        String s;
    //    int i =0;
       int maxV=0;
       edgeSet = new ArrayList<>();
      // graph.add(new ArrayList<Integer>());
       
     while (sc.hasNextLine() && sc2.hasNextLine()) {
           s = sc.nextLine();
           if (s.isEmpty()) continue;
           
          // String[] line= s.split("\\s+");
           String[] line= s.split("\t");
        int v1=  Integer.parseInt(line[0]);
       
          
        int v2=  Integer.parseInt(line[1]);
        int v3 =  Integer.parseInt(sc2.nextLine());
        int p= Math.max(v1,v2);
        if (p>maxV) maxV=p;
        edgeSet.add(new WeightedEdge(v1,v2,v3));
        // i++;
          
           
       
    }
    // numEdges=i;
    numVertex=maxV;
    pq = new PriorityQueue<>(edgeSet);
    // System.out.println(pq.peek());
}
catch (FileNotFoundException e) {
}
} 

    
    public void getComponents(){
        HashSet<Integer> comp = new HashSet<>();
        ArrayList<Integer> al = new ArrayList<>();
        //int count=0;
        for (int i: findSet)
          comp.add(i);
        System.out.println(comp.size());
      /*  for (Integer j:comp) {
          al.add(vertexSets.get(j).size());
         // System.out.println();
        }
        Collections.sort(al);
        System.out.println(al);*/
        
    }
    
    public void mergeComponents (int u, int v) {
        int p = findComponent(u);
        int q = findComponent(v);
        int min=0;
        int max=0;
        if (p!=q) {
            if (getComponentSize(p)>getComponentSize(q)){
              min =q; 
              max=p;
            }
              else {
                    min=p;
                    max=q;
                }
            // merge min with the max
            MyLinkedList<Integer> myl = vertexSets.get(min);
            vertexSets.get(max).appendList(myl);
            changeComponent(myl,max);
            
        }
    }

    public int find3(int x){
        int r  = x;
        while(findSet[r] != r){
            r = findSet[r];
        }
        int i = x;
        while(i != r){
            int j = findSet[i];
            findSet[i] = r;
            i = j;
        }
        return i;
    }
    
    public void merge3(int a, int b){
        if(height[a] == height[b]){
            height[a] = height[b] +1;
            findSet[b] = a;
        } else{
            if(height[a]>height[b])
                findSet[b] = a;
            else
                findSet[a] = b;
        }
    }
     public static void main(String[] args) {
         
        //  numVertex=12;
        //  numEdges=10;
     //  readAndStoreGraph("Email-Enron.txt");
     readAndStoreGraph("artist_edges.txt","Weights.txt");
    //  System.out.println(pq.peek());
         Kruskal cc = new Kruskal(numVertex+1,numEdges);
        //  System.out.println(cc.pq.peek());
      /*  cc.edgeSet = new ArrayList<>();
         cc.edgeSet.add(new Edge(1,9));
         cc.edgeSet.add(new Edge(5,6));
         cc.edgeSet.add(new Edge(4,10));
         cc.edgeSet.add(new Edge(11,12));
         cc.edgeSet.add(new Edge(9,10));
         cc.edgeSet.add(new Edge(6,7));
         cc.edgeSet.add(new Edge(1,4));
         cc.edgeSet.add(new Edge(8,11));
         cc.edgeSet.add(new Edge(3,11));
         cc.edgeSet.add(new Edge(2,5));*/
         
         
         
        
     long t1 = System.currentTimeMillis();
        //n= number of vertices
        //set up the priority queue of weighted edges.
        int treeEdges = 0;
        int totaledges = pq.size();
        double totalweight  = 0;
        ArrayList<WeightedEdge> finalvals = new ArrayList<>();
        while (treeEdges < numVertex-1) {

            WeightedEdge edge = pq.poll();
        // edge = (v1,v2)
            
            if (edge!=null) {
                int p1 =  cc.find3(edge.v1);
                int p2 = cc.find3(edge.v2);
                if (p1!=p2) {
                    // add edge to an arraylist;
                    finalvals.add(edge);
                    totalweight += edge.weight;
                    cc.merge3( p1,p2);
                    treeEdges ++;
        
        
        }// end while
        
        }// end if
        }
        System.out.println("Max vertex label: " + numVertex);
        System.out.println("Number of edges: " + totaledges);
        System.out.println("MST Edges: " + treeEdges);
        System.out.println("Number of Edges considered: " + (totaledges - pq.size()));
        System.out.println("Total weight of MST: " +totalweight);
        System.out.println("Edges held within finalvals ArrayList");
        //ArrayList finalvals holds the edges of the spanning Tree
        // System.out.println(finalvals);
             long t2=System.currentTimeMillis();
            System.out.println("time taken "+ (t2-t1)*1.0/1000);
            
           // cc.getComponents();
           // System.out.println(totalChanges);
       
         
         
         
    }
        
}
    
