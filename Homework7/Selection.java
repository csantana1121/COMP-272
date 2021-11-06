import java.util.*;

public class Selection <E extends Comparable<E>> {
    int k;
    ArrayList<E> input ; // this holds the values of type E from which your code will find kth largest.
    // constructors
    public Selection(List<E> list){
        input.addAll(list);
    }
    // algorithm 1 methods -- implement 1B
    public int OneB(int k){
        E[] arr;
        Collections.sort(input);
        for(int i = 0;i<k;i++){
            arr[i] = input.get(i);
        }
        System.out.println(arr);
        return 0;
        //read k elements into an array and then sort read the rest of the inputs 
    }
    // algorithm 2 methods -- 6A -- change the algorithm to do kth largest not kth smallest that is described here
    // algorithm 3 methods – 6B

    public static void main(String[] args) {
        List<Integer> inp = new ArrayList<Integer>();
        inp.add(1);
        inp.add(5);
        inp.add(10);
        inp.add(7);
        inp.add(3);
        inp.add(2);
        inp.add(17);
        inp.add(18);
        Selection<Integer> driver = new Selection<>(inp);
        System.out.println(driver.OneB(4));

    }
    }