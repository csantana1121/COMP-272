import java.util.*;
public class MaxHeap<E extends Comparable<E>> extends ArrayList<E>   {
    // construct an empty Heap using ArrayList
    // with root at index 0.
    // don't use binary tree for implementing the heap.
    ArrayList<E> arr;

    public MaxHeap(){
            arr = new ArrayList<E>();
    }
    // returns max value
    public E findMax() {
        if(arr.size() == 0){
            throw new NoSuchElementException();
        } else
            return arr.get(0);
    }
    
    // adds a new value to the heap at the end of the Heap and 
    // adjusts values up to the root to ensure Max heap property is satisfied.
    // parent of node at i is given by the formula (i-1)/2
    // throw appropriate exception
    public void addHeap(E val) {
        arr.add(val);
        int child  = arr.size() - 1;

        while(child > 0){
            int parent = (child-1)/2;
            E c = arr.get(child);
            E p = arr.get(parent);
            if(c.compareTo(p)>0){
                arr.set(child, p);
                arr.set(parent,c);
                child = parent;
            } else
                child = 0;
        }
    }
    
    //returns the max value at the root of the heap by swapping the last value 
    // and percolating the value down from the root to preserve max heap property
    // children of node at i are given by the formula 2i+1,2i+2, to not exceed the
    // bounds of the Heap index, namely, 0 ... size()-1.
    // throw appropriate exception
    public E removeHeap() {
        if(arr.size() == 0){
            throw new NoSuchElementException();
        } else if (arr.size() == 1) {
            return arr.remove(0);
        } else{
            E temp = arr.get(0);
            arr.set(0, arr.remove(arr.size()-1));
            //siftDown();
            return temp;
        }
    }
    
    // takes a list of items E and builds the heap and then prints 
    // decreasing values of E with calls to removeHeap().  
    public void heapSort(List<E> list){
        
    }
    
    // merges the other maxheap with this maxheap to produce a new maxHeap.  
    public void heapMerge(MaxHeap<E> other){
        
    }
    
    //takes a list of items E and builds the heap by calls to addHeap(..)
    public void buildHeap(List<E> list) {
        
    }

    public static void main(String[] args) {
        MaxHeap<Integer> heaper = new MaxHeap<>();
        heaper.addHeap(10);
        System.out.println("max:" + heaper.removeHeap());
        heaper.addHeap(13);
        heaper.addHeap(1);
        heaper.addHeap(321);
        heaper.addHeap(43);
        heaper.addHeap(8);
        heaper.addHeap(1);
        System.out.println(heaper.arr);
    }
    
}