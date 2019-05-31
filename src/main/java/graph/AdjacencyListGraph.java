package src.main.java.graph;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;


//TODO
public class AdjacencyListGraph implements Graph {

    int val;

    private LinkedList<AdjacencyListGraph> adjacentNodes;

    @Override
    public void addEdge(int source, int destination) {


    }

    @Override
    public List<Integer> getAdjacentVertices(int v) {
        return null;
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
