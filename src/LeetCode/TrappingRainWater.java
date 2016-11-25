package LeetCode;

/**
 * Created by Ben_Big on 11/25/16.
 */

/**
 * 42. Trapping Rain Water
 Total Accepted: 90106
 Total Submissions: 258383
 Difficulty: Hard
 Contributors: Admin
 Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it is able to trap after raining.

 For example,
 Given [0,1,0,2,1,0,1,3,2,1,2,1], return 6.
 */
public class TrappingRainWater {

    public int trap(int[] height) {
        int[] accumulativeHeights=new int[height.length];
        for (int i=0;i<height.length;i++){
            if (i==0) {accumulativeHeights[0]=height[0]; continue;}
            accumulativeHeights[i]=accumulativeHeights[i-1]+height[i];
        }
        int result=0;
        int pointerOne=0;
        int pointerTwo=0;
        int highestHeightInBetween=0;
        int indexHighestHeightInBetween=-1;
        while(pointerOne<height.length && pointerTwo<height.length){
            if(pointerTwo==pointerOne){
                pointerTwo++;
                highestHeightInBetween=0;
                indexHighestHeightInBetween=-1;
                continue;
            }
            if (highestHeightInBetween<height[pointerTwo]){
                highestHeightInBetween=height[pointerTwo];
                indexHighestHeightInBetween=pointerTwo;
            }
            if(pointerTwo==height.length-1 && height[pointerTwo]<height[pointerOne]){
                pointerTwo=indexHighestHeightInBetween==-1?pointerTwo:indexHighestHeightInBetween;
            }
            else if(height[pointerTwo]<height[pointerOne]){
                pointerTwo++;
                continue;
            }
            int widthOfArea=pointerTwo-pointerOne-1;
            int heightOfArea=height[pointerOne]>height[pointerTwo]?height[pointerTwo]:height[pointerOne];
            int area=widthOfArea*heightOfArea;
            int areaInBetween=accumulativeHeights[pointerTwo]-accumulativeHeights[pointerOne]-height[pointerTwo];
            result+=(area-areaInBetween);
            pointerOne=pointerTwo;
        }
        return result;
    }

    public static void main(String[] args){
        TrappingRainWater rrw=new TrappingRainWater();
        int [] test1={0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.println(rrw.trap(test1));
    }





}
