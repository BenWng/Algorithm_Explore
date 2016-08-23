package test.LeetCode;

import LeetCode.HIndex;
import org.junit.Test;
import static org.junit.Assert.assertEquals;



/**
 * Created by Ben_Big on 8/23/16.
 */
public class HIndexTest {
    @Test
    public void testResult(){
        HIndex hi=new HIndex();
        int[] testCase1={3,0,6,1,5};
        int testCase1Result=3;
        assertEquals(testCase1Result,hi.hIndex(testCase1));

        int[] testCase2={0,0,0};
        int testCase2Result=0;
        assertEquals(testCase2Result,hi.hIndex(testCase2));

        int[] testCase3={0};
        int testCase3Result=0;
        assertEquals(testCase3Result,hi.hIndex(testCase3));


        int[] testCase4={8};
        int testCase4Result=1;
        assertEquals(testCase4Result,hi.hIndex(testCase4));

        int[] testCase5={0,7,8};
        int testCase5Result=2;
        assertEquals(testCase5Result,hi.hIndex(testCase5));

    }
}
