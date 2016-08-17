package LeetCode;

/**
 * Created by ben on 5/25/16.
 */


/**
 * 207.
 * There are a total of n courses you have to take, labeled from 0 to n - 1.

 Some courses may have prerequisites, for example to take course 0 you have to first take course 1,
 which is expressed as a pair: [0,1]

 Given the total number of courses and a list of prerequisite pairs, is it possible for you to finish all courses?

 For example:

 2, [[1,0]]
 There are a total of 2 courses to take. To take course 1 you should have finished course 0. So it is possible.

 2, [[1,0],[0,1]]
 There are a total of 2 courses to take. To take course 1 you should have finished course 0,
 and to take course 0 you should also have finished course 1. So it is impossible.

 Note:
 The input prerequisites is a graph represented by a list of edges, not adjacency matrices.
 Read more about how a graph is represented.

 */

import java.util.*;

public class CourseSchedule {
    private List<LinkedList<Integer>> adjList;
    private enum NodeColor{
        Grey,White,Black
    };
    NodeColor[] nodeColorArr;
    Boolean result=true;

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        this.buildAdjList(numCourses,prerequisites);
        nodeColorArr=new NodeColor[numCourses];
        for (int i=0;i<numCourses;i++){
            nodeColorArr[i]=NodeColor.White;
        }

        for (int i=0;i<numCourses && result!=false  && nodeColorArr[i]==NodeColor.White; i++) {
            dfsVisit(i);
        }

        return result;
    }

    private void dfsVisit(int nodeNum){
        nodeColorArr[nodeNum]=NodeColor.Grey;
        LinkedList<Integer> adj=adjList.get(nodeNum);
        Iterator<Integer> itr=adj.iterator();
        while(itr.hasNext() && result!=false){
            int num=itr.next();
            if(nodeColorArr[num]==NodeColor.Grey){
                result=false;
                return;
            }
            else if (nodeColorArr[num]==NodeColor.White){
                dfsVisit(num);
            }
        }
        nodeColorArr[nodeNum]=NodeColor.Black;
    }



    private void buildAdjList(int numCourses, int[][] prerequisites){
        adjList=new ArrayList<>();
        for (int i=0;i<numCourses;i++){
            adjList.add(new LinkedList<>());
        }
        for (int i=0;i<prerequisites.length;i++){
            (adjList.get(prerequisites[i][0])).add(prerequisites[i][1]);
        }
    }


    public static void main(String[] args){
        // Test for buildAdjList
        CourseSchedule cs1=new CourseSchedule();
        int[][] p1={{0,1},{1,2},{1,0}};
        cs1.buildAdjList(3,p1);
        List<LinkedList<Integer>>r=new ArrayList<>();
        r.add(new LinkedList<>()); (r.get(0)).add(1);
        r.add(new LinkedList<>()); (r.get(1)).add(2); (r.get(1)).add(0);
        r.add(new LinkedList<>());
        System.out.println(cs1.checkArrayLL(cs1.adjList,r));//Expecting true

        int[][] p2={{0,1}};
        cs1.buildAdjList(2,p2);
        List<LinkedList<Integer>>r2=new ArrayList();
        r2.add(new LinkedList<>());(r2.get(0)).add(1);
        r2.add(new LinkedList<>());
        System.out.println(cs1.checkArrayLL(cs1.adjList,r2));//Expecting true

        //Test for canFinish && dfsVisit
        CourseSchedule cs2=new CourseSchedule();
        int[][] p3={{1,0}};
        System.out.println(cs2.canFinish(2,p3));//Expecting true

        CourseSchedule cs3=new CourseSchedule();
        int[][] p4={{1,0},{0,1}};
        System.out.println(cs3.canFinish(2,p4));//Expecting false

        CourseSchedule cs4=new CourseSchedule();
        int[][] p5={{0,1},{1,2},{2,0},{2,3}};
        System.out.println(cs4.canFinish(4,p5));//Expecting false


        CourseSchedule cs5=new CourseSchedule();
        int[][] p6={{0,1},{1,2},{2,3}};
        System.out.println(cs5.canFinish(4,p6));//Expecting true
    }

    //method for testing buildAdjList
    private boolean checkArrayLL(List<LinkedList<Integer>> a, List<LinkedList<Integer>> b){
        if (a.size()!=b.size()){
            return false;
        }
        for (int i=0;i<a.size();i++){
            if(!(a.get(i)).equals(b.get(i))){
                return false;
            }
        }
        return true;
    }



}
