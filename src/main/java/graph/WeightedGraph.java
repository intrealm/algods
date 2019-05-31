package src.main.java.graph;

import java.util.List;

public interface WeightedGraph {

    enum GraphType
    {
        DIRECTED,
        UNDIRECTED
    }

    void addEdge(int source, int destination,int weight);

    int getIndegreeOf(int index);

    List<Integer> getAdjacentVertices(int v);

    int getNumberOfVertices();

    public int getWeighetedEdgeValue(int source,int adjacentNeigh);
}
