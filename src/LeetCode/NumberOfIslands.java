package LeetCode;

import java.util.*;

/**
 * 200. Number of Islands
 Total Accepted: 75860
 Total Submissions: 239767
 Difficulty: Medium
 Contributors: Admin
 Given a 2d grid map of '1's (land) and '0's (water), count the number of islands. An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.

 Example 1:

 11110
 11010
 11000
 00000
 Answer: 1

 Example 2:

 11000
 11000
 00100
 00011
 Answer: 3


 */


/**
 * Created by Ben_Big on 11/28/16.
 */
public class NumberOfIslands {
    private int[][] vistedPoints;
    public int numIslands(char[][] grid) {
        vistedPoints=new int [grid.length][];
        for (int i=0;i<grid.length;i++){
            vistedPoints[i]=new int[grid[0].length];
        }
        int result=0;
        for (int i=0;i<grid.length;i++){
            for (int j=0;j<grid[0].length;j++){
                if (grid[i][j]=='1' && vistedPoints[i][j]==0){
                    result++;
                    dfs(i,j,grid);
                }
            }
        }
        return result;
    }
    void dfs(int x,int y,char[][] grid){
        vistedPoints[x][y]=1;
        if (x+1<vistedPoints.length && vistedPoints[x+1][y]==0 && grid[x+1][y]=='1'){
            dfs(x+1,y,grid);
        }
        if (x-1>=0 && vistedPoints[x-1][y]==0 && grid[x-1][y]=='1'){
            dfs(x-1,y,grid);
        }
        if (y+1<vistedPoints[0].length && vistedPoints[x][y+1]==0 && grid[x][y+1]=='1'){
            dfs(x,y+1,grid);
        }
        if (y-1>=0 && vistedPoints[x][y-1]==0 && grid[x][y-1]=='1'){
            dfs(x,y-1,grid);
        }

    }



    public static void main(String[] args){

        char[][] test1=new char[4][];
        char[] test10={'1','1','0','0','0'};
        char[] test11={'1','1','0','0','0'};
        char[] test12={'0','0','1','0','0'};
        char[] test13={'0','0','0','1','1'};
        test1[0]=test10;test1[1]=test11;test1[2]=test12;test1[3]=test13;

        NumberOfIslands noi=new NumberOfIslands();
        System.out.println(noi.numIslands(test1));

    }

}