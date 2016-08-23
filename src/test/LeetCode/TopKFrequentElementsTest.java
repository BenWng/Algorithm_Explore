package test.LeetCode;

import LeetCode.TopKFrequentElements;
import org.junit.Test;
import java.util.LinkedList;
import static org.junit.Assert.assertEquals;

/**
 * Created by ben on 8/22/16.
 */

public class TopKFrequentElementsTest{

    @Test
    public void testResult(){
        int[] testCase1={1,1,1,2,3,4,4,5};
        LinkedList<Integer> testCase1Result=new LinkedList<>();
        testCase1Result.add(1);testCase1Result.add(4);
        int[] testCase2={1};
        LinkedList<Integer> testCase2Result=new LinkedList<>();
        testCase2Result.add(1);
        TopKFrequentElements test=new TopKFrequentElements();
        assertEquals(testCase1Result,test.topKFrequent(testCase1,2));
        assertEquals(testCase2Result,test.topKFrequent(testCase2,1));
    }
}