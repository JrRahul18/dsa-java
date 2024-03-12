package Graphs.Concepts;

import java.util.*;
//Topological Sort using Kahn Algorithm (BFS Traversal);
//inDegree is used to store the number of incoming edge in a node;

public class C07_TopologicalSort_KahnAlgorithm {
    public static void BFSTraversal( HashMap<Integer, List<Integer>> graph, int[]inDegree, List<Integer> finalAns){
        Queue<Integer> queue= new LinkedList<>();
        for(int i=0; i<inDegree.length; i++){
            if(inDegree[i]==0){
                queue.add(i);
            }
        }
        while (!queue.isEmpty()) {
            int u = queue.peek();
            queue.poll();
            for(int nbr: graph.get(u)){
                inDegree[nbr]--;
                if(inDegree[nbr] == 0){
                    queue.add(nbr);
                }
            }
            finalAns.add(u);
        }

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
        int[] inDegree = new int[v];
        for(int i=0; i<v; i++){
            for(int nbr: graph.get(i)){
                inDegree[nbr]++;
            }
        }
        List<Integer> finalAns = new ArrayList<>();
        BFSTraversal(graph, inDegree, finalAns);
        System.out.println(finalAns);
    }
}
