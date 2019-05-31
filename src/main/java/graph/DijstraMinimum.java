package src.main.java.graph;

import src.main.java.queue.Queue;

import java.util.Map;
import java.util.PriorityQueue;

public class DijstraMinimum {


    public static void printShortestPath()
    {
        PriorityQueue<VertexInfo> queue = new PriorityQueue<>(
                //compartor
        );



    }


    private static class DistanceInfo
    {
         int val= Integer.MAX_VALUE;

        int lastVertex = -1;

    }

    private static class VertexInfo
    {
        int vertexId;
        int distance;

        public VertexInfo(int vertexId, int distance) {
            this.vertexId = vertexId;
            this.distance = distance;
        }
    }


}
