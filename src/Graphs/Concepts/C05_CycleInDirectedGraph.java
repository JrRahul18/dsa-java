package Graphs.Concepts;
import java.util.*;

public class C05_CycleInDirectedGraph {
    public static boolean BFSTraversal(int count, HashMap<Integer, List<Integer>> graph, int[]inDegree){
        Queue<Integer> queue= new LinkedList<>();
        for(int i=0; i<inDegree.length; i++){
            if(inDegree[i] == 0){
                queue.add(i);
            } 
        }
        while(!queue.isEmpty()){
            int u = queue.peek();
            queue.poll();
            for(int nbr: graph.get(u)){
                inDegree[nbr]--;
                if(inDegree[nbr] == 0) {
                    queue.add(nbr);
                }
            }
            count++;
        }
        if(count != inDegree.length) return false;

        return true;
    }
    public static boolean DFSTraversal(int u, HashMap<Integer, List<Integer>> graph, boolean[]checkVisited, boolean[]recursionVisited){
        checkVisited[u] = true;
        recursionVisited[u] = true;
        for(int nbr: graph.get(u)){
            if(checkVisited[nbr] == true && recursionVisited[nbr] == true){
                return false;
            }
            if(checkVisited[nbr] == false && DFSTraversal(nbr, graph, checkVisited, recursionVisited) == false){
                return false;
            }
        }
        recursionVisited[u] = false;
        return true;
    }
    public static void main(String[] args) {
        int v = 4;
        ArrayList<ArrayList<Integer>> adjacentEdges  = new ArrayList<>();
        for(int i= 0; i<v; i++){
            adjacentEdges.add(new ArrayList<>());
        }
        adjacentEdges.get(0).add(1);
        adjacentEdges.get(1).add(2);
        adjacentEdges.get(2).add(3);
        adjacentEdges.get(3).add(3);


        // adjacentEdges.get(0).add(1);
        // adjacentEdges.get(1).add(2);

        System.out.println(adjacentEdges);

        HashMap<Integer, List<Integer>> graph = new HashMap<>();
        for(int i=0; i<v; i++){
            ArrayList<Integer> temp = adjacentEdges.get(i);
            graph.put(i, temp);
        }
        //DFS TRAVERSAL

        // boolean[] checkVisited = new boolean[v];
        // boolean[]recursionVisited = new boolean[v];
        // boolean isCycle = true;
        // for(int i=0; i<v; i++){
        //     if(checkVisited[i] == false && DFSTraversal(i, graph, checkVisited, recursionVisited) == false){
        //         System.out.println("Graph contains cycle");
        //         isCycle = false;
        //         break;
        //     }
        // }
        // if(isCycle == true){
        //     System.out.println("Graph does not contain cycle");

        // }

        //BFS TRAVERSAL
        int[]inDegree = new int[v];
        for(int i=0; i<v; i++){
            for(int nbr: graph.get(i)){
                inDegree[nbr]++;
            }
        }
        int count = 0;
        boolean ans = BFSTraversal(count, graph, inDegree);
        if(ans == false){
            System.out.println("Graph contains cycle");
        }
        else{
            System.out.println("Graph does not contain cycle");
        }




    }
    
}
