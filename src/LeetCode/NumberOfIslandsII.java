package LeetCode;

import java.util.*;

/**
 * 305. Number of Islands II
 Total Accepted: 14798
 Total Submissions: 39284
 Difficulty: Hard
 Contributors: Admin
 A 2d grid map of m rows and n columns is initially filled with water. We may perform an addLand operation which turns the water at position (row, col) into a land. Given a list of positions to operate, count the number of islands after each addLand operation. An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.

 Example:

 Given m = 3, n = 3, positions = [[0,0], [0,1], [1,2], [2,1]].
 Initially, the 2d grid grid is filled with water. (Assume 0 represents water and 1 represents land).

 0 0 0
 0 0 0
 0 0 0
 Operation #1: addLand(0, 0) turns the water at grid[0][0] into a land.

 1 0 0
 0 0 0   Number of islands = 1
 0 0 0
 Operation #2: addLand(0, 1) turns the water at grid[0][1] into a land.

 1 1 0
 0 0 0   Number of islands = 1
 0 0 0
 Operation #3: addLand(1, 2) turns the water at grid[1][2] into a land.

 1 1 0
 0 0 1   Number of islands = 2
 0 0 0
 Operation #4: addLand(2, 1) turns the water at grid[2][1] into a land.

 1 1 0
 0 0 1   Number of islands = 3
 0 1 0

 */



/**
 * Created by Ben_Big on 11/28/16.
 */

//ToDo: the following solution exceeds time limit

public class NumberOfIslandsII {
    public List<Integer> numIslands2(int m, int n, int[][] positions) {
        HashSet<HashSet<Integer>> unions=new HashSet<>();
        List<Integer> result=new ArrayList<>();
        for (int[] pos : positions){
            int x=pos[0];
            int y=pos[1];
            int currentPosition=n*x+y;
            HashSet<Integer> newUnion=new HashSet<>();
            newUnion.add(currentPosition);
            HashSet<Integer> union1=new HashSet<>();
            HashSet<Integer> union2=new HashSet<>();
            HashSet<Integer> union3=new HashSet<>();
            HashSet<Integer> union4=new HashSet<>();
            if (x+1<m){
                int neighbor=n*(x+1)+y;
                for (HashSet<Integer> union:unions){
                    if (union.contains(neighbor)){
                        union1=union;
                        unions.remove(union);
                        break;
                    }
                }
            }
            if (x-1>=0){
                int neighbor=n*(x-1)+y;
                for (HashSet<Integer> union:unions){
                    if (union.contains(neighbor)){
                        union2=union;
                        unions.remove(union);
                        break;
                    }
                }
            }
            if (y+1<n){
                int neighbor=n*x+y+1;
                for (HashSet<Integer> union:unions){
                    if (union.contains(neighbor)){
                        union3=union;
                        unions.remove(union);
                        break;
                    }
                }
            }
            if (y-1>=0){
                int neighbor=n*x+y-1;
                for (HashSet<Integer> union:unions){
                    if (union.contains(neighbor)){
                        union4=union;
                        unions.remove(union);
                        break;
                    }
                }
            }
            newUnion.addAll(union1);
            newUnion.addAll(union2);
            newUnion.addAll(union3);
            newUnion.addAll(union4);
            unions.add(newUnion);
            result.add(unions.size());
        }
        return result;
    }
    public static void main(String[] args){
        int[][] test1={{0,0},{0,1},{1,2},{2,1}};
        NumberOfIslandsII noiII=new NumberOfIslandsII();
        System.out.println(noiII.numIslands2(3,3,test1));
    }
}

/*
public class NumberOfIslandsII{

    int[][] dirs = {{0, 1}, {1, 0}, {-1, 0}, {0, -1}};

    public List<Integer> numIslands2(int m, int n, int[][] positions) {
        List<Integer> result = new ArrayList<>();
        if(m <= 0 || n <= 0) return result;

        int count = 0;                      // number of islands
        int[] roots = new int[m * n];       // one island = one tree
        Arrays.fill(roots, -1);

        for(int[] p : positions) {
            int root = n * p[0] + p[1];     // assume new point is isolated island
            roots[root] = root;             // add new island
            count++;

            for(int[] dir : dirs) {
                int x = p[0] + dir[0];
                int y = p[1] + dir[1];
                int nb = n * x + y;
                if(x < 0 || x >= m || y < 0 || y >= n || roots[nb] == -1) continue;

                int rootNb = findIsland(roots, nb);
                if(root != rootNb) {        // if neighbor is in another island
                    roots[root] = rootNb;   // union two islands
                    root = rootNb;          // current tree root = joined tree root
                    count--;
                }
            }

            result.add(count);
        }
        return result;
    }

    public int findIsland(int[] roots, int id) {
        while(id != roots[id]) id = roots[id];
        return id;
    }
    public static void main(String[] args){
        int[][] test1=new int[4][];
        int [] test10={0,0};
        int [] test11={0,1};
        int [] test12={1,2};
        int [] test13={2,1};
        test1[0]=test10;test1[1]=test11;test1[2]=test12;test1[3]=test13;
        NumberOfIslandsII noiII=new NumberOfIslandsII();
        System.out.println(noiII.numIslands2(3,3,test1));


    }
}
*/