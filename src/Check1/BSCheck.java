package Check1;

public class BSCheck {
    public static void main(String[] args) {
        int[] arr = {2, 4, 5, 9, 13, 17, 20};
        int target = 199;
        int lo = 0;
        int hi = arr.length - 1;
        while(lo<=hi){
            int mid = (lo + hi)/2;
            if(arr[mid] == target) {
                System.out.println(mid);
                target = -1;
                break;
            }
            if(arr[mid]>target) hi = mid-1;
            else lo = mid+1; 
        }
        if(target != -1) System.out.println(-1);

    }
}
