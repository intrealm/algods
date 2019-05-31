package src.main.java.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class AdjacencySetGraph implements Graph {

    private List<AdjcnySetNode> verticesList = new ArrayList<>();

    private GraphType graphType = GraphType.UNDIRECTED;

    private int numberOfVertices=0;

    public AdjacencySetGraph(int numberOfVertices,GraphType gt)
    {
        this.numberOfVertices=numberOfVertices;
        for(int i=0;i<numberOfVertices;i++)
        {
            //this.verticesList.add(i);
        }
        this.graphType=gt;
    }


    @Override
    public void addEdge(int source, int destination) {
        //check bounds
        AdjcnySetNode node = this.verticesList.get(source);
        node.addEdge(destination);
        if(this.graphType.equals(GraphType.UNDIRECTED))
            this.verticesList.get(destination).addEdge(source);

    }

    @Override
    public List<Integer> getAdjacentVertices(int v) {
        //boundary checks
        return this.verticesList.get(v).
                getAdjacentVertices();
    }

    @Override
    public int getIndegreeOf(int index) {
        return 0;
    }

    @Override
    public int getNumberOfVertices() {
        return 0;
    }
}
