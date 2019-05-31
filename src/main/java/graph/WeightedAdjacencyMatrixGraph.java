package src.main.java.graph;

import java.util.*;

public class WeightedAdjacencyMatrixGraph implements WeightedGraph {

    //A---2---->B
    //|         |
    //|         3
    //1         |
    //|         |
    //C---5---->E

    int matrix[][];
    //  A B C D E
    //A 0 1 1 0 0
    //B 0 0 0 0 1
    //C 0 0 0 0 1
    //D 0 0 0 0 0
    //E 0 0 0 0 0

    private GraphType graphType = GraphType.DIRECTED;
    private int numberOfVertices = 0;


    public WeightedAdjacencyMatrixGraph(int numberOfVertices, GraphType gt)
    {
        this.numberOfVertices =numberOfVertices;
        this.graphType =gt;
        this.matrix = new int[numberOfVertices][numberOfVertices];
        for(int i=0;i<numberOfVertices;i++)
            for(int j=0;j<numberOfVertices;j++)
                matrix[i][j]=Integer.MIN_VALUE;
    }
    @Override
    //since talking about directed graph
    public void addEdge(int source, int destination,int weight) {

        if(source>=0 && source<this.numberOfVertices && destination>=0 && destination<this.numberOfVertices)
            this.addEdge(source, destination,this.graphType,weight);
        else
            throw new IllegalArgumentException();
    }

    protected void addEdge(int source, int destination,GraphType gt,int weight) {
        matrix[source][destination]=weight;
        if(gt.equals(GraphType.UNDIRECTED))
            matrix[destination][source]=weight;
    }

    @Override
    public List<Integer> getAdjacentVertices(int source) {
        if(source<0 && source>=this.numberOfVertices)
        {
            throw new IllegalArgumentException();
        }
        int arr[] = matrix[source];
        List<Integer> list = new ArrayList<>();
        for(int i=0;i<this.numberOfVertices;i++)
            if(arr[i]>0)
                list.add(i);
        Collections.sort(list);//not necessarily done, just  cleaner
        return list;
    }

    @Override
    public int getIndegreeOf(int index) {
        if(index<0 || index>this.numberOfVertices)
            throw new IllegalArgumentException();
        int indegree=0;
        for(int i=0;i<this.numberOfVertices;i++)
        {
            if(this.matrix[i][index]>0)
                indegree++;
        }
        return indegree;
    }


    @Override
    public int getNumberOfVertices() {
        return this.numberOfVertices;
    }

    public int getWeighetedEdgeValue(int source,int adjacentNeigh)
    {
        return this.matrix[source][adjacentNeigh];
    }
}
