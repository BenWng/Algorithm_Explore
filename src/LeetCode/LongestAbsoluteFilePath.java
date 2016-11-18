package LeetCode;

import java.util.*;

/**
 * Created by Ben_Big on 11/18/16.
 */

/*388. Longest Absolute File Path
        Total Accepted: 13320
        Total Submissions: 39626
        Difficulty: Medium
        Contributors: Admin
        Suppose we abstract our file system by a string in the following manner:

        The string "dir\n\tsubdir1\n\tsubdir2\n\t\tfile.ext" represents:

        dir
        subdir1
        subdir2
        file.ext
        The directory dir contains an empty sub-directory subdir1 and a sub-directory subdir2 containing a file file.ext.

        The string "dir\n\tsubdir1\n\t\tfile1.ext\n\t\tsubsubdir1\n\tsubdir2\n\t\tsubsubdir2\n\t\t\tfile2.ext" represents:

        dir
        subdir1
        file1.ext
        subsubdir1
        subdir2
        subsubdir2
        file2.ext
        The directory dir contains two sub-directories subdir1 and subdir2. subdir1 contains a file file1.ext and an empty second-level sub-directory subsubdir1. subdir2 contains a second-level sub-directory subsubdir2 containing a file file2.ext.

        We are interested in finding the longest (number of characters) absolute path to a file within our file system. For example, in the second example above, the longest absolute path is "dir/subdir2/subsubdir2/file2.ext", and its length is 32 (not including the double quotes).

        Given a string representing the file system in the above format, return the length of the longest absolute path to file in the abstracted file system. If there is no file in the system, return 0.

        Note:
        The name of a file contains at least a . and an extension.
        The name of a directory or sub-directory will not contain a ..
        Time complexity required: O(n) where n is the size of the input string.

        Notice that a/aa/aaa/file1.txt is not the longest file path, if there is another path aaaaaaaaaaaaaaaaaaaaa/sth.png.*/

//ToDo: This question's instruction does not quite meet the test code in leetcode
//  cases like dir/n    file.txt is interpreted as two files dir/ and "    file.txt"
// The code lengthLongestPath2 is from leetcode, mine initial idea is basically the same as this one, but my
// implementation is too complicated.

public class LongestAbsoluteFilePath {
    public int lengthLongestPath(String input) {
        int result = 0;
        String[] parts=input.split("\n");
        Deque<Integer> stack=new ArrayDeque<>();
        for (int i=0;i<parts.length;i++){
            if (!parts[i].contains(".")){
                int currentLevel=parts[i].lastIndexOf("\t")+1;
                if (stack.size()<=currentLevel){
                    stack.push(parts[i].length()-currentLevel+1);
                }
                else{
                    while (stack.size()>currentLevel) stack.pop();
                    stack.push(parts[i].length()-currentLevel+1);
                }
            }
            else{
                int currentLevel=parts[i].lastIndexOf("\t")+1;
                while (stack.size()>currentLevel) stack.pop();
                Iterator<Integer> itr=stack.iterator();
                int totalPathLength=parts[i].length()-currentLevel;
                while(itr.hasNext()){
                    int lastLength=itr.next();
                    totalPathLength+=lastLength;
                }
                result=totalPathLength>result?totalPathLength:result;
            }
        }
        return result;
    }
    public int lengthLongestPath2(String input) {
        Deque<Integer> stack = new ArrayDeque<>();
        stack.push(0); // "dummy" length
        int maxLen = 0;
        for(String s:input.split("\n")){
            int lev = s.lastIndexOf("\t")+1; // number of "\t"
            while(lev+1<stack.size()) stack.pop(); // find parent
            System.out.println(s.length());
            int len = stack.peek()+s.length()-lev+1; // remove "/t", add"/"
            stack.push(len);
            // check if it is file
            if(s.contains(".")) maxLen = Math.max(maxLen, len-1);
        }
        return maxLen;
    }
    public static void main(String[] args){
        LongestAbsoluteFilePath lafp=new LongestAbsoluteFilePath();
        System.out.print(lafp.lengthLongestPath("dir\n\tsubdir1\n\tsubdir2\n\t\tfile.ext"));
    }


}
