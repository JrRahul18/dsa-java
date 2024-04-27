package Graphs.Concepts;

import java.util.*;
//Detect Cycle in undirected graph
//By both BFS and DFS traversals.

//Time Complexity: O(V) + O(E);

public class C04_CycleInUndirectedGraph {
    static class Pair{
        int node;
        int parent;
        Pair(int node, int parent){
            this.node = node;
            this.parent = parent;
        }
    }
    
    public static boolean DFSTraversal(int u, int parent, HashMap<Integer, List<Integer>> graph, boolean[]checkVisited){
        checkVisited[u] = true;
        for(int nbr: graph.get(u)){
            if(nbr == parent) continue;
            if(checkVisited[nbr] == true){
                return false;
            }
            if (DFSTraversal(nbr, u, graph, checkVisited) == false) return false;
        }
        return true;
        
    }

    public static boolean BFSTraversal(int u,HashMap<Integer, List<Integer>> graph, boolean[]checkVisited){
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(u, -1));
        checkVisited[u] = true;
        while(!q.isEmpty()){
            Pair temp = q.peek();
            q.poll();
            for(int nbr: graph.get(temp.node)){
                if(checkVisited[nbr] ==false){
                    checkVisited[nbr] = true;
                    q.add(new Pair(nbr, temp.node));
                }
                else if(nbr != temp.parent){
                    return false;
                }
            }
        }
        return true;
    }
    
    public static void main(String[] args) {
        int v = 5;
        ArrayList<ArrayList<Integer>> adjacentEdges  = new ArrayList<>();
        for(int i= 0; i<v; i++){
            adjacentEdges.add(new ArrayList<>());
        }
        adjacentEdges.get(0).add(1);
        adjacentEdges.get(1).add(0);
        adjacentEdges.get(1).add(2);
        adjacentEdges.get(1).add(4);
        adjacentEdges.get(2).add(1);
        adjacentEdges.get(2).add(3);
        adjacentEdges.get(3).add(2);
        adjacentEdges.get(3).add(4);
        adjacentEdges.get(4).add(1);
        adjacentEdges.get(4).add(3);

        System.out.println(adjacentEdges);

        HashMap<Integer, List<Integer>> graph = new HashMap<>();
        for(int i=0; i<v; i++){
            ArrayList<Integer> temp = adjacentEdges.get(i);
            graph.put(i, temp);
        }
        boolean[]checkVisited = new boolean[v];
        boolean isCycle = true;

        //DFS
        // for(int i=0; i<v; i++){
        //     if(checkVisited[i] == false && DFSTraversal(i, -1, graph, checkVisited) == false){
        //         System.out.println("Graph contains cycle");
        //         isCycle = false;
        //         break;
        //     }
        // }
        // if(isCycle == true){
        //     System.out.println("Graph does not contain cycle");
        // }

        //BFS

        for(int i=0; i<v; i++){
            if(checkVisited[i] == false && BFSTraversal(i, graph, checkVisited) == false){
                System.out.println("Graph contains cycle");
                isCycle = false;
                break;
            }
        }
        if(isCycle == true){
            System.out.println("Graph does not contain cycle");
        }
        

    }
}
