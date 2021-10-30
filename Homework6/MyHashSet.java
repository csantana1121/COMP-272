import java.util.*;
import java.security.*;
import java.io.*;

public class MyHashSet<E> {
    
    ArrayList<LinkedList<String>> hashtable;
    int collisions;
    int tableSize;
    int size;

    public MyHashSet(int size) {
        hashtable = new ArrayList<LinkedList<String>>(size);
        collisions = 0;
        tableSize = size;
        size = 0;
    }

    public int hashCode(Object key) {
        int h;
        return (key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16);
    }

    public void HashMethod1(String s){
        int h = Math.abs(s.hashCode() % tableSize);
        if (size >0){
            LinkedList<String> hold = hashtable.get(h);
        // try{
        // } catch (IndexOutOfBoundsException ex){
        //     hold = new LinkedList<>();
        // }
            if (hold.size() > 0){
                collisions++;
            }
            hold.add(s);
            hashtable.add(h, hold);
        } else{
            LinkedList<String> hold = new LinkedList<>();
            hold.add(s);
            hashtable.add(h, hold);
        }
    }

    public void HashMethod2(String s){
        int h = Math.abs(hashCode(s)%tableSize);
        LinkedList<String> hold = hashtable.get(h);
        if (hold.size() > 0){
            collisions++;
        }
        hold.add(s);
        hashtable.add(h, hold);
    }
    public static void main(String[] args) {
        MyHashSet<String> method1 = new MyHashSet<>(262127);
        System.out.println(method1.tableSize);
        System.out.println(method1.hashtable.size());
        MyHashSet<String> method2 = new MyHashSet<>(262127);
        File text = new File("EnglishWordList.txt");
        try{
            Scanner scanner = new Scanner(text);
            while(scanner.hasNextLine()){
                String word = scanner.nextLine();
                System.out.println(word);
                method1.HashMethod1(word);
        }
        } catch ( FileNotFoundException ex){
            ex.printStackTrace();
        }
        System.out.println(method1.collisions);
    }
}