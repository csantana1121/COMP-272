import java.util.*;

public class prefixSums<Integer> extends LinkedList<Integer>{
    
    public void prefixSums(){
        ListIterator <Integer> li = this.listIterator();
        int prefixsum = 0;
        while(li.hasNext()){
            prefixsum + li.next();

        }
    }

    public static void main(String[] args) {
        
    }
}
