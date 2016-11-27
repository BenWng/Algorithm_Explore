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
    HashSet<Map.Entry<Integer,Integer>> onePositions=new HashSet<>();
    public int numIslands(char[][] grid) {

        for (int i=0;i<grid.length;i++){
            for (int j=0;j<grid[0].length;j++){
                if (grid[i][j]=='1'){
                    Map.Entry<Integer,Integer> position=new AbstractMap.SimpleEntry(i,j);
                    onePositions.add(position);
                }
            }
        }

        int result=0;
        while(!onePositions.isEmpty()){
            Map.Entry<Integer,Integer> currentPos=new AbstractMap.SimpleEntry(-1,-1);
            for (Map.Entry<Integer,Integer>pos : onePositions){
                currentPos=pos;
                break;
            }
            onePositions.remove(currentPos);
            doBFS(currentPos,grid);
            result++;
        }
        return result;
    }

    private void doBFS(Map.Entry<Integer,Integer> currentPos, char[][] grid){
        Queue<Map.Entry<Integer,Integer>> queue=new LinkedList<>();
        queue.add(currentPos);
        while(!queue.isEmpty()){
            Map.Entry<Integer,Integer> pos=queue.poll();
            int x=pos.getKey();
            int y=pos.getValue();

            if(x+1<grid.length && grid[x+1][y]=='1'){
                Map.Entry<Integer,Integer>neighbor=new AbstractMap.SimpleEntry(x+1,y);
                if (onePositions.contains(neighbor)){
                    onePositions.remove(neighbor);
                    queue.add(neighbor);
                }
            }
            if(x-1>=0 && grid[x-1][y]=='1'){
                Map.Entry<Integer,Integer>neighbor=new AbstractMap.SimpleEntry(x-1,y);
                if (onePositions.contains(neighbor)){
                    onePositions.remove(neighbor);
                    queue.add(neighbor);
                }
            }
            if(y+1<grid[0].length && grid[x][y+1]=='1'){
                Map.Entry<Integer,Integer>neighbor=new AbstractMap.SimpleEntry(x,y+1);
                if (onePositions.contains(neighbor)){
                    onePositions.remove(neighbor);
                    queue.add(neighbor);
                }

            }
            if(y-1>=0 && grid[x][y-1]=='1'){
                Map.Entry<Integer,Integer>neighbor=new AbstractMap.SimpleEntry(x,y-1);
                if (onePositions.contains(neighbor)){
                    onePositions.remove(neighbor);
                    queue.add(neighbor);
                }
            }
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