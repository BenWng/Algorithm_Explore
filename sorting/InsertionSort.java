import java.util.Arrays;

public class InsertionSort{
    public static void main(String args[]){
        int ary[] =new int[args.length];
        for (int i=0;i<args.length;i++){
            ary[i]=Integer.parseInt(args[i]);
        }
        if (ary.length>0) {
            System.out.println(Arrays.toString(insertion_srt(ary)));
        }
    }


    public static int [] insertion_srt(int array[]){
        for(int i=0;i<array.length-1;i++){
            for(int j=i+1;j>0;j--){
                if (array[j]<array[j-1]) {
                    int temp=array[j-1];
                    array[j-1]=array[j];
                    array[j]=temp;
                }
                else{
                    break;
                }
            }
        }
        return array;
    }
}