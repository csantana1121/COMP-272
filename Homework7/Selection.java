
import java.util.*;

public class Selection <E extends Comparable<E>> {
    int k;
    ArrayList<E> input ; // this holds the values of type E from which your code will find kth largest.
    // constructors
    public Selection(){
        input = new ArrayList<E>();
    }
    // algorithm 1 methods -- implement 1B
    public E OneB(int k, List<E> inp){
        ArrayList<E> arr = new ArrayList<>();
        // E[] arr =  new E[k];
        for(int i = 0;i<k;i++){
            arr.add(inp.get(i));
        }
        Collections.sort(arr);
        System.out.println(arr);
        for(int i = k; i<inp.size();i++){
            E newval = inp.get(i);
            if(newval.compareTo(arr.get(0))> 0){
                arr.remove(0);
                arr.add(newval);
                Collections.sort(arr);
            }
        }
        return arr.get(0);
        //read k elements into an array and then sort read the rest of the inputs 
    }
    // algorithm 2 methods -- 6A -- change the algorithm to do kth largest not kth smallest that is described here
    public E SixA(int k, List<E> input){
        MaxHeap<E> heaper = new MaxHeap<>();
        heaper.buildHeap(input);
        for(int i = 0; i<k-1;i++){
            heaper.removeHeap();
        }
        return heaper.removeHeap();
    }
    // algorithm 3 methods – 6B

    public E SixB(int k, List<E> input){
        PriorityQueue<E> pq = new PriorityQueue<E>();
        for(int i = 0;i<k;i++){
            pq.add(input.get(i));
        }
        for(int i = k;i<input.size();i++){
            E newval = input.get(i);
            if(newval.compareTo(pq.peek())> 0){
                pq.poll();
                pq.add(newval);
            }
        }
        return pq.poll();

    }
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
        Selection<Integer> driver = new Selection<>();
        System.out.println(driver.OneB(4, inp));
        System.out.println(driver.SixA(4, inp));
        System.out.println(driver.SixB(4, inp));
    }
    }