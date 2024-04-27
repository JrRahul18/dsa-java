package Graphs.Concepts;
import java.util.*;

public class C11_CycleDSU {
    //Detect cycle using DSU
    public static int find(int i, int[] parent){
        if(parent[i] == i) return i;
        return parent[i] = find(parent[i], parent);
    }
    public static void union(int i, int j, int[] parent, int[]rank){
        int parent_i = find(i, parent);
        int parent_j = find(j, parent);
        if(parent_i == parent_j) return;

        if(rank[parent_i] > rank[parent_j]){
            parent[parent_j] = parent_i;
        }
        else if(rank[parent_j] > rank[parent_i]){
            parent[parent_i] = parent_j;
        }
        else{
            parent[parent_i] = parent_j;
            rank[parent_j]++;
        }

    }

    public static boolean DSU(int v, HashMap<Integer, List<Integer>> graph, int[]parent, int[]rank){
        for(int u=0; u<v; u++){
            for(int nbr: graph.get(u)){
                if(u<nbr){
                    int parent_u = find(u, parent);
                    int parent_nbr = find(nbr, parent);
                    if(parent_u == parent_nbr) return false;
                    union(u, nbr, parent, rank);
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

        int[] parent = new int[v];
        for(int i=0; i<parent.length; i++){
            parent[i] = i;
        }
        int[]rank = new int[v];
        boolean isCycle = false;

        if(DSU(v, graph, parent, rank) == false){
            isCycle = true;
            System.out.println("Graph contains Cycle");
        }
        if(isCycle == false){
            System.out.println("Graph does not contains cycle");
        }

    }
}
