package src.main.java.graph;

import org.omg.SendingContext.RunTimeOperations;

import java.util.*;

public class AdjacencyMatrixGraph implements Graph {

    //A-------->B
    //|         |
    //|         |
    //|         |
    //|         |
    //C-------->E

    int matrix[][];
    //  A B C D E
    //A 0 1 1 0 0
    //B 0 0 0 0 1
    //C 0 0 0 0 1
    //D 0 0 0 0 0
    //E 0 0 0 0 0

    private GraphType graphType = GraphType.DIRECTED;
    private int numberOfVertices = 0;


    public AdjacencyMatrixGraph(int numberOfVertices,GraphType gt)
    {
        this.numberOfVertices =numberOfVertices;
        this.graphType =gt;
        this.matrix = new int[numberOfVertices][numberOfVertices];
        for(int i=0;i<numberOfVertices;i++)
            for(int j=0;j<numberOfVertices;j++)
                matrix[i][j]=0;
    }
    @Override
    //since talking about directed graph
    public void addEdge(int source, int destination) {

        if(source>=0 && source<this.numberOfVertices && destination>=0 && destination<this.numberOfVertices)
            this.addEdge(source, destination,this.graphType);
        else
            throw new IllegalArgumentException();
    }

    protected void addEdge(int source, int destination,GraphType gt) {
        matrix[source][destination]=1;
        if(gt.equals(GraphType.UNDIRECTED))
            matrix[destination][source]=1;
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
            if(arr[i]==1)
                list.add(i);
        Collections.sort(list);//not necessarily done, just  cleaner
        return list;
    }

    public static int getVertexIndexForIndegreeZero(int matric[][],int skipVertices[])
    {
        int vIndex = -1;
        for(int i=0;i<matric.length;i++)
        {
            if(skipVertices[i]!=1)
            {
                int currCount=0;
                for(int j=0;j<matric.length;j++)
                {
                    if(skipVertices[j]!=1 && matric[j][i]==1)
                    {
                        currCount++;
                    }
                }
                if(currCount==0)
                {
                    if(vIndex!=-1)
                        throw new RuntimeException();
                    vIndex=i;
                }
            }
        }
        if(vIndex==-1)
            throw new RuntimeException();
        return vIndex;
    }

    public List<Integer> topologicalSort()
    {
        int[] visitedVertices = new int [this.numberOfVertices];
        for(int i=0;i<visitedVertices.length;i++)
            visitedVertices[i]=0;

        List<Integer> lst = new ArrayList<>();

        int curr = getVertexIndexForIndegreeZero(this.matrix,visitedVertices);
        lst.add(curr);

        //find vertex with indegree 0
        //add it to the list
        for(int i=1;i<visitedVertices.length;i++)
        {
            visitedVertices[curr] =1;
            curr = getVertexIndexForIndegreeZero(this.matrix,visitedVertices);
            lst.add(curr);
        }

        //calculate updated indgrees of the next adjacent vertices
        return lst;
    }

    @Override
    public int getIndegreeOf(int index) {
        if(index<0 || index>this.numberOfVertices)
            throw new IllegalArgumentException();
        int indegree=0;
        for(int i=0;i<this.numberOfVertices;i++)
        {
            if(this.matrix[i][index]==1)
                indegree++;
        }
        return indegree;
    }
  /* not valid for mattrix public int getIndegreeOf(int index) {
        if(index<0 || index>this.numberOfVertices)
            throw new IllegalArgumentException();
        int indegree=0;
        for(int i=0;i<this.numberOfVertices;i++)
        {

            if(this.getAdjacentVertices(i).contains(index))
                indegree++;
        }
        return indegree;
    }*/



    public List<Integer> topoSort_Tutorials()
    {
        List<Integer> sortedList = new ArrayList<>();
        Map<Integer,Integer> map = new HashMap<>();
        Queue<Integer> vertexQueue = new LinkedList<>();
        for(int i =0 ; i<this.matrix.length;i++)
        {
            int initialiInDegree = this.getIndegreeOf(i);
            map.put(i,initialiInDegree);
            if(initialiInDegree==0)
            {
                vertexQueue.add(i);
            }
        }

        while(!vertexQueue.isEmpty())
        {
            Integer currentVertex = vertexQueue.remove();
            sortedList.add(currentVertex);

            //updateIndegrees
            for(int i=0;i<this.matrix.length;i++)
            {
                if(this.getAdjacentVertices(currentVertex).contains(i))
                {
                    int updatedInDegree =map.get(i)-1;
                    map.put(i,updatedInDegree);
                    if(updatedInDegree==0)
                        vertexQueue.add(i);
                }
            }
        }

        if(sortedList.size()!=this.matrix.length)
            throw new RuntimeException();

        return sortedList;
    }

    @Override
    public int getNumberOfVertices() {
        return this.numberOfVertices;
    }
}
