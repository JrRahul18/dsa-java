package Graphs.Concepts;

import java.util.*;
//DFS Traversal in graph 
//Connected edges are stored in adjacentEdges.

//Time Complexity: O(V) + O(E);
public class C02_DFS {
    public static void DFS(int edge, HashMap<Integer, List<Integer>> graph, List<Integer> result, boolean[] checkVisited){
        if(checkVisited[edge] == true){
            return;
        }
        checkVisited[edge] = true;
        result.add(edge);
        for(int v: graph.get(edge)){
            if(!checkVisited[v]){
                DFS(v, graph, result, checkVisited);
            }
        }
    }
    public static void main(String[] args) {
        int v = 5;
        ArrayList<ArrayList<Integer>> adjacentEdges  = new ArrayList<>();
        for(int i= 0; i<v; i++){
            adjacentEdges.add(new ArrayList<>());
        }
        adjacentEdges.get(0).add(2);
        adjacentEdges.get(0).add(3);
        adjacentEdges.get(0).add(1);
        adjacentEdges.get(1).add(0);
        adjacentEdges.get(2).add(0);
        adjacentEdges.get(2).add(4);
        adjacentEdges.get(3).add(0);
        adjacentEdges.get(4).add(2);
        System.out.println(adjacentEdges);

        HashMap<Integer, List<Integer>> graph = new HashMap<>();
        for(int i=0; i<v; i++){
            ArrayList<Integer> temp = adjacentEdges.get(i);
            graph.put(i, temp);
        }
        List<Integer> result = new ArrayList<>();
        boolean[]checkVisited = new boolean[v];
        DFS(0, graph, result, checkVisited);
        System.out.println(result);
    }
}
