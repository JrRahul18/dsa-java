package Graphs.Concepts;
import java.util.*;

public class C13_ShortestPath_Weighted_Undirected {
    //Shortest path from vertex 1 to vertex N;
    static class Pair{
        int node;
        int weight;
        Pair(int node, int weight){
            this.node = node;
            this.weight = weight;
        }
    }

    public static void main(String[] args) {
        int n = 5;
        int m = 6;
        int[][] edges = new int[m][3];
        edges[0][0]=1; edges[0][1] = 2; edges[0][2] = 2;
        edges[1][0]=2; edges[1][1] = 5; edges[1][2] = 5;
        edges[2][0]=2; edges[2][1] = 3; edges[2][2] = 4;
        edges[3][0]=1; edges[3][1] = 4; edges[3][2] = 1;
        edges[4][0]=4; edges[4][1] = 3; edges[4][2] = 3;
        edges[5][0]=3; edges[5][1] = 5; edges[5][2] = 1;

        
        HashMap<Integer, List<Pair>> graph = new HashMap<>();
        for(int i=0; i<=n; i++){
            graph.put(i, new ArrayList<>());
        }
        for(int [] edge: edges){
            graph.get(edge[0]).add(new Pair(edge[1], edge[2]));
            graph.get(edge[1]).add(new Pair(edge[0], edge[2]));
        }

        int[]parent = new int[n+1];
        for(int i=0; i<parent.length; i++){
            parent[i] = i;
        }

        int[] destination = new int[n+1];
        Arrays.fill(destination, Integer.MAX_VALUE);
        
        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b)-> a.weight - b.weight);
        pq.add(new Pair(1, 0));
        destination[1]=0;

        while(!pq.isEmpty()){
            int size = pq.size();
            for(int i=0; i<size; i++){
                Pair temp = pq.peek();
                pq.poll();
                int node = temp.node;
                int d = temp.weight;
                for(Pair nbr: graph.get(node)){
                    if(nbr.weight + d < destination[nbr.node]){
                        destination[nbr.node] = nbr.weight + d;
                        pq.add(new Pair(nbr.node, nbr.weight + d));
                        parent[nbr.node] = node;
                    }
                }
            }
            System.out.println(pq);
            
        }

        List<Integer> finalAns = new ArrayList<>();
        if(destination[n] == Integer.MAX_VALUE){
            finalAns.add(-1);
            System.out.println(finalAns);
        }
        else{
            while (parent[n] != n) {
                finalAns.add(n);
                n = parent[n];
            }
            finalAns.add(1);
            Collections.reverse(finalAns);
            System.out.println(finalAns);
        }
    }
    
}
