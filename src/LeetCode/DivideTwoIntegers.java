package LeetCode;

/**
 * Created by Ben_Big on 2/9/17.
 */
public class DivideTwoIntegers {
    public int divide(int dividend, int divisor) {
        if (divisor==0) return Integer.MAX_VALUE;
        if (dividend==0) return 0;
        if (dividend==divisor) return 1;
        if (divisor==1) return dividend;
        if ((long)dividend>Integer.MAX_VALUE || (long)dividend<Integer.MIN_VALUE || (long)divisor>Integer.MAX_VALUE || (long)divisor<Integer.MIN_VALUE ){
            return Integer.MAX_VALUE;
        }
        if ((long)dividend==Integer.MIN_VALUE && divisor==-1){
            return Integer.MAX_VALUE;
        }



        boolean isNegative=dividend<0 ^ divisor<0;

        long dividendAbs=Math.abs((long)dividend);
        long divisorAbs=Math.abs((long)divisor);

        if (divisorAbs>dividendAbs) return 0;

        String dividendBin=Long.toBinaryString(dividendAbs);
        String divisorBin=Long.toBinaryString(divisorAbs);



        int result=0;

        while(dividendBin.length()>=divisorBin.length()){
            if (dividendBin.length()==divisorBin.length()){
                long dividendTemp=Long.parseLong(dividendBin,2);
                if (dividendTemp>=divisorAbs) result++;
                break;
            }
            else if (dividendBin.length()==divisorBin.length()+1){
                long dividendTemp=Long.parseLong(dividendBin,2);
                dividendTemp-=divisorAbs;
                result++;
                dividendBin=Long.toBinaryString(dividendTemp);
            }
            else{
                int lenDiff=dividendBin.length()-divisorBin.length()-1;
                String multiplier="1";
                for (int i=0;i<lenDiff-1;i++)multiplier+="0";

                result+=Long.parseLong(multiplier,2);
                String divisorMultiplied="";
                divisorMultiplied=divisorBin+multiplier.substring(1);
                long dividendTemp=Long.parseLong(dividendBin,2);
                dividendTemp-=Long.parseLong(divisorMultiplied,2);
                dividendBin=Long.toBinaryString(dividendTemp);
            }
        }
        result=isNegative? -result:result;
        return result;

    }



    public static void main(String[] args){
        DivideTwoIntegers dti=new DivideTwoIntegers();
        System.out.println(dti.divide(-2147483648,3));
    }
}
