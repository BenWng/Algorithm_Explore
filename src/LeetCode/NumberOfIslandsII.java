package LeetCode;

import java.util.*;

/**
 * Created by Ben_Big on 11/28/16.
 */
public class NumberOfIslandsII {
    public List<Integer> numIslands2(int m, int n, int[][] positions) {
        HashSet<HashSet<Map.Entry<Integer,Integer>>> unions=new HashSet<>();
        List<Integer> result=new ArrayList<>();
        for (int[] pos : positions){
            int x=pos[0];
            int y=pos[1];
            Map.Entry<Integer,Integer> currentPosition=new AbstractMap.SimpleEntry<>(x,y);
            HashSet<Map.Entry<Integer,Integer>> newUnion=new HashSet<>();
            newUnion.add(currentPosition);
            HashSet<Map.Entry<Integer,Integer>> union1=new HashSet<>();
            HashSet<Map.Entry<Integer,Integer>> union2=new HashSet<>();
            HashSet<Map.Entry<Integer,Integer>> union3=new HashSet<>();
            HashSet<Map.Entry<Integer,Integer>> union4=new HashSet<>();
            if (x+1<m){
                Map.Entry<Integer,Integer> neighbor=new AbstractMap.SimpleEntry<>(x+1,y);
                for (HashSet<Map.Entry<Integer,Integer>> union:unions){
                    if (union.contains(neighbor)){
                        union1=union;
                        unions.remove(union);
                    }
                }
            }
            if (x-1>=0){
                Map.Entry<Integer,Integer> neighbor=new AbstractMap.SimpleEntry<>(x-1,y);
                for (HashSet<Map.Entry<Integer,Integer>> union:unions){
                    if (union.contains(neighbor)){
                        union2=union;
                        unions.remove(union);
                    }
                }
            }
            if (y+1<n){
                Map.Entry<Integer,Integer> neighbor=new AbstractMap.SimpleEntry<>(x,y+1);
                for (HashSet<Map.Entry<Integer,Integer>> union:unions){
                    if (union.contains(neighbor)){
                        union3=union;
                        unions.remove(union);
                    }
                }
            }
            if (y-1>=0){
                Map.Entry<Integer,Integer> neighbor=new AbstractMap.SimpleEntry<>(x,y-1);
                for (HashSet<Map.Entry<Integer,Integer>> union:unions){
                    if (union.contains(neighbor)){
                        union4=union;
                        unions.remove(union);
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