package src.main.java.graph;

import java.util.*;
import java.util.stream.Collectors;

public class WeightedShortestPathFromSourceToDestination {


    public static List<Integer> shortestPathFromStoD(WeightedGraph g,Integer source, Integer destination)
    {
        //prepareDistanceTable

        //find the shortedpath from source to destination in reverse
        Map<Integer,DistanceInfo> distanceTable = buldDistanceTable(g,source,destination);

        Stack<Integer> shortestPath = new Stack<>();

        int currNode=destination;
        DistanceInfo shortestDistanceInfo = distanceTable.get(destination);
        shortestPath.push(destination);
        while(shortestDistanceInfo!=null && shortestDistanceInfo.getLastVertex() !=source)
        {
            shortestPath.push(shortestDistanceInfo.getLastVertex());
            shortestDistanceInfo = distanceTable.get(shortestDistanceInfo.getLastVertex());
        }

        shortestPath.push(source);
        if(distanceTable.get(destination).getDistance()==shortestPath.size()-1) {
            return shortestPath.stream().collect(ArrayList::new,ArrayList::add, ArrayList::addAll);
        }
            return Collections.EMPTY_LIST;
    }

    public static Map<Integer,DistanceInfo> buldDistanceTable(WeightedGraph g,Integer source, Integer destination)
    {
        Map<Integer,DistanceInfo> distanceTable = new HashMap<>();
        PriorityQueue<Vertex> queue = new PriorityQueue<>(
                (v1,v2)->
                        Integer.valueOf(v1.getDistance()).compareTo(Integer.valueOf(v2.getDistance()))
        );

        Map<Integer,Vertex> verticesMap = new HashMap<>();

        for(int i=0;i<g.getNumberOfVertices();i++)
        {
            distanceTable.put(i,new DistanceInfo());
        }
        distanceTable.get(source).setLastVertex(source);
        distanceTable.get(source).setDistance(0);

        Vertex sourceVertex = new Vertex(source,0);
        queue.add(sourceVertex);
        verticesMap.put(source,sourceVertex);

        while(!queue.isEmpty())
        {
            Vertex currentVertexInfo = queue.poll();
            int currentVertex = currentVertexInfo.getVertexId();

            for(Integer adjacentVertices : g.getAdjacentVertices(currentVertex))
            {
                int distance = distanceTable.get(currentVertex).getDistance()
                        +g.getWeighetedEdgeValue(currentVertex,adjacentVertices);
                if(distanceTable.get(adjacentVertices).getDistance()>
                distance)
                {
                    distanceTable.get(adjacentVertices).setLastVertex(currentVertex);
                    distanceTable.get(adjacentVertices).setLastVertex(distance);

                    Vertex neighbourInfo = verticesMap.get(adjacentVertices);
                    if(neighbourInfo!=null)
                        queue.remove(neighbourInfo);

                    neighbourInfo = new Vertex(adjacentVertices,distance);
                    queue.add(neighbourInfo);
                    verticesMap.put(adjacentVertices,neighbourInfo);


                }
            }
        }
        /*

        //Initialize distanceinfo table

        for(int i=0;i<g.getNumberOfVertices();i++)
        {
                distanceTable.put(i,new DistanceInfo());
        }

        distanceTable.get(source).setDistance(0);
        distanceTable.get(source).setLastVertex(source);

        Queue<Integer> queue = new LinkedList<>();
        queue.add(source);
        while(!queue.isEmpty())
        {
            Integer currVertex= queue.remove();

            for(Integer i: g.getAdjacentVertices(currVertex).stream().
                    sorted((x,y)->{
                        DistanceInfo distanceInfo1 = distanceTable.get(x);
                        DistanceInfo distanceInfo2 = distanceTable.get(y);
                        return Integer.valueOf(distanceInfo1.getDistance()).compareTo(Integer.valueOf(distanceInfo2.getDistance()));}).
                    collect(Collectors.toList()))
            {
                int distance = distanceTable.get(i).getDistance();
                if(distance<distanceTable.get(currVertex).getDistance())
                {
                    //so smart
                    int currentDistance = distanceTable.get(currVertex).getDistance()+1;
                    distanceTable.get(i).setDistance(currentDistance);
                    distanceTable.get(i).setLastVertex(currVertex);

                    if(!g.getAdjacentVertices(i).isEmpty())
                    {
                        queue.add(i);
                    }
                }

            }
        }
        */


        return distanceTable;
    }


    static class DistanceInfo// implements Comparable<DistanceInfo>
    {
        private int distance=Integer.MAX_VALUE;
        private int lastVertex=-1;

        public int getDistance() {
            return distance;
        }

        public void setDistance(int distance) {
            this.distance = distance;
        }

        public int getLastVertex() {
            return lastVertex;
        }

        public void setLastVertex(int lastVertex) {
            this.lastVertex = lastVertex;
        }


    }

    static class Vertex
    {
        private int vertexId;
        private int distance;

        public Vertex(int vertexId, int distance) {
            this.vertexId = vertexId;
            this.distance = distance;
        }

        public int getVertexId() {

            return vertexId;
        }

        public void setVertexId(int vertexId) {
            this.vertexId = vertexId;
        }

        public int getDistance() {
            return distance;
        }

        public void setDistance(int distance) {
            this.distance = distance;
        }
    }
}


