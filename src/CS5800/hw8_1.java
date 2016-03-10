package CS5800;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.regex.
import java.io.*;


/**
 * Created by Ben_Big on 3/10/16.
 */
class key_count{
    String key;
    int count;
    key_count(String k){
        key=k;
        count=1;
    }
}

public class hw8_1 {

    static final int moduleNumber=(int)(Math.pow(2,16)+Math.pow(2,15))/2;

    LinkedList<key_count> [] hashTable=new LinkedList[moduleNumber];


    static int hash_fun(String key){
        char [] charAry=key.toCharArray();
        long hashNum=0;
        for (int i=charAry.length-1;i>=0;i--){
            hashNum=hashNum+(int)charAry[i]*(int)Math.pow(128,i);
        }
        return (int)hashNum%moduleNumber;
    }

    void insert(String key){
        int hash_index=hash_fun(key);
        LinkedList<key_count> list=hashTable[hash_index];
        if (list==null){
            list=new LinkedList<>();
            hashTable[hash_index]=list;
        }
        Iterator<key_count> itr=list.descendingIterator();
        boolean contained=false;
        while (itr.hasNext()){
                key_count kc=itr.next();
                if (kc.key.equals(key)){
                    kc.count++;
                    contained=true;
                }
        }
        if (contained==false){
            list.add(new key_count(key));
        }

    }




    public static void main(String[] args){
        hw8_1 h=new hw8_1();
        FileInputStream fin;
        Scanner scan;
        String word;
        /*
        if (args.length!=1){
            Syste.out.println("Usage: ShowFile filename");
        }*/
        try{
            fin=new FileInputStream("src/CS5800/test.txt");
            scan=new Scanner(fin);
        }catch (FileNotFoundException e){
            System.out.println("Cannot Open File");
            return;
        }

       while(scan.hasNext()){
           String str=scan.next().toLowerCase();

           System.out.println(str);
       }

        try{
            fin.close();
        }catch(IOException e){
            System.out.println("Error Closing File");
        }

    }

}
