package Check1;
import java.util.*;

public class Question {
    public static int solve(int N, int M, int[][]A){
        int finalAns = Integer.MAX_VALUE;

        for(int i=0; i<M; i++){
            finalAns = Math.min(finalAns, A[0][i]);
        }

        for(int i=1; i<N; i++){
            int temp = Integer.MAX_VALUE;
            for(int j=0; j<M; j++){
                temp = Math.min(temp, finalAns | A[i][j]);
            }
            finalAns = temp;
        }
        return finalAns;
    }
    public static void main(String[] args) {
        int N = 4;
        int M = 3;
        int [][] A  = {{0, 9, 1}, {9, 3, 14},{4, 1, 12}, {6, 14, 2}};

        System.out.println(solve(N, M, A));
    }
    
}
