import java.util.*;
import java.security.*;
import java.io.*;

public class MyHashSet<E> {
    
    ArrayList<LinkedList<String>> hashtable;
    int collisions;
    int tableSize;

    public MyHashSet(int size) {
        hashtable = new ArrayList<LinkedList<String>>(size);
        for( int i = 0; i < size; i++){
            LinkedList list = new LinkedList<>();
            hashtable.add(list);
        }
        collisions = 0;
        tableSize = size;
    }

    public int hashCode(Object key) {
        int h;
        return (key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16);
    }

    public void HashMethod1(String s){
        int h = Math.abs(s.hashCode()) % tableSize;
        LinkedList<String> hold = hashtable.get(h);
        if (hold.size() > 0){
            collisions++;
        }
        hold.add(s);
        hashtable.set(h,hold);
    }

    public void HashMethod2(String s){
        int h = Math.abs(hashCode(s)%tableSize);
        LinkedList<String> hold = hashtable.get(h);
        if (hold.size() > 0){
            collisions++;
        }
        hold.add(s);
        hashtable.set(h, hold);
    }

    public double calavgsize(){
        double avg = 0;
        int size = hashtable.size();
        for(int i = 0; i <tableSize;i++){
            avg += hashtable.get(i).size();
            if (hashtable.get(i).size() == 0){
                size--;
            }
        }
        avg = avg / size;
        return avg;
    }

    public void HashMethod3(String s) {
        byte[] sb=s.getBytes();
        byte[] key=  null;
         try {
         MessageDigest md = MessageDigest.getInstance("SHA-256");
         key=md.digest(sb);
         }
         catch (NoSuchAlgorithmException e) {
         e.printStackTrace();
         }
        BitSet bs = BitSet.valueOf(key);
        StringBuilder str = new StringBuilder();
        for( int i = 0; i < bs.length();  i++ )
        {
            str.append( bs.get( i ) == true ? 1: 0 );
        }
        // System.out.println(bs);
        // System.out.println(str);
        // System.out.println(bs.length());
        // System.out.println(str.length());
        // System.out.println(bs.nextSetBit(2));
        String hashkey = str.substring(2,2) + str.charAt(7) + str.charAt(17) + str.charAt(29) + str.charAt(41) + str.charAt(53) + str.charAt(67) + str.charAt(79) + str.charAt(97) + str.charAt(107) + str.charAt(127) + str.charAt(139) + str.charAt(157) + str.charAt(173) + str.charAt(191) + str.charAt(199) + str.charAt(227);
        try{
           hashkey += str.charAt(239); 
        } catch (StringIndexOutOfBoundsException ex){
            hashkey += "0";
        }
        // hash =  Math.abs(hash % tableSize);
        // System.out.println(hashkey);
        int hash = Integer.parseInt(hashkey, 2);
        LinkedList<String> hold = hashtable.get(hash);
        if (hold.size() > 0){
            collisions++;
        }
        hold.add(s);
        hashtable.set(hash, hold);
        // using the BitSet bs, you will extract 18 bits based on the
        //get() method of BitSet. The 18 bits are extracted at the first
        //18 prime numbers 2, 7,17,29,41,53,67,79,97,107,127,139,157,
        //173,191, 199,227,239. Put the bits together in that //order to
        //form an integer and return it. That will be the hash //value of
        //the key that you can use in the table of size 2^18.
        }
    public static void main(String[] args) {
        MyHashSet<String> method1 = new MyHashSet<>(262127);
        MyHashSet<String> method1large = new MyHashSet<>(524287);
        // System.out.println(method1.tableSize);
        // System.out.println(method1.hashtable.size());
        MyHashSet<String> method2 = new MyHashSet<>(262127);
        MyHashSet<String> method2large = new MyHashSet<>(524287);
        MyHashSet<String> method3 = new MyHashSet<>(262144);
        File text = new File("EnglishWordList.txt");
        HashSet<String> hs = new HashSet<String>();
        try{
            Scanner scanner = new Scanner(text);
            while(scanner.hasNextLine()){
                String word = scanner.nextLine();
                hs.add(word);
        }
        } catch ( FileNotFoundException ex){
            ex.printStackTrace();
        }
        for(String word: hs){
            method1.HashMethod1(word);
            method1large.HashMethod1(word);
            method2.HashMethod2(word);
            method2large.HashMethod2(word);
            method3.HashMethod3(word);
        }
        System.out.println(hs.size());
        System.out.println(method1.collisions);
        System.out.println(method1.calavgsize());
        System.out.println("Method1 x2size " +method1large.collisions);
        System.out.println("Method 1 x2size " + method1large.calavgsize());
        System.out.println("Method 2 " +method2.collisions);
        System.out.println("Method 2 " + method2.calavgsize());
        System.out.println("Method 2 x2size " +method2large.collisions);
        System.out.println("Method 2 x2size " + method2large.calavgsize());
        System.out.println("method 3 " + method3.collisions);
        System.out.println("method 3 " + method3.calavgsize());
    }
}