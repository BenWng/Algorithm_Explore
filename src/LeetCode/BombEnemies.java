package LeetCode;

/**
 * Created by Ben_Big on 12/4/16.
 */

/**
 * 361. Bomb Enemy
 Total Accepted: 8400
 Total Submissions: 22326
 Difficulty: Medium
 Contributors: Admin
 Given a 2D grid, each cell is either a wall 'W', an enemy 'E' or empty '0' (the number zero), return the maximum enemies you can kill using one bomb.
 The bomb kills all the enemies in the same row and column from the planted point until it hits the wall since the wall is too strong to be destroyed.
 Note that you can only put the bomb at an empty cell.

 Example:
 For the given grid

 0 E 0 0
 E 0 W E
 0 E 0 0

 return 3. (Placing a bomb at (1,1) kills 3 enemies)

 */

//ToDo: The following solution is following a post in Discuss

public class BombEnemies {
    public int maxKilledEnemies(char[][] grid) {
        if (grid.length==0)return 0;
        int[] colEnemies=new int[grid[0].length];
        for (int i=0;i<grid[0].length;i++){
            colEnemies[i]=numEnemiesInCol(grid,0,i);
        }
        int result=0;
        for (int i=0;i<grid.length;i++){
            int rowEnemies=0;
            for (int j=0;j<grid[0].length;j++){
                if (j==0 || grid[i][j-1]=='W' ){
                    rowEnemies=numEnemiesRow(grid,i,j);
                }
                if (i>0 && grid[i-1][j]=='W'){
                    colEnemies[j]=numEnemiesInCol(grid,i,j);
                }
                int tempResult=rowEnemies+colEnemies[j];
                if (grid[i][j]=='0') {
                    result = tempResult > result ? tempResult : result;
                }

            }
        }
        return result;
    }
    private int numEnemiesInCol(char[][]grid, int x,int y){
        int result=0;
        for (int i=x;i<grid.length;i++){
            if(grid[i][y]=='E'){
                result++;
            }
            if(grid[i][y]=='W'){
                break;
            }
        }
        return result;
    }
    private int numEnemiesRow(char[][]grid, int x,int y){
        int result=0;
        for (int i=y;i<grid[0].length;i++){
            if(grid[x][i]=='E'){
                result++;
            }
            if(grid[x][i]=='W'){
                break;
            }
        }
        return result;
    }
    public static void main(String[] args){
        BombEnemies be=new BombEnemies();
        char[][] test1={{'0','E','0','0'},{'E','0','W','E'},{'0','E','0','0'}};
        char[][] test2={{}};
        System.out.println(be.maxKilledEnemies(test2));
    }

}
