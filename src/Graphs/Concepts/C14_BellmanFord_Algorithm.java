package Graphs.Concepts;
import java.util.*;



public class C14_BellmanFord_Algorithm {
    //Algorithm to find minimum weight distance from a source to all other nodes in graph.
    //works for negative edges.
    //Can detect negative cycle if iteration is done more than V-1 times.
    static class Pair {
        int node;
        int weight;

        Pair(int node, int weight) {
            this.node = node;
            this.weight = weight;
        }
    }

    public static void main(String[] args) {
        ArrayList<ArrayList<ArrayList<Integer>>> adj = new ArrayList<>();
        int v = 6;
        int source = 0;

        for(int i=0; i<v; i++){
            adj.add(new ArrayList<>());
        }

        adj.get(3).add(new ArrayList<>(Arrays.asList(2, 7)));
        adj.get(5).add(new ArrayList<>(Arrays.asList(3, 2)));
        adj.get(0).add(new ArrayList<>(Arrays.asList(1, 5)));
        adj.get(1).add(new ArrayList<>(Arrays.asList(5, -3)));
        adj.get(1).add(new ArrayList<>(Arrays.asList(2, -2)));
        adj.get(3).add(new ArrayList<>(Arrays.asList(4, -2)));
        adj.get(2).add(new ArrayList<>(Arrays.asList(4, 3)));

        int[] destination = new int[v];
        Arrays.fill(destination, Integer.MAX_VALUE);
        destination[source] = 0;

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


        for(int i=0; i<v-1; i++){
            for(int j=0; j<v; j++){
                List<Pair> temp = graph.get(j);
                for(Pair nbr: temp){
                    if(destination[j]!= Integer.MAX_VALUE && destination[j]+nbr.weight < destination[nbr.node]){
                        destination[nbr.node]=destination[j]+nbr.weight;
                    }
                }
            }
        }

        // To check if graph contains cycle
        //Running iteration one more time; if answer changes, then graph contains cycle
        boolean check = false;
        for(int j=0; j<v; j++){
            List<Pair> temp = graph.get(j);
            for(Pair nbr: temp){
                if(destination[j]!= Integer.MAX_VALUE && destination[j]+nbr.weight < destination[nbr.node]){
                    System.out.println("Graph contains Cycle");
                    check = true;
                    break;
                }
            }
        }

        if(check == false){
            for(int i=0; i<destination.length; i++){
                System.out.print(destination[i] + " ");
            }
        }
    
    }
}
