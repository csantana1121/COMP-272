import java.io.*;
import java.util.*;

 
// A class to represent a disjoint set
class DisjointSet
{
    private Map<Integer, Integer> parent = new HashMap<>();
 
    // perform MakeSet operation
    public void makeSet(int[] universe)
    {
        // create `n` disjoint sets (one for each item)
        for (int i: universe) {
            parent.put(i, i);
        }
    }
 
    // Find the root of the set in which element `k` belongs
    public int Find(int k)
    {
        // if `k` is root
        if (parent.get(k) == k) {
            return k;
        }
 
        // recur for the parent until we find the root
        return Find(parent.get(k));
    }
 
    // Perform Union of two subsets
    public void Union(int a, int b)
    {
        // find the root of the sets in which elements `x` and `y` belongs
        int x = Find(a);
        int y = Find(b);
 
        parent.put(x, y);
    }
}
 
class Main
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

    // Disjoint–Set data structure (Union–Find algorithm)
    public static void main(String[] args)
    {
        // universe of items
        int[] universe = { 1, 2, 3, 4, 5 };
 
        // initialize `DisjointSet` class
        DisjointSet ds = new DisjointSet();
 
        // create a singleton set for each element of the universe
        ds.makeSet(universe);
        printSets(universe, ds);
 
        ds.Union(4, 3);        // 4 and 3 are in the same set
        printSets(universe, ds);
 
        ds.Union(2, 1);        // 1 and 2 are in the same set
        printSets(universe, ds);
 
        ds.Union(1, 3);        // 1, 2, 3, 4 are in the same set
        printSets(universe, ds);
        countSets(universe, ds);
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
        universe = new int[max+1];
        for(int i = 0;i<max+1;i++)
            universe[i] = i;
        ds = new DisjointSet();
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
