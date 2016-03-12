package CS5800;

import java.math.BigInteger;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.regex.*;
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

    static final int moduleNumber=(int)(Math.pow(2,16)+Math.pow(2,15))/2;;
    LinkedList<key_count> [] hashTable;

    hw8_1(){
        hashTable=new LinkedList[moduleNumber];

    }


    static long hash_fun(String key){
        char [] charAry=key.toCharArray();
        BigInteger hashNum=BigInteger.valueOf(0);
        for (int i=charAry.length-1;i>=0;i--){
            long temp=(long)charAry[i]*(long)Math.pow(16,i);
            hashNum.add(BigInteger.valueOf(temp));
        }
        return hashNum.mod(BigInteger.valueOf(moduleNumber)).intValue();
    }

    void insert(String key){
        int hash_index=(int)hash_fun(key);
        if (hash_index>=moduleNumber || hash_index<0){
            System.out.println(key+" causes wrong index: "+ hash_index);
            return;
        }
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

    key_count find(String key) {
        int hash_index=(int)hash_fun(key);
        LinkedList<key_count> list=hashTable[hash_index];
        if (list==null){
            System.out.println("The key is not in the hash table");
            return null;
        }
        Iterator<key_count> itr=list.descendingIterator();
        while (itr.hasNext()){
            key_count kc=itr.next();
            if (kc.key.equals(key)){
                return kc;
            }
        }
        System.out.println("The key is not in the hash table");
        return null;
    }

    void delete(String key){
        int hash_index=(int)hash_fun(key);
        LinkedList<key_count> list=hashTable[hash_index];
        if (list==null){
            System.out.println("The key is not in the hash table");
            return;
        }
        Iterator<key_count> itr=list.descendingIterator();
        while (itr.hasNext()){
            key_count kc=itr.next();
            if (kc.key.equals(key)){
                itr.remove();
                return;
            }
        }
    }

    void increase(String key){
        int hash_index=(int)hash_fun(key);
        LinkedList<key_count> list=hashTable[hash_index];
        if (list==null){
            System.out.println("The key is not in the hash table");
            return;
        }
        Iterator<key_count> itr=list.descendingIterator();
        while (itr.hasNext()){
            key_count kc=itr.next();
            if (kc.key.equals(key)){
                kc.count++;
                return;
            }
        }

    }

    void scanFile (FileInputStream fin){
        Scanner scan=new Scanner(fin);
        scan.useDelimiter(Pattern.compile("[^a-zA-Z'0-9]"));
        while(scan.hasNext()){
            String str=scan.next().toLowerCase().replaceAll("[^a-z']","");
            str=str.replaceAll("'s","");// example: alice's -> alice
            if(str.equals("")){
                continue;
            }
            this.insert(str);
        }
        scan.close();
    }

    void listAllKeys(PrintWriter fout){
        for (int i=0;i<moduleNumber;i++){
            LinkedList<key_count> list2=hashTable[i];
            if (list2!=null){
                Iterator<key_count> itr2=list2.descendingIterator();
                while(itr2.hasNext()){
                    key_count kc2=itr2.next();
                    fout.println(kc2.key+": "+kc2.count);
                }
            }
        }
    }



    public static void main(String[] args){
        hw8_1 h=new hw8_1();
        FileInputStream fin;
        PrintWriter fout;
        /*
        if (args.length!=2){
            System.out.println("Usage: ShowFile filename");
        }*/

        try{
            fin=new FileInputStream("src/CS5800/test.txt");
            fout=new PrintWriter("src/CS5800/result.txt");
        }catch (FileNotFoundException e){
            System.out.println("Cannot Open File");
            return;
        }

        h.scanFile(fin);


        h.delete("'");

        //Test find function
        /*System.out.println(h.find("alice").count);*/

        //Test increase function
        /*h.increase("alice");*/


        h.listAllKeys(fout);

        try{
            fin.close();
            fout.close();
        }catch(IOException e){
            System.out.println("Error Closing File");
        }

    }

}
