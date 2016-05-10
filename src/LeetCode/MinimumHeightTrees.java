package LeetCode;

/**
 * Created by ben on 5/7/16.
 */



/**
 * For a undirected graph with tree characteristics, we can choose any node as the root.
 * The result graph is then a rooted tree. Among all possible rooted trees, those with minimum height are called minimum height trees (MHTs). Given such a graph, write a function to find all the MHTs and return a list of their root labels.

 Format
 The graph contains n nodes which are labeled from 0 to n - 1. You will be given the number n and a list of undirected edges (each edge is a pair of labels).

 You can assume that no duplicate edges will appear in edges. Since all edges are undirected, [0, 1] is the same as [1, 0] and thus will not appear together in edges.

 Example 1:

 Given n = 4, edges = [[1, 0], [1, 2], [1, 3]]

 0
 |
 1
 / \
 2   3
 return [1]

 Example 2:

 Given n = 6, edges = [[0, 3], [1, 3], [2, 3], [4, 3], [5, 4]]

 0  1  2
 \ | /
   3
   |
   4
   |
   5
 return [3, 4]
 */



/*
import java.util.*;



public class MinimumHeightTrees {
    int [][] distanceMatrix;
    int [][] adjacencyMatrix;
    int [] maxHeightArray;
    int smallestMaxHeight=1000;

    private void BFS(int s, int n, int[][] edges){
        int maxHeight=0;
        Queue<Integer> Q=new LinkedList<>();
        Q.add(s);
        while (!Q.isEmpty()){
            int x=Q.remove();
            for (int y=0;y<n;y++){
                if (adjacencyMatrix[x][y]==1 && distanceMatrix[s][y]==0 && y!=s){
                    distanceMatrix[s][y]=distanceMatrix[s][x]+1;
                    maxHeight=(distanceMatrix[s][y]>maxHeight) ? distanceMatrix[s][y]:maxHeight;
                    Q.add(y);
                }
            }
        }
        maxHeightArray[s]=maxHeight;
        smallestMaxHeight=(maxHeight<smallestMaxHeight) ?maxHeight:smallestMaxHeight;
    }

    private void setAdjacencyMatrix(int n, int[][]edges){
        adjacencyMatrix=new int[n][n];
        for (int [] e : edges) {
            int x=e[0];
            int y=e[1];
            adjacencyMatrix[x][y]=1;
            adjacencyMatrix[y][x]=1;
        }
    }


    private void printMatrix(int[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                System.out.printf("%4d", matrix[row][col]);
            }
            System.out.println();
        }
    }

    private void printArray(int []arr){
        for (int i=0; i<arr.length; i++){
            System.out.print(arr[i]);
        }
        System.out.println();
    }

    private void printLinkedList(List<Integer> ll){
        Iterator<Integer> itr=ll.iterator();
        while(itr.hasNext()){
            System.out.print(itr.next()+" ");
        }
        System.out.println();
    }

    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
            distanceMatrix=new int[n][n];
            maxHeightArray=new int[n];
            this.setAdjacencyMatrix(n,edges);
            for (int i=0;i<n;i++){
                this.BFS(i,n,edges);
            }
            LinkedList<Integer> temp=new LinkedList<>();
            for (int j=0;j<n;j++){
                if (maxHeightArray[j]==smallestMaxHeight){
                    temp.add(j);
                }
            }
            return temp;
    }

    public static void main(String [] args){

        // To test BFS and setAdjacencyMatrix
        int n=6;
        int[][]edges = {{0, 3}, {1, 3}, {2, 3}, {4, 3}, {5, 4}};
        MinimumHeightTrees test1=new MinimumHeightTrees();
        test1.printLinkedList(test1.findMinHeightTrees(n,edges));
        test1.setAdjacencyMatrix(n,edges);
        test1.printMatrix(test1.adjacencyMatrix);
        System.out.println();
        test1.printMatrix(test1.distanceMatrix);
        System.out.println();
        test1.printArray(test1.maxHeightArray);

    }

}
*/


/** TODO: The above solution is thought of by myself, time is O(V(E+V)), apparently too slow. The following approach is
 * based on the idea from Internet (see Notability).
*/

import java.util.*;

public class MinimumHeightTrees {

    List<HashSet<Integer>> Adjacency=new ArrayList<>();

    //Build the Adjacency structure
    private void setAdjacency(int n, int [][] edges){
        for (int i=0;i<n;i++){
            Adjacency.add(new HashSet<Integer>());
        }

        int numEdges=edges.length;
        for (int i=0;i<numEdges;i++){
            int [] edge=edges[i];
            int from = edge[0];
            int to = edge[1];
            Adjacency.get(from).add(to);
            Adjacency.get(to).add(from);
        }
    }


    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        //corner case
        if(n==1) {
            List result=new ArrayList<>();
            result.add(0);
            return result;
        }


        this.setAdjacency(n,edges);

        int numRemainingNodes = n;

        List<Integer>Leaves=new ArrayList<>();

        //Get all the leaves
        for (int i=0;i<numRemainingNodes;i++){
            if (Adjacency.get(i).size()==1){
                Leaves.add(i);
            }
        }

        //The peeling process
        while(numRemainingNodes>2){
            numRemainingNodes-=Leaves.size();

            List<Integer> newLeaves=new ArrayList<>();

            //Remove all the leaves
            for (int leaf:Leaves){
                int neighbor=Adjacency.get(leaf).iterator().next();//A leaf has only one neighbor

                // Remove the leaf from its neighbor's set
                Adjacency.get(neighbor).remove(leaf);

                //The new leaves are among the neighbors of the former leaves
                if (Adjacency.get(neighbor).size()==1){
                    newLeaves.add(neighbor);
                }
            }
            Leaves=newLeaves;
        }
        return Leaves;
    }

    public static void main(String[] args){
        int n=6;
        int[][]edges = {{0, 3}, {1, 3}, {2, 3}, {4, 3}, {5, 4}};
        MinimumHeightTrees test1=new MinimumHeightTrees();
        System.out.println(test1.findMinHeightTrees(n,edges));
    }
}
