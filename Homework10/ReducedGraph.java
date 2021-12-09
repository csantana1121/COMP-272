import java.util.HashMap;

public class ReducedGraph {
    ArrayList<DirectedNodeList> dGraph;
    int numVertex;
    boolean [] marked;
    HashMap<Integer, ArrayList<Integer>> SCC;
    public ReducedGraph() {
        dGraph = new ArrayList<>();
        numVertex=0;
        
    }
    
    public ReducedGraph(int n, HashMap scc) {
      numVertex =n;
      dGraph = new ArrayList<>(n);
      marked= new boolean[n];
      SCC = scc;
      for (int i=0;i<numVertex;i++)
       dGraph.add(new DirectedNodeList());
    }

    public void addVertex (int k) {
        // k is within the bounds of 0 and max Vertex label of the original directed graph
        //hDGraph.add(k,new DirectedNodeList());
        //so call addVertex before you add Edge if they don't already exist
    }
    
    //getter methods for numVertex and numEdges
    public boolean isEdgePresent(int u , int v) {
        //check if (u,v) is already present in the reduced graph hDGraph
        return false;
    }
    public void addEdge(int u, int v) {
        //assume all vertices are created
        //directed edge u to v will cause outdegree of u to go up and indegree of v to go up.
    
        //if (u>=0 &&u <numVertex && v>=0 && v < numVertex) {
            // if edge not present {
            //     if (u!=v) {
            //         getNeighborList(u).addToOutList(v);
            //         getNeighborList(v).addToInList(u);
            //     }
            // }
            //do throw indexout of bounds exception
            numEdges++;
        // }
    }
}
