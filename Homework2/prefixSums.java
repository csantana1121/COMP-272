import java.util.*;

public class prefixSums{
    
    public void prefixSums(LinkedList<Integer> input){
        int prefixsum = 0;
        if(input.isEmpty()){
            System.out.println(prefixsum);
            return;
        }
        ListIterator <Integer> li = input.listIterator();
        String output = "";
        while(li.hasNext()){
            prefixsum += (int) li.next();
            output += prefixsum+ ", ";
        }
        output =output.substring(0,output.length()-2);
        System.out.println(output);
    }

    public void reversePrefixSums(LinkedList<Integer> input){
        int prefixsum = 0;
        if(input.isEmpty()){
            System.out.println(prefixsum);
            return;
        }
        Iterator li = input.descendingIterator();
        String output = "";
        while(li.hasNext()){
            prefixsum += (int) li.next();
            output += prefixsum+ ", ";
        }
        output =output.substring(0,output.length()-2);
        System.out.println(output);
    }

    public static void main(String[] args) {
        prefixSums driver = new prefixSums();
        LinkedList<Integer> test = new LinkedList<Integer>();
        LinkedList<Integer> empty = new LinkedList<Integer>();
        test.add(5);
        test.add(3);
        test.add(2);
        test.add(9);
        test.add(3);
        test.add(15);
        test.add(22);
        driver.prefixSums(test);
        driver.reversePrefixSums(test);
        driver.prefixSums(empty);
        driver.reversePrefixSums(empty);
    }
}
