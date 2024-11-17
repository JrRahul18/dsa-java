package Graphs.Concepts;

public class C15_Floyd_Warshall_Algorithm {
    //Algorithm to find minimum distance between every pair of nodes in given edge-weighted directed graph
    //Can detect negative cycle if graph[i][i]<0


    public static void main(String[] args) {
        int v=3;
        int[][] grid = {{0, 1, 43}, {1, 0, 6}, {-1, -1, 0}};

        for(int i=0; i<grid.length; i++){
            for(int j=0; j<grid[i].length; j++){
                if(grid[i][j] == -1){
                    grid[i][j]=100000;
                }
            }
        }

        for(int n=0; n<v; n++){

            for(int i=0; i<grid.length; i++){
                for(int j=0; j<grid[i].length; j++){
                    grid[i][j] = Math.min(grid[i][j], grid[i][n] + grid[n][j]);
                }
            }
        }

        //return 100000 to -1 which we changed
        for(int i=0; i<grid.length; i++){
            for(int j=0; j<grid[i].length; j++){
                if(grid[i][j] == 100000){
                    grid[i][j]=-1;
                }
            }
        }
        boolean check = true;
        for(int i=0; i<grid.length; i++){
            if(grid[i][i]<-1){
                System.out.println("Graph contains negative cycle");
                check = false;
            }
        }

        if(check == true){
            System.out.print("x"+" ");
            for(int i=0; i<grid.length; i++){
                System.out.print(i+" ");
            }

            System.out.println();

            for(int i=0; i<grid.length; i++){
                System.out.print(i+" ");
                for(int j=0; j<grid[i].length; j++){
                    System.out.print(grid[i][j]+" ");
                }
                System.out.println();
            }
        }

    }
    
}
