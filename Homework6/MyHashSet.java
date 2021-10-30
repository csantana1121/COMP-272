import java.util.*;
import java.security.*;
import java.io.*;

public class MyHashSet<E> {
    
    ArrayList<LinkedList<String>> hashtable;

    public MyHashSet(int size) {
        hashtable = new ArrayList<LinkedList<String>>(size);
    }

    public int hashCode(Object key) {
        int h;
        return (key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16);
    }

    public void HashMethod1(String s){
        int h = Math.abs(s.hashCode()) % hashtable.size();
        LinkedList<String> hold = hashtable.get(h);
        hold.add(s);
        hashtable.add(h, hold);
    }

    public void HashMethod2(String s){
        int h = Math.abs(hashCode(s)%hashtable.size());
        LinkedList<String> hold = hashtable.get(h);
        hold.add(s);
        hashtable.add(h, hold);
    }
    public static void main(String[] args) {
        MyHashSet<String> method1 = new MyHashSet<>(262127);
        MyHashSet<String> method2 = new MyHashSet<>(262127);
        File text = new File("EnglishWordList.txt");
        Scanner scanner = new Scanner(text);
        while(scanner.hasNextLine()){
            System.out.println(scanner.nextLine());
        }
    }
}