package LeetCode;

import java.util.*;

/**
 * Created by Ben_Big on 11/26/16.
 */

/**
 * 317. Shortest Distance from All Buildings
 Total Accepted: 10424
 Total Submissions: 31848
 Difficulty: Hard
 Contributors: Admin
 You want to build a house on an empty land which reaches all buildings in the shortest amount of distance. You can only move up, down, left and right. You are given a 2D grid of values 0, 1 or 2, where:

 Each 0 marks an empty land which you can pass by freely.
 Each 1 marks a building which you cannot pass through.
 Each 2 marks an obstacle which you cannot pass through.
 For example, given three buildings at (0,0), (0,4), (2,2), and an obstacle at (0,2):

 1 - 0 - 2 - 0 - 1
 |   |   |   |   |
 0 - 0 - 0 - 0 - 0
 |   |   |   |   |
 0 - 0 - 1 - 0 - 0
 The point (1,2) is an ideal empty land to build a house, as the total travel distance of 3+3+1=7 is minimal. So return 7.

 Note:
 There will be at least one building. If it is not possible to build such house according to the above rules, return -1.

 */


public class ShortestDistanceFromAllBuildings {
    private int[][] sumDistanceToHouses;
    private boolean houseNotReachable=false;
    public int shortestDistance(int[][] grid) {
        sumDistanceToHouses=new int[grid.length][];
        HashSet<Map.Entry<Integer,Integer>> housePositions=new HashSet<>();
        for (int i=0;i<grid.length;i++){
            for (int j=0;j<grid[0].length;j++){
                if (grid[i][j]==1){
                    Map.Entry<Integer,Integer>newHouse=new AbstractMap.SimpleEntry(i,j);
                    housePositions.add (newHouse);
                }
            }
        }
        int numHouses=housePositions.size();
        for (int i=0;i<grid.length;i++){
            sumDistanceToHouses[i]=new int [grid[0].length];
        }
        int houseNumber=0;
        for (Map.Entry<Integer,Integer>house : housePositions) {
            BFS(house, grid,houseNumber);
            houseNumber++;
            if (houseNotReachable) return -1;
        }
        int result=Integer.MAX_VALUE;
        for (int i=0;i<sumDistanceToHouses.length;i++){
            for (int j=0;j<sumDistanceToHouses[0].length;j++){
                if (sumDistanceToHouses[i][j]!=0 && sumDistanceToHouses[i][j]<result) result=sumDistanceToHouses[i][j];
            }
        }
        if (result==Integer.MAX_VALUE){
            return -1;
        }
        return result;
    }
    private void BFS(Map.Entry<Integer,Integer> startPos, int[][] grid,int houseNumber){
        int[][] distanceToThisHouse;
        distanceToThisHouse=new int[grid.length][];
        for (int i=0;i<grid.length;i++){
            distanceToThisHouse[i]=new int [grid[0].length];
        }
        Queue<Map.Entry<Integer,Integer>> queue=new LinkedList<>();
        queue.add(startPos);
        int numReachablePoints=0;
        while(!queue.isEmpty()){
            Map.Entry<Integer,Integer> position=queue.poll();
            int x=position.getKey();
            int y=position.getValue();
            if (x+1<grid.length && grid[x+1][y]==0 && distanceToThisHouse[x+1][y]==0){
                Map.Entry<Integer,Integer>currentPos=new AbstractMap.SimpleEntry(x+1,y);
                queue.add(currentPos);
                distanceToThisHouse[x+1][y]=distanceToThisHouse[x][y]+1;
                if (houseNumber==0 || sumDistanceToHouses[x+1][y]!=0){
                    sumDistanceToHouses[x+1][y]+=distanceToThisHouse[x+1][y];
                    numReachablePoints++;
                }
            }
            if (x-1>=0 && grid[x-1][y]==0 && distanceToThisHouse[x-1][y]==0){
                Map.Entry<Integer,Integer>currentPos=new AbstractMap.SimpleEntry(x-1,y);
                queue.add(currentPos);
                distanceToThisHouse[x-1][y]=distanceToThisHouse[x][y]+1;
                if (houseNumber==0 || sumDistanceToHouses[x-1][y]!=0){
                    sumDistanceToHouses[x-1][y]+=distanceToThisHouse[x-1][y];
                    numReachablePoints++;
                }

            }
            if (y+1<grid[0].length && grid[x][y+1]==0 && distanceToThisHouse[x][y+1]==0){
                Map.Entry<Integer,Integer>currentPos=new AbstractMap.SimpleEntry(x,y+1);
                queue.add(currentPos);
                distanceToThisHouse[x][y+1]=distanceToThisHouse[x][y]+1;
                if (houseNumber==0 || sumDistanceToHouses[x][y+1]!=0){
                    sumDistanceToHouses[x][y+1]+=distanceToThisHouse[x][y+1];
                    numReachablePoints++;
                }

            }
            if (y-1>=0 && grid[x][y-1]==0 && distanceToThisHouse[x][y-1]==0){
                Map.Entry<Integer,Integer>currentPos=new AbstractMap.SimpleEntry(x,y-1);
                queue.add(currentPos);
                distanceToThisHouse[x][y-1]=distanceToThisHouse[x][y]+1;
                if (houseNumber==0 || sumDistanceToHouses[x][y-1]!=0){
                    sumDistanceToHouses[x][y-1]+=distanceToThisHouse[x][y-1];
                    numReachablePoints++;
                }
            }
        }
        if (numReachablePoints==0){
            houseNotReachable=true;
            return;
        }

        for (int i=0;i<grid.length;i++){
            for (int j=0;j<grid[0].length;j++){
                if (distanceToThisHouse[i][j]==0 && sumDistanceToHouses[i][j]!=0) sumDistanceToHouses[i][j]=0;
            }
        }


    }
    public static void main(String[] args){
        ShortestDistanceFromAllBuildings sdfab=new ShortestDistanceFromAllBuildings();
        int [][] test1=new int[5][];
        int [] test10={0,2,0,2,2,0,2,2};
        int [] test11={0,2,2,2,1,0,1,2};
        int [] test12={0,0,0,1,0,2,0,0};
        int [] test13={2,0,0,2,0,2,2,0};
        int [] test14={0,0,0,2,0,0,0,0};
        test1[0]=test10;
        test1[1]=test11;
        test1[2]=test12;
        test1[3]=test13;
        test1[4]=test14;

        System.out.println(sdfab.shortestDistance(test1));
    }

}
