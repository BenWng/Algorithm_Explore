package LeetCode;

/**
 * Created by ben on 8/23/16.
 */


import java.util.*;

/**
 * 130. Surrounded Regions  QuestionEditorial Solution  My Submissions
 Total Accepted: 60612
 Total Submissions: 362446
 Difficulty: Medium
 Given a 2D board containing 'X' and 'O' (the letter O), capture all regions surrounded by 'X'.

 A region is captured by flipping all 'O's into 'X's in that surrounded region.

 For example,
 X X X X
 X O O X
 X X O X
 X O X X
 After running your function, the board should be:

 X X X X
 X X X X
 X X X X
 X O X X
 */

//ToDo: the following code works, but still too slow, should try DFS instead.

public class SurroundedRegion{
    public void solve(char[][] board) {
        if (board!=null && board.length!=0) {
            LinkedList<ArrayList<Integer>> oSet = addToQueue(board);
            flip(oSet,board);
            check(board);
        }
    }



    //Add those 'O' at edges to the queue
    public LinkedList<ArrayList<Integer>> addToQueue(char[][] board){
        LinkedList<ArrayList<Integer>> queue =new LinkedList<>();
        //Edge1
        for (int i=0;i<board.length;i++){
            if( board[i][0]=='O'){
                ArrayList <Integer>NodeOne=new ArrayList<>();
                NodeOne.add(i);NodeOne.add(0);
                queue.add(NodeOne);
            }
        }
        for (int i=0;i<board.length;i++){
            if( board[i][board[0].length-1]=='O'){
                ArrayList <Integer>NodeTwo=new ArrayList<>();
                NodeTwo.add(i);NodeTwo.add(board[0].length-1);
                queue.add(NodeTwo);
            }
        }
        for (int i=0;i<board[0].length;i++){
            if( board[0][i]=='O'){
                ArrayList <Integer>NodeThree=new ArrayList<>();
                NodeThree.add(0);NodeThree.add(i);
                queue.add(NodeThree);
            }
        }
        for (int i=0;i<board[0].length;i++){
            if( board[board.length-1][i]=='O'){
                ArrayList <Integer>NodeFour=new ArrayList<>();
                NodeFour.add(board.length-1);NodeFour.add(i);
                queue.add(NodeFour);
            }
        }
        return queue;
    }
    //BFS, change all the 'O' connected to those 'O' at edges to 'F'
    public void flip(LinkedList<ArrayList<Integer>> queue, char[][]board){
        while(!queue.isEmpty()) {
            ArrayList<Integer> node = queue.poll();
            int xDim = node.get(0);
            int yDim = node.get(1);
            board[xDim][yDim] = 'F';
            if (xDim >= 0 && xDim < board.length - 1) {
                if (board[xDim + 1][yDim] == 'O') {
                    ArrayList<Integer> possibleNode = new ArrayList<>();
                    possibleNode.add(xDim + 1);
                    possibleNode.add(yDim);
                    queue.add(possibleNode);
                    board[xDim + 1][yDim] = 'F';
                }
            }
            if (xDim > 0 && xDim <= board.length - 1) {
                if (board[xDim - 1][yDim] == 'O') {
                    ArrayList<Integer> possibleNode = new ArrayList<>();
                    possibleNode.add(xDim - 1);
                    possibleNode.add(yDim);
                    queue.add(possibleNode);
                    board[xDim - 1][yDim] = 'F';
                }
            }
            if (yDim >= 0 && yDim < board[0].length - 1) {
                if (board[xDim][yDim + 1] == 'O') {
                    ArrayList<Integer> possibleNode = new ArrayList<>();
                    possibleNode.add(xDim);
                    possibleNode.add(yDim + 1);
                    queue.add(possibleNode);
                    board[xDim][yDim + 1] = 'F';
                }
            }
            if (yDim > 0 && yDim <= board[0].length - 1) {
                if (board[xDim][yDim - 1] == 'O') {
                    ArrayList<Integer> possibleNode = new ArrayList<>();
                    possibleNode.add(xDim);
                    possibleNode.add(yDim - 1);
                    queue.add(possibleNode);
                    board[xDim][yDim - 1] = 'F';
                }
            }

        }
    }
    //Flip every 'F' to 'O', every 'O' to 'X'
    public void check (char[][] board){
        for (int i=0;i<board.length;i++){
            for (int j=0;j<board[0].length;j++){
                if(board[i][j]=='F'){
                    board[i][j]='O';
                }
                else if(board[i][j]=='O'){
                    board[i][j]='X';
                }
            }
        }
    }
    public static void main(String[] args){
        char[][] testObj1 = {{'X', 'X', 'X', 'X'}, {'X', 'O', 'O', 'X'}, {'X', 'X', 'O', 'X'}, {'O', 'X', 'X', 'X'}};
        SurroundedRegion sr=new SurroundedRegion();
        char[][] testObj2={{'X','X','X'},{'X','O','X'},{'X','X','X'}};
        char[][] testObj3={{'O','O'},{'O','O'}};
        char[][] testObj4={{'O','X','O'},{'X','O','X'},{'O','X','O'}};

        sr.solve(testObj1);
        sr.solve(testObj2);
        sr.solve(testObj3);
        sr.solve(testObj4);
    }
}


/*
//This method works, but takes too long

public class SurroundedRegion {
    public void solve(char[][] board) {
        if (board!=null && board.length!=0) {
            HashSet<ArrayList<Integer>> oSet = addToSet(board);
            LinkedList<LinkedList<ArrayList<Integer>>> surroundedRegion = findSurroundedRegion(board, oSet);
            flipBoard(board, surroundedRegion);
        }
    }
    public  HashSet<ArrayList<Integer>> addToSet(char [][] board){
        HashSet<ArrayList<Integer>> oStorage=new HashSet<>(board.length*board[0].length);
        for (int i=0;i<board.length;i++){
            for (int j=0;j<board[0].length;j++){
                if(board[i][j]=='O'){
                    ArrayList<Integer> oNode=new ArrayList<>(2);
                    oNode.add(i);
                    oNode.add(j);
                    oStorage.add(oNode);
                }
            }
        }
        return oStorage;
    }

    //Return a LinkedList of LinkedList, each LinkedList is a region surrounded by X
    public LinkedList<LinkedList<ArrayList<Integer>>> findSurroundedRegion(char [][] board,HashSet<ArrayList<Integer>> oStorage){
        LinkedList<LinkedList<ArrayList<Integer>>>result=new LinkedList<>();
        while(!oStorage.isEmpty()){
            Iterator<ArrayList<Integer>> itr=oStorage.iterator();
            ArrayList<Integer> currentNode=itr.next();
            oStorage.remove(currentNode);
            LinkedList<ArrayList<Integer>> surroundedRegion=bfs(currentNode,board,oStorage);
            if(surroundedRegion!=null && !surroundedRegion.isEmpty()){
                result.add(surroundedRegion);
            }
        }
        return result;
    }
    //Do a BFS on currentNode(a parameter)
    public LinkedList<ArrayList<Integer>> bfs(ArrayList<Integer>currentNode, char [][] board,HashSet<ArrayList<Integer>> oStorage){
        boolean isAtEdge=false; //if any of the node is at edge, then this becomes true
        Queue<ArrayList<Integer>> queue=new LinkedList<>();
        LinkedList<ArrayList<Integer>> region=new LinkedList<>();
        region.add(currentNode);
        queue.add(currentNode);
        while(!queue.isEmpty()){
            ArrayList<Integer> node =queue.poll();
            int xDim=node.get(0);
            int yDim=node.get(1);
            if (xDim==board.length-1 || xDim==0 || yDim==board[0].length-1 || yDim==0){
                isAtEdge=true;
            }
            if (xDim>=0 && xDim<board.length-1){
                if (board[xDim+1][yDim]=='O'){
                    ArrayList<Integer> possibleNode=new ArrayList<>();
                    possibleNode.add(xDim+1);
                    possibleNode.add(yDim);
                    if (xDim==board.length-1 || xDim==0 || yDim==board[0].length-1 || yDim==0){
                        isAtEdge=true;
                    }
                    if(oStorage.contains(possibleNode)){
                        oStorage.remove(possibleNode);
                        region.add(possibleNode);
                        queue.add(possibleNode);
                    }
                }
            }
            if (xDim>0 && xDim<=board.length-1){
                if (board[xDim-1][yDim]=='O'){
                    ArrayList<Integer> possibleNode=new ArrayList<>();
                    possibleNode.add(xDim-1);
                    possibleNode.add(yDim);
                    if (xDim==board.length-1 || xDim==0 || yDim==board[0].length-1 || yDim==0){
                        isAtEdge=true;
                    }
                    if(oStorage.contains(possibleNode)){
                        oStorage.remove(possibleNode);
                        region.add(possibleNode);
                        queue.add(possibleNode);
                    }
                }
            }
            if (yDim>=0 && yDim<board[0].length-1){
                if (board[xDim][yDim+1]=='O'){
                    ArrayList<Integer> possibleNode=new ArrayList<>();
                    possibleNode.add(xDim);
                    possibleNode.add(yDim+1);
                    if (xDim==board.length-1 || xDim==0 || yDim==board[0].length-1 || yDim==0){
                        isAtEdge=true;
                    }
                    if(oStorage.contains(possibleNode)){
                        oStorage.remove(possibleNode);
                        region.add(possibleNode);
                        queue.add(possibleNode);
                    }
                }
            }
            if (yDim>0 && yDim<=board[0].length-1){
                if (board[xDim][yDim-1]=='O'){
                    ArrayList<Integer> possibleNode=new ArrayList<>();
                    possibleNode.add(xDim);
                    possibleNode.add(yDim-1);
                    if (xDim==board.length-1 || xDim==0 || yDim==board[0].length-1 || yDim==0){
                        isAtEdge=true;
                    }
                    if(oStorage.contains(possibleNode)){
                        oStorage.remove(possibleNode);
                        region.add(possibleNode);
                        queue.add(possibleNode);
                    }
                }
            }
        }
        if (isAtEdge==true){
            return null;
        }
        else {
            return region;
        }
    }
    //flip the board based on which region is surrounded
    public char [][] flipBoard(char[][] board, LinkedList<LinkedList<ArrayList<Integer>>> surroundedRegion){
        char [][] flipped=board;
        Iterator<LinkedList<ArrayList<Integer>>> outsideIterator=surroundedRegion.iterator();
        while(outsideIterator.hasNext()){
            LinkedList<ArrayList<Integer>> oneRegion=outsideIterator.next();
            Iterator<ArrayList<Integer>> insideIterator=oneRegion.iterator();
            while(insideIterator.hasNext()){
                ArrayList<Integer> node=insideIterator.next();
                int xPos=node.get(0);
                int yPos=node.get(1);
                board[xPos][yPos]='X';
                flipped[xPos][yPos]='X';
            }
        }
        return flipped;
    }
    public static void main(String[] args){
        char[][] testObj1 = {{'X', 'X', 'X', 'X'}, {'X', 'O', 'O', 'X'}, {'X', 'X', 'O', 'X'}, {'O', 'X', 'X', 'X'}};
        SurroundedRegion sr=new SurroundedRegion();
        char[][] testObj2={{'X','X','X'},{'X','O','X'},{'X','X','X'}};
        char[][] testObj3={{'O','O'},{'O','O'}};
        char[][] testObj4={{'O','X','O'},{'X','O','X'},{'O','X','O'}};

        sr.solve(testObj1);
        sr.solve(testObj2);
        sr.solve(testObj3);
        sr.solve(testObj4);
    }
}
*/