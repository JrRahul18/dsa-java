package Graphs.Concepts;

public class C09_DSU_Initialisation {
    //DSU initialised with find and union
    //Initially, every node is a parent of itself.
    //find() helps to find the parent of a given node.
    //union() helps to combine trees of the given two nodes and make any one node among the two as parent.
    public static int find(int i, int[] parent){
        if(i == parent[i]) return i;

        return find(parent[i], parent);
    }

    public static void union(int i, int j, int[] parent){
        int parent_i = find(i, parent);
        int parent_j = find(j, parent);
        if(parent_i != parent_j){
            parent[parent_i] = parent_j;
        }

    }
    public static void main(String[] args) {
        int v = 7;
        int[] parent = new int[v];
        for(int i=0; i<v; i++){
            parent[i] = i;
        }

    }
    
}
