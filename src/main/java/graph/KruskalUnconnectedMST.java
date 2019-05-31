package src.main.java.graph;

import sun.awt.image.ImageWatched;

import java.util.*;

public class KruskalUnconnectedMST {


    public static void printMinimumSpanningTree(WeightedAdjacencyMatrixGraph graph)
    {
        PriorityQueue<EdgeInfo> queue =
                new PriorityQueue<EdgeInfo>((edge1,edge2)->
                edge1.getWeight().compareTo(edge2.getWeight()));

        for(int i = 0;i<graph.getNumberOfVertices();i++)
        {
            queue.addAll(graph.getAdjacentVertices(i).stream().map(
                    adjacent->new EdgeInfo(i,adjacent,graph.getWeighetedEdgeValue(i,adjacent))
            ));
        }

        Map<Integer,Set<Integer>> edgeMap = new HashMap<>()]
        for(int i = 0;i<graph.getNumberOfVertices();i++)
            edgeMap.put(i,new HashSet<>());
//not to add whats already added

        Set<EdgeInfo> minimumSpanningTree = new HashSet<>();
        Set<Integer> visitedEdgewe  = new HashSet<>();
        while(!queue.isEmpty()&&minimumSpanningTree.size()<graph.getNumberOfVertices()-1) {
            EdgeInfo currentEdge = queue.poll();

            edgeMap.get(currentEdge.getV1())
                    .add(currentEdge.getV2());
            //if  has cycle
            if (hasCycle(edgeMap)) {
                edgeMap.get(currentEdge.getV1()).remove(currentEdge.getV2());
                continue;
            }

            minimumSpanningTree.add(currentEdge);

            visitedEdgewe.add(currentEdge.getV1());
            visitedEdgewe.add(currentEdge.getV2());
        }

        if(visitedEdgewe.size()!=graph.getNumberOfVertices())
        {
            System.out.println("not present");
        }//error
         else
        {
            minimumSpanningTree.forEach(System.out::println
            );
        }

        }

    public static boolean hasCycle(Map<Integer,Set<Integer> > edgeMap)
    {
        for(Integer i : edgeMap.keySet())
        {
            LinkedList<Integer> queue  = new LinkedList<>();
            queue.add(i);
            Set<Integer> visitedVertices = new HashSet<>();
            while(!queue.isEmpty())
            {
                int currVertex = queue.pollFirst();
                if(visitedVertices.contains(currVertex))
                    return true;

                visitedVertices.add(currVertex);
                queue.addAll(edgeMap.get(currVertex));

            }
        }
        return false;
    }


    public static class EdgeInfo
    {
        private Integer v1;
        private Integer v2;
        private Integer weight;

        public EdgeInfo(Integer v1, Integer v2, Integer weight) {
            this.v1 = v1;
            this.v2 = v2;
            this.weight = weight;
        }

        public Integer getV1() {
            return v1;
        }

        public void setV1(Integer v1) {
            this.v1 = v1;
        }

        public Integer getV2() {
            return v2;
        }

        public void setV2(Integer v2) {
            this.v2 = v2;
        }

        public Integer getWeight() {
            return weight;
        }

        public void setWeight(Integer weight) {
            this.weight = weight;
        }

        public String toString()
        {
            return ""+this.v1+" -> "+this.v2+"="+this.getWeight();
        }
    }
}
