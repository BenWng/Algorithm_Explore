package LeetCode;

/**
 * Created by Ben_Big on 6/10/16.
 */


/**
 * 169.
 *Given an array of size n, find the majority element. The majority element is the element that appears more than ⌊ n/2 ⌋ times.
 * You may assume that the array is non-empty and the majority element always exist in the array.

 */


class wordCount{
    private int word;
    private int count;
    wordCount(int w){
        word=w;
        count=1;
    }
    int getCount(){
        return count;
    }
    int getWord(){
        return word;
    }
    boolean equal(int w){
        return word==w;
    }
    void add(){
        count++;
    }
}

public class MajorityElement {
    public int majorityElement(int[] nums) {
        int length=nums.length;
        wordCount [] cache=new wordCount[2];
        if (length==1){
            return nums[0];
        }
        for (int i=0;i<length;i++){
            int ele=nums[i];
            for (int j=0;j<2;j++){
                if (cache[j]==null){ //in the beginning when the cache is still empty
                    cache[j]=new wordCount(ele);
                    break;
                }
                else if(cache[j].equal(ele)){
                    cache[j].add();
                    break;
                }
                else if(j==1){ //this element is not in the cache
                    if (cache[0].getCount()<cache[1].getCount()){
                        cache[0]=new wordCount(ele);
                    }
                    else{
                        cache[1]=new wordCount(ele);
                    }
                }
            }
        }
        if (cache[0]==null){
            return cache[1].getWord();
        }
        else if (cache[1]==null){
            return cache[0].getWord();
        }

        return cache[0].getCount()>cache[1].getCount()? cache[0].getWord():cache[1].getWord();



    }
    public static void main(String[] args){
        //Test
        MajorityElement me1=new MajorityElement();
        int[] test1={1,2,3,1,3,3,4,5,3,3};
        System.out.println(me1.majorityElement(test1));//expecting 3


        int[] test2={1};
        System.out.println(me1.majorityElement(test2));//expecting 1

        int[] test3={1,2,1};
        System.out.println(me1.majorityElement(test3));//expecting 1

        int[] test4={2,2};
        System.out.println(me1.majorityElement(test4));//expecting 2
    }
}
