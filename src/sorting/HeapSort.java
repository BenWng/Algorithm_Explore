package sorting;


import java.util.Arrays;

public class HeapSort{
    private static  double A[];

    public static void main(String args[]){
        A=new double[args.length];
        for (int j=0;j<args.length;j++){
            A[j]=Double.parseDouble(args[j]);
        }
        sort();
        System.out.println(Arrays.toString(A));
    }

    private static void sort(){
        BuildMaxHeap(A.length);
        for (int i=A.length;i>=2;i--){
            double temp=A[0];
            A[0]=A[i-1];
            A[i-1]=temp;
            MaxHeapify(1,i-1);
        }
    }

    private static void BuildMaxHeap(int n){
        for (int i=n/2;i>=1;i--){
            MaxHeapify(i,n);
        }
    }

    private static void MaxHeapify(int i, int n){
        int l=2*i; //the left child index
        int r=2*i+1; //the right child index
        int largest=i;
        if (l<=n && A[l-1]>A[i-1]){
            largest=l;
        }
        if (r<=n && A[r-1]>A[largest-1]){
            largest=r;
        }
        if(largest != i ){
            double temp=A[largest-1];
            A[largest-1]=A[i-1];
            A[i-1]=temp;
            MaxHeapify(largest,n);
        }
    }
}