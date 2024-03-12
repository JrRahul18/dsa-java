package Graphs.Concepts;

import java.util.*;
//BFS Traversal in graph 
//Connected edges are stored in adjacentEdges.

//Time Complexity: O(V) + O(E);

public class C03_BFS {
    public static void BFS(int edge, HashMap<Integer, List<Integer>> graph, List<Integer> result, boolean[] checkVisited){
        Queue<Integer> q = new LinkedList<>();
        q.add(edge);
        checkVisited[edge] = true;
        result.add(edge);
        while(!q.isEmpty()){
    
            int u = q.peek();
            q.poll();
            for(int v: graph.get(u)){
                if(!checkVisited[v]){
                    checkVisited[v] = true;
                    q.add(v);
                    result.add(v);
                }
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
        BFS(0, graph, result, checkVisited);
        System.out.println(result);
    }
}
