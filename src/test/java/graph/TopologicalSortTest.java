package src.test.java.graph;

import org.junit.Assert;
import org.junit.Test;
import src.main.java.graph.AdjacencyMatrixGraph;
import src.main.java.graph.Graph;
import src.main.java.graph.ShortestPathFromSourceToDestination;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.stream.Collectors;

public class TopologicalSortTest {

    @Test
    public void find_minimumdistance() {

        AdjacencyMatrixGraph graph = new AdjacencyMatrixGraph(5, Graph.GraphType.DIRECTED);
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(2, 3);
        graph.addEdge(3, 1);
        graph.addEdge(1, 4);

        System.out.println(ShortestPathFromSourceToDestination.shortestPathFromStoD(graph,0,4));
    }

    @Test
    public void test_topological_Sort()
    {

        AdjacencyMatrixGraph graph = new AdjacencyMatrixGraph(5, Graph.GraphType.DIRECTED);
        graph.addEdge(0,1);
        graph.addEdge(0,2);
        graph.addEdge(2,3);
        graph.addEdge(3,1);
        graph.addEdge(1,4);

        Queue<Integer> arr = new LinkedList();
        arr.add(0);
        arr.add(2);
        arr.add(3);
        arr.add(1);
        arr.add(4);
        graph.topologicalSort().forEach(x->Assert.assertEquals(arr.remove(),x));

        arr.add(0);
        arr.add(2);
        arr.add(3);
        arr.add(1);
        arr.add(4);
        graph.topoSort_Tutorials().forEach(x->Assert.assertEquals(arr.remove(),x))
                ;
    }

    @Test(expected = RuntimeException.class)
    public void test_topological_Sort_disjoineted()
    {

        AdjacencyMatrixGraph graph = new AdjacencyMatrixGraph(5, Graph.GraphType.DIRECTED);
        graph.addEdge(0,1);
        graph.addEdge(0,2);
        graph.addEdge(2,3);
        graph.addEdge(3,1);

       // graph.topologicalSort();
        graph.topoSort_Tutorials();

    }
    @Test(expected = RuntimeException.class)
    public void test_topological_Sort_cyclic()
    {

        AdjacencyMatrixGraph graph = new AdjacencyMatrixGraph(5, Graph.GraphType.DIRECTED);
        graph.addEdge(0,1);
        graph.addEdge(0,2);
        graph.addEdge(2,3);
        graph.addEdge(3,1);
        graph.addEdge(1,4);
        graph.addEdge(4,1);

   //     graph.topologicalSort();
        graph.topoSort_Tutorials();

    }
}
