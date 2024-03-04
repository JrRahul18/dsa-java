package Graphs.Concepts;

import java.util.*;

//GRAPH IMPLEMENTED USING HASHMAP
public class C1_intialisation {
    public static void main(String[] args) {
        int[][] edges = { { 2, 4 }, { 0, 1 }, { 0, 2 }, { 4, 6 }, { 5, 6 }, { 5, 3 } };
        HashMap<Integer, List<Integer>> graph = new HashMap<>();
        for (int[] edge : edges) {
            if (!graph.containsKey(edge[0])) {
                graph.put(edge[0], new ArrayList<>());
            }
            if (!graph.containsKey(edge[1])) {
                graph.put(edge[1], new ArrayList<>());
            }
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);

        }
        System.out.println(graph);

    }

}
