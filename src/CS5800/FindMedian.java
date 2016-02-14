package CS5800;




import java.util.*;

/**
 * Created by Ben_Big on 2/7/16.
 *
 * For HW3 Question 9
 *
 */
public class FindMedian {
    public static int f(int[] A, int B[]){
        if(A.length==1 && B.length==1){

            return Integer.min(A[0],B[0]);
        }

        int median;
        boolean evenFlag=false;
        if(A.length%2==0){
            median=A.length/2-1;
            evenFlag=true;
        }
        else {
            median = A.length / 2;
        }
        if (A[median]>=B[median]){
            int[] A_sub=new int [median+1];
            int[] B_sub=new int [median+1];

            for(int i=0;i<=median;i++){
                A_sub[i]=A[i];
                if (evenFlag) {
                    B_sub[i] = B[i + median+1];
                }
                else{
                    B_sub[i] = B[i+median];
                }
            }
            return f(A_sub,B_sub);
        }
        else {
            int[] A_sub=new int [median+1];
            int[] B_sub=new int [median+1];

            for(int i=0;i<=median;i++){
                B_sub[i]=B[i];
                if (evenFlag) {
                    A_sub[i] = A[i + median+1];
                }
                else{
                    A_sub[i] = A [i+median];
                }
            }
            return f(A_sub,B_sub);
        }
    }
    public static void main(String[] args){
        int[] A={2,3};
        int[] B={4,5};
        System.out.println(f(A,B));
    }
}
