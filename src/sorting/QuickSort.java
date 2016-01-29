package sorting;

import java.util.Comparator;

/**
 * Created by Ben_Big on 1/29/16.
 */
public class QuickSort <T extends Comparable<T>> {

        private T Ary [];

        private int partition(int p, int r){
            T pivot=Ary[r];
            int wall =p-1;
            for (int j=p;j<=r-1;j++){
                if (Ary[j].compareTo(pivot)<0){
                    wall++;
                    T temp=Ary[wall];
                    Ary[wall]=Ary[j];
                    Ary[j]=temp;
                }
            }
            wall++;
            T temp2=Ary[wall];
            Ary[wall]=Ary[r];
            Ary[r]=temp2;
            return wall;
        }

        private void sort (int p, int r){
            if (p<r){
                int q=partition(p,r);
                if (q-1>p) {
                    sort(p, q - 1);
                }
                if (q+1<r){
                    sort(q+1,r);
                }
            }
        }



        public static void main(String args[]){
            QuickSort <Double> qs=new QuickSort<>();
            qs.Ary=new Double[5];
            qs.Ary[0]=new Double(10);
            qs.Ary[1]=new Double(3);
            qs.Ary[2]=new Double(1);
            qs.Ary[3]=new Double(8);
            qs.Ary[4]=new Double(2);
            qs.sort(0,4);
            for(int i=0;i<qs.Ary.length;i++) {
                System.out.print(""+qs.Ary[i]+" ");
            }
        }


}
