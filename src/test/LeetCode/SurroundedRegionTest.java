package test.LeetCode;

import LeetCode.SurroundedRegion;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;

import static org.junit.Assert.assertEquals;


/**
 * Created by ben on 8/24/16.
 */
public class SurroundedRegionTest {
/*

    //These tests is for the code which works but takes too much time

    char[][] testObj1 = {{'X', 'X', 'X', 'X'}, {'X', 'O', 'O', 'X'}, {'X', 'X', 'O', 'X'}, {'O', 'X', 'X', 'X'}};
    HashSet<ArrayList<Integer>> testObj1HashSet = new HashSet<>(testObj1.length * testObj1[0].length);
    LinkedList<ArrayList<Integer>> testObj1LinkedList1=new LinkedList<>();
    char[][] testObj1Flipped = {{'X', 'X', 'X', 'X'}, {'X', 'X', 'X', 'X'}, {'X', 'X', 'X', 'X'}, {'O', 'X', 'X', 'X'}};


    SurroundedRegion sr=new SurroundedRegion();

    @Before
    public void setUp() {
        ArrayList<Integer> p1 = new ArrayList<>();
        p1.add(1);
        p1.add(1);
        ArrayList<Integer> p2 = new ArrayList<>();
        p2.add(1);
        p2.add(2);
        ArrayList<Integer> p3 = new ArrayList<>();
        p3.add(2);
        p3.add(2);
        ArrayList<Integer> p4 = new ArrayList<>();
        p4.add(3);
        p4.add(0);
        testObj1HashSet.add(p1);
        testObj1HashSet.add(p2);
        testObj1HashSet.add(p3);
        testObj1HashSet.add(p4);

        testObj1LinkedList1.add(p1);
        testObj1LinkedList1.add(p2);
        testObj1LinkedList1.add(p3);

    }


    @Test
    public void testAddToSet(){

        assertEquals(testObj1HashSet,sr.addToSet(testObj1));
    }

    @Test
    public void testBFS1() {
        ArrayList<Integer> testObj1Node1 = new ArrayList<>();
        testObj1Node1.add(1);
        testObj1Node1.add(1);
        testObj1HashSet.remove(testObj1Node1);
        assertEquals(new HashSet<ArrayList<Integer>>(testObj1LinkedList1), new HashSet<ArrayList<Integer>>(sr.bfs(testObj1Node1, testObj1, testObj1HashSet)));
    }

    @Test
    public void testBFS2() {
        ArrayList<Integer> testObj1Node2 = new ArrayList<>();
        testObj1Node2.add(3);
        testObj1Node2.add(0);
        testObj1HashSet.remove(testObj1Node2);
        assertEquals(null, sr.bfs(testObj1Node2, testObj1, testObj1HashSet));
    }

    @Test
    public void testBFS3() {
       ArrayList<Integer> testObj1Node3=new ArrayList<>();
       testObj1Node3.add(2);testObj1Node3.add(2);
        testObj1HashSet.remove(testObj1Node3);
        assertEquals(new HashSet<ArrayList<Integer>>(testObj1LinkedList1),new HashSet<ArrayList<Integer>>(sr.bfs(testObj1Node3,testObj1,testObj1HashSet)));
    }



    @Test
    public void testFlipBoard(){
        LinkedList<LinkedList<ArrayList<Integer>>> testObj1SurroundedRegion=new LinkedList<>();
        testObj1SurroundedRegion.add(testObj1LinkedList1);
        assertEquals(testObj1Flipped,sr.flipBoard(testObj1,testObj1SurroundedRegion));
    }

    @Test
    public void testSolve(){
        sr.solve(testObj1);
        assertEquals(testObj1Flipped,testObj1);
    }


*/


}
