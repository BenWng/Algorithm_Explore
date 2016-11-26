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
    private int[][][] sumDistanceToHouses;
    public int shortestDistance(int[][] grid) {
        sumDistanceToHouses=new int[grid.length][][];
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
            sumDistanceToHouses[i]=new int [grid[0].length][];
            for (int j=0;j<grid[0].length;j++){
                sumDistanceToHouses[i][j]=new int[numHouses];
            }
        }
        int houseNumber=0;
        for (Map.Entry<Integer,Integer>house : housePositions) {
            BFS(house, grid,houseNumber);
            houseNumber++;
        }
        int result=Integer.MAX_VALUE;
        for (int i=0;i<sumDistanceToHouses.length;i++){
            for (int j=0;j<sumDistanceToHouses[0].length;j++){
                int currentSumDistance=0;
                for (int k=0;k<numHouses;k++) {
                    if (sumDistanceToHouses[i][j][k] == 0 ){
                        currentSumDistance=0;
                        break;
                    }
                    else{
                        currentSumDistance+=sumDistanceToHouses[i][j][k];
                    }
                }
                if (currentSumDistance!=0 && currentSumDistance<result) result=currentSumDistance;
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
        HashSet<Map.Entry<Integer,Integer>> visitedPlaces=new HashSet<>();
        visitedPlaces.add(startPos);
        while(!queue.isEmpty()){
            Map.Entry<Integer,Integer> position=queue.poll();
            int x=position.getKey();
            int y=position.getValue();
            if (x+1<grid.length && grid[x+1][y]==0){
                Map.Entry<Integer,Integer>currentPos=new AbstractMap.SimpleEntry(x+1,y);
                if (!visitedPlaces.contains(currentPos)){
                    distanceToThisHouse[x+1][y]=distanceToThisHouse[x][y]+1;
                    queue.add(currentPos);
                    visitedPlaces.add(currentPos);
                    sumDistanceToHouses[x+1][y][houseNumber]=distanceToThisHouse[x+1][y];
                }
            }
            if (x-1>=0 && grid[x-1][y]==0){
                Map.Entry<Integer,Integer>currentPos=new AbstractMap.SimpleEntry(x-1,y);
                if (!visitedPlaces.contains(currentPos)){
                    distanceToThisHouse[x-1][y]=distanceToThisHouse[x][y]+1;
                    queue.add(currentPos);
                    visitedPlaces.add(currentPos);
                    sumDistanceToHouses[x-1][y][houseNumber]=distanceToThisHouse[x-1][y];
                }

            }
            if (y+1<grid[0].length && grid[x][y+1]==0){
                Map.Entry<Integer,Integer>currentPos=new AbstractMap.SimpleEntry(x,y+1);
                if (!visitedPlaces.contains(currentPos)){
                    distanceToThisHouse[x][y+1]=distanceToThisHouse[x][y]+1;
                    queue.add(currentPos);
                    visitedPlaces.add(currentPos);
                    sumDistanceToHouses[x][y+1][houseNumber]=distanceToThisHouse[x][y+1];
                }

            }
            if (y-1>=0 && grid[x][y-1]==0){
                Map.Entry<Integer,Integer>currentPos=new AbstractMap.SimpleEntry(x,y-1);
                if (!visitedPlaces.contains(currentPos)){
                    distanceToThisHouse[x][y-1]=distanceToThisHouse[x][y]+1;
                    queue.add(currentPos);
                    visitedPlaces.add(currentPos);
                    sumDistanceToHouses[x][y-1][houseNumber]=distanceToThisHouse[x][y-1];
                }
            }
        }
    }
    public static void main(String[] args){
        ShortestDistanceFromAllBuildings sdfab=new ShortestDistanceFromAllBuildings();
        int [][] test1=new int[3][];
        int [] test10={1,0,2,0,1};
        int [] test11={0,0,0,0,0};
        int [] test12={0,0,1,0,0};
        test1[0]=test10;
        test1[1]=test11;
        test1[2]=test12;


        System.out.println(sdfab.shortestDistance(test1));
    }

}
