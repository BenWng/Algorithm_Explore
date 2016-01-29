package LeetCode.DataStructures;
import java.util.*;


/**
 * Created by ben on 1/15/16.
 */

//Definition for undirected graph.
class UndirectedGraphNode {
         int label;
         List<UndirectedGraphNode> neighbors;
        UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
};