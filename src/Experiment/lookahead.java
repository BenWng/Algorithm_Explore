package Experiment;
import java.util.*;

/**
 * Created by Ben_Big on 1/5/16.
 */
public class lookahead {
    public static void main(String args[]){
        String x="hello world";
        String [] xArray=x.split("(?!^)");
        System.out.println(Arrays.toString(xArray));
    }
}
