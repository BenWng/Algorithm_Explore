package LeetCode;

/**
 * Created by ben on 6/12/16.
 */


/** 91.
 * A message containing letters from A-Z is being encoded to numbers using the following mapping:
 'A' -> 1
 'B' -> 2
 ...
 'Z' -> 26
 Given an encoded message containing digits, determine the total number of ways to decode it.
 For example,
 Given encoded message "12", it could be decoded as "AB" (1 2) or "L" (12).
 The number of ways decoding "12" is 2.
 */


//ToDo: The corner case of this problem is very tricky

public class DecodeWays {

    public int numDecodings(String s) {

        if (s.length()==0 ){
            return 0;
        }

        char [] charArr=s.toCharArray();
        if (charArr[0]==48){
            return 0;
        }
        int [] numArr=new int [charArr.length];
        for (int i=0;i<charArr.length;i++){

            numArr[i]=charArr[i]-48;
        }
        int[] numWays=new int[numArr.length];
        if(numArr[0]==0){
            return 0;
        }

        numWays[0]=1;
        for (int i=1;i<numWays.length;i++)
        {
            if(numArr[i]==0){
                if (numArr[i-1]==1 || numArr[i-1]==2){
                    numWays[i-1]=(i==1?1:numWays[i-2]);
                    numWays[i]=numWays[i-1];
                }
                else{
                    return 0;
                }
            }
            else{
                if (numArr[i-1]!=0 && numArr[i-1]*10+numArr[i]<=26){
                    numWays[i]=numWays[i-1]+ (i == 1 ? 1 : numWays[i - 2]);
                }
                else{
                    numWays[i]=numWays[i-1];
                }
            }

        }
        return numWays[numWays.length-1];
    }
    public static void main(String[] args){
        //Test
        DecodeWays dw=new DecodeWays();
        System.out.println(dw.numDecodings("123"));//expecting 3

        System.out.println(dw.numDecodings(""));//expecing 0

        System.out.println(dw.numDecodings("0"));//expecing 0

        System.out.println(dw.numDecodings("260"));//expecting 0

        System.out.println(dw.numDecodings("10")); //expecing 1


        System.out.println(dw.numDecodings("100"));//expecting 0

        System.out.println(dw.numDecodings("101"));//expecting 1


        System.out.println(dw.numDecodings("032"));//expecting 0

        System.out.println(dw.numDecodings("110"));//expecting 1

        System.out.println(dw.numDecodings("26815"));//expecting 4

    }
}
