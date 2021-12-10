import java.util.HashMap;

public class ReducedGraph {
    HashMap<Integer, DirectedNodeList> hDdGraph;
    int numVertex;
    boolean [] marked;
    int[] V;
    public ReducedGraph() {
        dGraph = new ArrayList<>();
        numVertex=0;
        
    }
    
    public ReducedGraph(int n) {
      numVertex =n;
      hDdGraph = new HashMap<>();
      marked= new boolean[n];
    //   V = v;
    //   for (int i=0;i<numVertex;i++)
    //    dGraph.add(new DirectedNodeList());
    }
    public DirectedNodeList getNeighborList(int u) {
        return dGraph.get(u);
    }

    public void addVertex (int k) {
        // k is within the bounds of 0 and max Vertex label of the original directed graph
        //hDGraph.add(k,new DirectedNodeList());
        hDGraph.add(k,new DirectedNodeList());
        //so call addVertex before you add Edge if they don't already exist
    }
    
    //getter methods for numVertex and numEdges
    public boolean isEdgePresent(int u , int v) {
        //check if (u,v) is already present in the reduced graph hDGraph
        if (getNeighborList(u).getInList().contains(v) && getNeighborList(v).getOutList().contains(u)) {
            return true;
        } else
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
