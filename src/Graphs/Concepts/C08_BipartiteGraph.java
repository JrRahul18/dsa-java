package Graphs.Concepts;

import java.util.*;

public class C08_BipartiteGraph {
    //Check if gaph is Bipartite
    //Graph is bipartite if nodes can be divided into two sets such that no two adjacent nodes belongs to same set
    public static boolean DFSTraversal(int u, int currentSet, HashMap<Integer, List<Integer>> hmap, int []checkVisited){
        checkVisited[u] = currentSet;
        for(int nbr: hmap.get(u)){
            if(checkVisited[nbr] == currentSet) return false;
            if(checkVisited[nbr] == -1){
                int nextSet = 1-currentSet;
                if(DFSTraversal(nbr, nextSet, hmap, checkVisited)==false) return false;
            }
        }
        return true;
    }
    public static boolean BFSTraversal(int u, int currentSet, HashMap<Integer, List<Integer>> hmap, int[] checkVisited){
        Queue<Integer> q = new LinkedList<>();
        q.add(u);
        checkVisited[u] = currentSet;
        while(!q.isEmpty()){
            int temp = q.peek();
            q.poll();
            for(int nbr: hmap.get(temp)){
                if(checkVisited[nbr] == checkVisited[temp]) return false;
                if(checkVisited[nbr] == -1){
                    checkVisited[nbr] = 1 - checkVisited[temp];
                    q.add(nbr);
                }
            }
        }
        
        return true;
    }
    public static void main(String[] args) {
        int v = 4;
        ArrayList<ArrayList<Integer>> adjacentEdges  = new ArrayList<>();
        for(int i= 0; i<v; i++){
            adjacentEdges.add(new ArrayList<>());
        }
        adjacentEdges.get(0).add(1);
        // adjacentEdges.get(0).add(2);
        adjacentEdges.get(0).add(3);
        adjacentEdges.get(1).add(0);
        adjacentEdges.get(1).add(2);
        // adjacentEdges.get(2).add(0);
        adjacentEdges.get(2).add(1);
        adjacentEdges.get(2).add(3);
        adjacentEdges.get(3).add(0);
        adjacentEdges.get(3).add(2);

        System.out.println(adjacentEdges);

        HashMap<Integer, List<Integer>> graph = new HashMap<>();
        for(int i=0; i<v; i++){
            ArrayList<Integer> temp = adjacentEdges.get(i);
            graph.put(i, temp);
        }

        // int[] checkVisited = new int[v];
        // Arrays.fill(checkVisited, -1);
        // boolean isBipartite = false;
        // for(int i=0; i<v; i++){
        //     if(checkVisited[i] == -1 && DFSTraversal(i, 1, graph, checkVisited) == false){
        //         System.out.println("Graph is not Bipartite");
        //         isBipartite = true;
        //         break;
        //     }
        // }
        // if(isBipartite == false){
        //     System.out.println("Graph is Bipartite");
        // }

        int[] checkVisited = new int[v];
        Arrays.fill(checkVisited, -1);
        boolean isBipartite = false;
        for(int i=0; i<v; i++){
            if(checkVisited[i] == -1 && BFSTraversal(i, 1, graph, checkVisited) == false){
                isBipartite = true;
                System.out.println("Graph is not Bipartite");
                break;
            }
        }
        if(isBipartite == false){
            System.out.println("Graph is Bipartite");
        }
    }
    
}
