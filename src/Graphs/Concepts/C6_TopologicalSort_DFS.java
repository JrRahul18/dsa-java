package Graphs.Concepts;

import java.util.*;

//Topological Sort using DFS

public class C6_TopologicalSort_DFS {
    public static void DFSTraversal(int u, HashMap<Integer, List<Integer>> graph, boolean[]checkVisited, Stack<Integer> stk){
        checkVisited[u] = true;
        for(int nbr: graph.get(u)){
            if(checkVisited[nbr] == false){
                DFSTraversal(nbr, graph, checkVisited, stk);
            }
        }
        stk.push(u);
    }
    public static void main(String[] args) {
        int v = 6;
        ArrayList<ArrayList<Integer>> adjacentEdges  = new ArrayList<>();
        for(int i= 0; i<v; i++){
            adjacentEdges.add(new ArrayList<>());
        }
        adjacentEdges.get(0).add(2);
        adjacentEdges.get(0).add(3);
        adjacentEdges.get(1).add(4);
        adjacentEdges.get(2).add(1);
        adjacentEdges.get(2).add(3);
        adjacentEdges.get(3).add(1);
        adjacentEdges.get(5).add(1);
        adjacentEdges.get(5).add(4);

        // v=4;
        // adjacentEdges.get(1).add(0);
        // adjacentEdges.get(2).add(0);
        // adjacentEdges.get(3).add(0);


        System.out.println(adjacentEdges);

        HashMap<Integer, List<Integer>> graph = new HashMap<>();
        for(int i=0; i<v; i++){
            ArrayList<Integer> temp = adjacentEdges.get(i);
            graph.put(i, temp);
        }
        Stack<Integer> stk = new Stack<>();
        boolean[] checkVisited = new boolean[v];
        for(int i =0; i<v; i++){
            if(!checkVisited[i]){
                DFSTraversal(i, graph, checkVisited, stk);
            }
        }

        List<Integer> sortedGraph = new ArrayList<>();
        while(!stk.isEmpty()){
            int u = stk.peek();
            stk.pop();

            sortedGraph.add(u);

        }
        System.out.println(sortedGraph);

    }
}
