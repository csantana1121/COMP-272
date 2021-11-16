import java.io.*;
import java.util.*;

 
public class DisjointSet
{
    private Map<Integer, Integer> parent = new HashMap<>();
 
    public void makeSet(int[] universe)
    {
        for (int i: universe) {
            parent.put(i, i);
        }
    }
 
    public int Find(int k)
    {
        if (parent.get(k) == k) {
            return k;
        }
 
        return Find(parent.get(k));
    }
 
    public void Union(int a, int b)
    {
        int x = Find(a);
        int y = Find(b);
 
        parent.put(x, y);
    }
}
 
public class Main
{
    public static void printSets(int[] universe, DisjointSet ds)
    {
        for (int i: universe) {
            System.out.print(ds.Find(i) + " ");
        }
 
        System.out.println();
    }
    
    public static void countSets(int[] universe, DisjointSet ds)
    {
        HashSet<Integer> hs = new HashSet<>();
        for (int i: universe) {
            hs.add(ds.Find(i));
        }
 
        System.out.println("Number of connected Components = " + hs.size());
    }

    public static void main(String[] args)
    {
        // // Testing example:
        // int[] universe = { 1, 2, 3, 4, 5 };
 
        // DisjointSet ds = new DisjointSet();
 
        // ds.makeSet(universe);
        // printSets(universe, ds);
 
        // ds.Union(4, 3);      
        // printSets(universe, ds);
 
        // ds.Union(2, 1);       
        // printSets(universe, ds);
 
        // ds.Union(1, 3);        
        // printSets(universe, ds);
        // countSets(universe, ds);
        File text = new File("Email-Enron.txt");
        int max = 0;
        try{
            Scanner scanner = new Scanner(text);
            while(scanner.hasNextLine()){
                String line = scanner.nextLine();
                String[] arrOfStr = line.split("\t");
                for(String val : arrOfStr){
                    if(Integer.parseInt(val) > max){
                        max = Integer.parseInt(val);
                    }
                }
        }
        } catch ( FileNotFoundException ex){
            ex.printStackTrace();
        }
        // System.out.println(max);
        int[] universe = new int[max+1];
        for(int i = 0;i<max+1;i++)
            universe[i] = i;
        DisjointSet ds = new DisjointSet();
        ds.makeSet(universe);
        System.out.println(universe.length);
        System.out.println(universe[36691]);
        try{
            Scanner scanner = new Scanner(text);
            while(scanner.hasNextLine()){
                String line = scanner.nextLine();
                String[] arrOfStr = line.split("\t");
                ds.Union(Integer.parseInt(arrOfStr[0]), Integer.parseInt(arrOfStr[1]));
                // printSets(universe, ds);
        }
        } catch ( FileNotFoundException ex){
            ex.printStackTrace();
        }
        // ds.makeSet(universe);
        // System.out.println("here");
        countSets(universe, ds);
        text = new File("Graph.txt");
        max = 0;
        try{
            Scanner scanner = new Scanner(text);
            while(scanner.hasNextLine()){
                String line = scanner.nextLine();
                String[] arrOfStr = line.split(",");
                for(String val : arrOfStr){
                    if(Integer.parseInt(val) > max){
                        max = Integer.parseInt(val);
                    }
                }
        }
        } catch ( FileNotFoundException ex){
            ex.printStackTrace();
        }
        // System.out.println(max);
        universe = new int[max+1];
        for(int i = 0;i<max+1;i++)
            universe[i] = i;
        ds = new DisjointSet();
        ds.makeSet(universe);
        System.out.println(universe.length);
        try{
            Scanner scanner = new Scanner(text);
            while(scanner.hasNextLine()){
                String line = scanner.nextLine();
                String[] arrOfStr = line.split(",");
                ds.Union(Integer.parseInt(arrOfStr[0]), Integer.parseInt(arrOfStr[1]));
                // printSets(universe, ds);
        }
        } catch ( FileNotFoundException ex){
            ex.printStackTrace();
        }
        // ds.makeSet(universe);
        System.out.println("here");
        countSets(universe, ds);
    }
}
