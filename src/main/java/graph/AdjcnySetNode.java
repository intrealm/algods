package src.main.java.graph;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class AdjcnySetNode {

    private int vertexNumber;

    private Set<Integer> adjacentSet = new HashSet<>();


    public AdjcnySetNode(int vertexNumber)
    {
        this.vertexNumber=vertexNumber;
    }

    public int getVertexNumber() {
        return vertexNumber;
    }
    public void addEdge(int vertexNumber)
    {
        this.adjacentSet.add(vertexNumber);
    }

    public List<Integer> getAdjacentVertices() {
        return adjacentSet.stream().sorted().collect(Collectors.toList());
    }

}
