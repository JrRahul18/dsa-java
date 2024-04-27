package Graphs.Concepts;
import java.util.*;



public class C12_Dijkstra_Algorithm {
    //Dijkstra Algorithm to find minimum weight distance from a source to all other nodes in the graph
    static class Pair{
        int node;
        int weight;
        Pair(int node, int weight){
            this.node = node;
            this.weight = weight;
        }
    }
    public static void main(String[] args) {
        ArrayList<ArrayList<ArrayList<Integer>>> adj = new ArrayList<>();
        int v = 3;
        int source = 2;
        for(int i=0; i<v; i++){
            adj.add(new ArrayList<>());
        }
        adj.get(0).add(new ArrayList<>(Arrays.asList(1, 1)));
        adj.get(0).add(new ArrayList<>(Arrays.asList(2, 6)));
        adj.get(1).add(new ArrayList<>(Arrays.asList(2, 3)));
        adj.get(1).add(new ArrayList<>(Arrays.asList(0, 1)));
        adj.get(2).add(new ArrayList<>(Arrays.asList(1, 3)));
        adj.get(2).add(new ArrayList<>(Arrays.asList(0, 6)));

        int[] destination = new int[v];
        Arrays.fill(destination, Integer.MAX_VALUE);
        destination[source]=0;

        HashMap<Integer, List<Pair>> graph = new HashMap<>();
        for(int i=0; i<v; i++){
            graph.put(i, new ArrayList<>());
        }
        for(int i=0; i<v; i++){
            ArrayList<ArrayList<Integer>> temp = adj.get(i);
            for(ArrayList<Integer> p: temp){
                int node = p.get(0);
                int weight = p.get(1);
                graph.get(i).add(new Pair(node, weight));
            }
        }

        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> a.weight-b.weight);
        pq.add(new Pair(source, 0));

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
                    }
                }
            }
        }
        for(int i=0; i<destination.length; i++){
            System.out.print(destination[i] + " ");
        }
    }
    
}
