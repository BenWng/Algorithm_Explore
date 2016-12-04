package LeetCode;

/**
 * Created by Ben_Big on 12/5/16.
 */

/**
 * 28. Implement strStr()
 Total Accepted: 144299
 Total Submissions: 540748
 Difficulty: Easy
 Contributors: Admin
 Implement strStr().

 Returns the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.
 */

public class implementStrStr {

    public int strStr(String haystack, String needle) {
        if (haystack.length()==needle.length()){
            if (haystack.equals(needle)) return 0;
            else return -1;
        }
        int needleLength=needle.length();
        int haystackLength=haystack.length();
        for (int i=0;i<haystackLength;i++){
            String subString="";
            if (i+needleLength<=haystackLength){
                subString=haystack.substring(i,i+needleLength);
            }
            if (subString.equals(needle)){
                return i;
            }
        }
        return -1;
    }
    public static void main(String[] args){
        implementStrStr iss=new implementStrStr();
        System.out.println(iss.strStr("This is a simple string","simple"));
    }
}
