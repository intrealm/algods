package src.main.java.graph;

import java.util.*;

public class ShortestPathFromSourceToDestination {


    public static List<Integer> shortestPathFromStoD(Graph g,Integer source, Integer destination)
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

    public static Map<Integer,DistanceInfo> buldDistanceTable(Graph g,Integer source, Integer destination)
    {

        //Initialize distanceinfo table
        Map<Integer,DistanceInfo> distanceTable = new HashMap<>();
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
            for(Integer i: g.getAdjacentVertices(currVertex))
            {
                int distance = distanceTable.get(i).getDistance();
                if(distance==-1)
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
        return distanceTable;
    }
}
class DistanceInfo implements Comparable<DistanceInfo>
{
    private int distance=-1;
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


    @Override
    public int compareTo(DistanceInfo o) {
        return this.distance<o.distance?
            -1:(this.distance>o.distance?1:0);
    }
}
