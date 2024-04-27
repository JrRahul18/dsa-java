package Graphs.Concepts;

public class C10_DSU_Rank_PathCompression {
    //optimised find() by path compression; node will store the topmost parent instead of making chain.
    //optimised union() by storing rank; minimize the size of the tree as union of two nodes will be done with node having higher rank as parent
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
    public static void main(String[] args) {
        int v = 5;
        int[] parent = new int[v];
        for(int i=0; i<parent.length; i++){
            parent[i] = i;
        }
        int[] rank = new int[v];

        union(0, 3, parent, rank);
    }
}
