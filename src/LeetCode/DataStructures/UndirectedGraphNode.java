package LeetCode.DataStructures;
import java.util.*;


/**
 * Created by ben on 1/15/16.
 */

//Definition for undirected graph.
public class UndirectedGraphNode {
         public int label;
         public List<UndirectedGraphNode> neighbors;
         public UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
};