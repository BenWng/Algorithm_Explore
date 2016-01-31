package LeetCode;
import LeetCode.DataStructures.*;
import java.util.*;

/**
 * Created by ben on 1/14/16.
 */

/*
Clone an undirected graph. Each node in the graph contains a label and a list of its neighbors.


OJ's undirected graph serialization:
Nodes are labeled uniquely.

We use # as a separator for each node, and , as a separator for node label and each neighbor of the node.
As an example, consider the serialized graph {0,1,2#1,2#2,2}.

The graph has a total of three nodes, and therefore contains three parts as separated by #.

First node is labeled as 0. Connect node 0 to both nodes 1 and 2.
Second node is labeled as 1. Connect node 1 to node 2.
Third node is labeled as 2. Connect node 2 to node 2 (itself), thus forming a self-cycle.
Visually, the graph looks like the following:

       1
      / \
     /   \
    0 --- 2
         / \
         \_/
 */


/** ToDo: I am not sure how to address the problem of visited.
 *  The data structure does not contain that field.
 */

/** If this question were just about traversal, we could use a HashTable
 * to deal with this.
 *
 * However, this one asks for clone. If B is already cloned, and B
 * is a neighbor of A. After we clone A, we then clone every neighbor
 * of A.
 *
 * Now the problem is there are two copies of B. If we put original one
 * in the Hashtable, how can we add the copied one to A's neighbor list?
 *
 * If we put copied one in the Hashtable, how can we know that B has been
 * cloned already?
 *
 * The solution is to use HashMap, the original copy is the key, the cloned
 * copy is the value.
 */





public class CloneGraph {
    public static UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if (node==null){
            return null;
        }


        LinkedList<UndirectedGraphNode> queue=new LinkedList<>();
        HashMap<UndirectedGraphNode,UndirectedGraphNode> map=new HashMap<>();

        UndirectedGraphNode head=new UndirectedGraphNode(node.label);
        map.put(node,head);

        queue.add(node);

        while(!queue.isEmpty()){
            UndirectedGraphNode current=queue.pop();
            List<UndirectedGraphNode> neighbors=current.neighbors;
            for (UndirectedGraphNode aNeighbor: neighbors){
                if (!map.containsKey(aNeighbor)){
                    UndirectedGraphNode newNeighbor=new UndirectedGraphNode(aNeighbor.label);
                    queue.add(aNeighbor);
                    map.get(current).neighbors.add(newNeighbor);
                    map.put(aNeighbor,newNeighbor);
                }
                else{
                    map.get(current).neighbors.add(map.get(aNeighbor));
                }
            }
        }
        return head;
    }
    public static void main(String[] args){
        UndirectedGraphNode node0=new UndirectedGraphNode(0);

        UndirectedGraphNode node1=new UndirectedGraphNode(1);
        UndirectedGraphNode node2=new UndirectedGraphNode(2);

        node0.neighbors.add(node1);
        node0.neighbors.add(node2);

        node1.neighbors.add(node2);

        node2.neighbors.add(node2);

        UndirectedGraphNode clonedNode=cloneGraph(node0);


    }
}
