package LeetCode;

import java.util.*;

/**
 * Created by ben on 5/23/16.
 */

/** 241.
 * Given a string of numbers and operators,
 * return all possible results from computing all the different possible ways to group numbers and operators.
 * The valid operators are +, - and *.


 Example 1
 Input: "2-1-1".

 ((2-1)-1) = 0
 (2-(1-1)) = 2
 Output: [0, 2]


 Example 2
 Input: "2*3-4*5"

 (2*(3-(4*5))) = -34
 ((2*3)-(4*5)) = -14
 ((2*(3-4))*5) = -10
 (2*((3-4)*5)) = -10
 (((2*3)-4)*5) = 10
 Output: [-34, -14, -10, -10, 10]

 Credits:
 Special thanks to @mithmatt for adding this problem and creating all test cases.

 Subscribe to see which companies asked this question
 */



public class DiffWaysAddParentheses {

    public List<Integer> diffWaysToCompute(String input) {

        String [] numStr=input.split("[\\+\\-\\*]");
        String [] symStr=input.split("[0-9]");


        int [] result;
        int [] num;
        int [] sym;

        if (numStr.length==1){
            result=new int[1];
            result[0]=(Integer.valueOf(numStr[0]));
        }
        else {
            num=new int[numStr.length];
            sym=new int[numStr.length-1];
            int symK=0;

            for(int i=0;i<num.length;i++){
                num[i]=Integer.valueOf(numStr[i]);
            }
            for (int j=0;j<symStr.length;j++){
                if (!symStr[j].equals("")){
                    sym[symK]=symStr[j].charAt(0);
                    symK++;
                }
            }
            result = this.computePermutations(num, sym);
        }

        LinkedList<Integer> resultList=new LinkedList<>();
        for (int i:result){
            resultList.add(i);
        }
        return resultList;

    }


    private int[] computePermutations(int[] num, int[] sym){
        int numLength=num.length;
        int symLength=sym!=null?sym.length:0;
        if (numLength==1){
            return num;
        }
        ArrayList<Integer> combinedResult=new ArrayList<>();

        for (int splitPos=0;splitPos<=numLength-2;splitPos++){
            int [] num1=Arrays.copyOfRange(num,0,splitPos+1);
            int [] sym1=splitPos>=1?Arrays.copyOfRange(sym,0,splitPos):null;
            int [] num1Res=this.computePermutations(num1,sym1);

            int [] num2=Arrays.copyOfRange(num,splitPos+1,numLength);
            int [] sym2=Arrays.copyOfRange(sym,splitPos+1,symLength);
            int [] num2Res=this.computePermutations(num2,sym2);



            int [] r=this.cal(num1Res,sym[splitPos],num2Res);

            for (int i=0;i<r.length;i++){
                combinedResult.add(r[i]);
            }
        }

        int [] returnResult=new int [combinedResult.size()];
        Iterator<Integer> itr=combinedResult.iterator();
        int i=0;
        while(itr.hasNext()){
            returnResult[i]=itr.next();
            i++;
        }
        return returnResult;
    }

    private int[] cal(int[] x, int s, int[] y ){
        int [] result=new int [x.length*y.length];
        int k=0;
        for (int i=0;i<x.length;i++){
            for (int j=0;j<y.length;j++){
                int temp=0;
                switch(s){
                    case 43:
                        temp=x[i]+y[j];
                        break;
                    case 45:
                        temp=x[i]-y[j];
                        break;
                    case 42:
                        temp=x[i]*y[j];
                        break;
                    default:
                        System.out.println("Wrong input");
                        return null;
                }
                result[k]=temp;
                k++;
            }
        }
        return result;
    }



    public static void main(String[] args){
        DiffWaysAddParentheses dwap=new DiffWaysAddParentheses();
        System.out.println(dwap.diffWaysToCompute("11*23-8"));
    }


}
