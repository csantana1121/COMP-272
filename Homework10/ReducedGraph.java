import java.util.ArrayList;
import java.util.HashMap;

public class ReducedGraph {
    HashMap<Integer, DirectedNodeList> hDdGraph;
    int numVertex;
    boolean [] marked;
    int numEdges;
    HashMap<Integer, ArrayList<Integer>> scc;
    int e = 28331;
    public ReducedGraph() {
        hDdGraph = new HashMap<>();
        numVertex=0;
        numEdges = 0;
    }
    
    public ReducedGraph(int n) {
      numVertex =n;
      hDdGraph = new HashMap<>();
      marked= new boolean[n];
      numEdges = 0;
    //   for (int i=0;i<numVertex;i++)
    //    dGraph.add(new DirectedNodeList());
    }
    public DirectedNodeList getNeighborList(int u) {
        return hDdGraph.get(u);
    }

    public void addVertex (int k) {
        // k is within the bounds of 0 and max Vertex label of the original directed graph
        //hDGraph.add(k,new DirectedNodeList());
        marked[k] = true;
        hDdGraph.put(k,new DirectedNodeList());
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
        if (u >= 0 && u < numVertex && v >=0 && v< numVertex) {
            if(!marked[u])
                addVertex(u);
            if(!marked[v])
                addVertex(v);
            if(!isEdgePresent(u, v)) {
                if (u!=v && numEdges !=e) {
                    getNeighborList(u).addToOutList(v);
                    getNeighborList(v).addToInList(u);
                    numEdges++;
                }
            }
        }
        //if (u>=0 &&u <numVertex && v>=0 && v < numVertex) {
            // if edge not present {
            //     if (u!=v) {
            //         getNeighborList(u).addToOutList(v);
            //         getNeighborList(v).addToInList(u);
            //     }
            // }
            //do throw indexout of bounds exception
           // numEdges++;
        // }
    }
}
