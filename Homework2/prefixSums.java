import java.util.*;

public class prefixSums{
    
    public void prefixSums(LinkedList<Integer> input){
        ListIterator <Integer> li = input.listIterator();
        int prefixsum = 0;
        String output = "";
        while(li.hasNext()){
            prefixsum += (int) li.next();
            output += prefixsum+ ", ";
        }
        output =output.substring(0,output.length()-2);
        System.out.println(output);
    }

    public void reversePrefixSums(LinkedList<Integer> input){
        Iterator li = input.descendingIterator();
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
        prefixSums driver = new prefixSums();
        LinkedList<Integer> test = new LinkedList<Integer>();
        test.add(5);
        test.add(3);
        test.add(2);
        test.add(9);
        test.add(3);
        test.add(15);
        test.add(22);
        driver.prefixSums(test);
        driver.reversePrefixSums(test);
    }
}
