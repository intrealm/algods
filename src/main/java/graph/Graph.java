package src.main.java.graph;

import java.util.List;

public interface Graph {

    enum GraphType
    {
        DIRECTED,
        UNDIRECTED
    }

    void addEdge(int source,int destination);

    int getIndegreeOf(int index);

    List<Integer> getAdjacentVertices(int v);

    int getNumberOfVertices();
}
