package sorting;

import java.util.Arrays;

class MergeSort{
    private static double A [];
    public static void main(String args[]){
        A=new double[args.length];
        for(int i=0;i<args.length;i++){
            A[i]=Double.parseDouble(args[i]);
        }
        if (A.length>0) {
            Merge_Sort(0,A.length-1);
            System.out.println(Arrays.toString(A));
        }
    }


    private static void Merge_Sort(int first, int last){
        if (first < last){
            int middle=(first+last)/2;
            Merge_Sort(first,middle);
            Merge_Sort(middle+1,last);
            Merge(first,middle,last);
        }
    }

    private static void Merge(int first, int middle, int last){

        // Generate two new arrays to store the sub-arrays from A
        int left_length=middle-first+1;
        int right_length=last-middle;
        double [] left = new double [left_length + 1];
        double [] right = new double [right_length + 1];
        for (int i=0; i<left_length; i++){
            left[i]=A[first+i];
        }
        left[left_length]=Double.POSITIVE_INFINITY;
        for (int i=0; i<right_length; i++){
            right[i]=A[middle+i+1];
        }
        right[right_length]=Double.POSITIVE_INFINITY;

        ////////////////////////////////////////////////
        // compare and put at the right place of A
        int j=0;  // the index that keeps track of array left
        int k=0;  // the index that keeps track of array right

        for (int i= first; i<=last; i++ ){
            if (left[j]<right[k]){
                A[i]=left[j];
                j++;
            }
            else{
                A[i]=right[k];
                k++;
            }
        }
    }
}