import java.util.*;

public class prefixSums<E> extends LinkedList<Integer>{
    
    public void prefixSums(){
        ListIterator <Integer> li = this.listIterator();
        int prefixsum = 0;
        String output = "";
        while(li.hasNext()){
            prefixsum += (int) li.next();
            output += prefixsum+ ", ";
        }
        output =output.substring(0,output.length()-2);
        System.out.println(output);
    }

    public void reversePrefixSums(){
        Iterator li = this.descendingIterator();
        int prefixsum = 0;
        String output = "";
        while(li.hasNext()){
            prefixsum += (int) li.next();
            output += prefixsum+ ", ";
        }
        output =output.substring(0,output.length()-2);
        System.out.println(output);
    }

    public static void main(String[] args) {
        prefixSums<Integer> driver = new prefixSums<Integer>();
        driver.add(5);
        driver.add(3);
        driver.add(2);
        driver.add(9);
        driver.add(3);
        driver.add(15);
        driver.add(22);
        driver.prefixSums();
        driver.reversePrefixSums();
    }
}
