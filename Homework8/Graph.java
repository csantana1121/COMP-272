import java.io.*;
import java.util.*;
public class Graph
{
    int numVertex;
    int numEdge;
    int large;
    ArrayList<MyLinkedList<Integer>> graph;
    
    public Graph () {
        numVertex =0;
        numEdge =0;
        large =0; 
        graph = new ArrayList<>();
        
    }
    
    public Graph(int vertexCount) {
        
        numVertex=vertexCount;
        numEdge=0;
        large= 0;
        graph = new ArrayList<>(numVertex);
        for (int i=0;i<numVertex;i++){
            graph.add(i,new MyLinkedList<>());
            graph.get(i).addFirst(i);
        }
    }
    
   
    
    public MyLinkedList<Integer> getNeighbors(int u) {
        
        return graph.get(u);
    }
    
    public boolean edgePresent(int u, int v) {
      
        return (graph.get(u).contains(v));
        
    }
    
    public void addEdge(int u, int v) {
        // lets assume that the vertices are already created.
       if (u>=0 && u<numVertex && v>=0 && v<numVertex) { 
         if (!edgePresent(u,v))
            graph.get(u).addLast(v);
        
         if (!edgePresent(v,u))
            graph.get(v).addLast(u);
        numEdge++;
        // MyLinkedList set1 = graph.get(v);
        // MyLinkedList set2 = graph.get(u);
        // if(!set1.equals(set2)){
        //     set1 = set1.union(set2);
        //     set2 = set2.union(set1);
        // }
    }
    else throw new IndexOutOfBoundsException();
    
    
        
    }

    public void DFSNumofConnectedComponents(){
        boolean[] visited = new boolean[numVertex];
        int cc = 0;
        for (int v = 0; v < numVertex; ++v) {
            // System.out.println(graph.get(v).size());
            int temp = large;
            if (!visited[v] && graph.get(v).size()!=1) {
                large = 0;
                DFS(v, visited);
                cc++;
                if(temp>large){
                    large = temp;
                }
                // System.out.println();
            }
        }
        System.out.println("Connected Components = " + cc);
        System.out.println("Largest Connected Component " + large);
    }

    public void DFS(int v, boolean[] visited){
        visited[v] = true;
        // System.out.print(v + " ");
        large ++;
        for (int i = 0;i<graph.get(v).size();i++) {
            int val = graph.get(v).get(i);
            if (!visited[val]&& graph.get(v).size()>1)
                DFS(val, visited);
        }
    }

    public boolean DFSCheck(int v, boolean[] visited){
        visited[v] = true;
        // System.out.print(v + " ");
        large ++;
        for (int i = 0;i<graph.get(v).size();i++) {
            int val = graph.get(v).get(i);
            if (!visited[val])
                DFSCheck(val, visited);
            else{
                return false;
            }
        }
        return true;
    }

    public void numOfTrees(){
        int count  = 0;
        boolean[] visited = new boolean[numVertex];
        for (int v = 0; v < numVertex; ++v) {
            if(DFSCheck(v, visited))
                count++;
        }        
        System.out.println("Number of trees " + count);

    }
    public void LargestComponent(){
        int largest = 0;
        for (int i = 0;i<numVertex;i++) {
            // System.out.println(i);
            // MyLinkedList hold = graph.get(i);
            // System.out.println(hold.size);
            // System.out.println(graph.get(i).size());
            if (graph.get(i).size() > largest)
                largest = graph.get(i).size();
        }
        System.out.println("Largest Connected Component = " + largest);
    }
    public void BFSNumofConnectedComponents(){
        boolean[] visited = new boolean[numVertex];
        int cc = 0;
        for (int v = 0; v < numVertex; ++v) {
            if (!visited[v]&& graph.get(v).size()>1) {
                BFS(v,visited);
                cc++;
                // System.out.println();
            }
        }
        System.out.println("Connected Components = " + cc);
    }

    public void BFS(int v,boolean[] visited){
        MyLinkedList<Integer> queue = new MyLinkedList<Integer>();
 
        // Mark the current node as visited and enqueue it
        visited[v]=true;
        queue.addLast(v);
 
        while (queue.size() != 0)
        {
            v = queue.removeFirst();
            // System.out.print(v+" ");
            MyLinkedList<Integer> i = graph.get(v);
            while (!i.isEmpty())
            {
                int n = i.removeFirst();
                if (!visited[n])
                {
                    visited[n] = true;
                    queue.addLast(n);
                }
            }
        }
            
    }

    public static void main(String[] args) {
        File text = new File("Email-Enron.txt");
        int max = 0;
        try{
            Scanner scanner = new Scanner(text);
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
        // System.out.println(max);
        Graph driver = new Graph(max+1);
        try{
            Scanner scanner = new Scanner(text);
            while(scanner.hasNextLine()){
                String line = scanner.nextLine();
                String[] arrOfStr = line.split("\t");
                driver.addEdge(Integer.parseInt(arrOfStr[0]), Integer.parseInt(arrOfStr[1]));
        }
        } catch ( FileNotFoundException ex){
            ex.printStackTrace();
        }
        driver.graph.get(0).printListForward();
        driver.numOfTrees();
        System.out.println("Number of edges " + driver.numEdge);
        System.out.println("Number of vertices " + driver.numVertex);
        driver.LargestComponent();
        driver.DFSNumofConnectedComponents();
        driver.BFSNumofConnectedComponents();
        text = new File("Graph.txt");
        max = 0;
        try{
            Scanner scanner = new Scanner(text);
            while(scanner.hasNextLine()){
                String line = scanner.nextLine();
                String[] arrOfStr = line.split(",");
                for(String val : arrOfStr){
                    if(Integer.parseInt(val) > max){
                        max = Integer.parseInt(val);
                    }
                }
        }
        } catch ( FileNotFoundException ex){
            ex.printStackTrace();
        }
        // System.out.println(max);
        Graph tester = new Graph(max+1);
        try{
            Scanner scanner = new Scanner(text);
            while(scanner.hasNextLine()){
                String line = scanner.nextLine();
                String[] arrOfStr = line.split(",");
                tester.addEdge(Integer.parseInt(arrOfStr[0]), Integer.parseInt(arrOfStr[1]));
        }
        } catch ( FileNotFoundException ex){
            ex.printStackTrace();
        }
        // driver.graph.get(0).printListForward();
        System.out.println();
        System.out.println("Graph.txt dataset: ");
        tester.numOfTrees();
        System.out.println("Number of edges " + tester.numEdge);
        System.out.println("Number of vertices " + tester.numVertex);
        tester.LargestComponent();
        tester.DFSNumofConnectedComponents();
        tester.BFSNumofConnectedComponents();
    }
    
}
