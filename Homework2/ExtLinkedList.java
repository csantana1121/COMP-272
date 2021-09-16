import java.util.*;
public class ExtLinkedList<E> extends LinkedList<E>{
    public ExtLinkedList <E> secondHalfList(){
        ExtLinkedList <E> secondhalf = new ExtLinkedList<E>();
        int size = this.size();
        int midpoint = size / 2;
        ListIterator new_list = this.listIterator(midpoint);
        // while(new_list.hasNext()){
        //     System.out.println(new_list);
        // }
        return secondhalf; 
    }
    public static void main(String[] args) {
        ExtLinkedList<Integer> test = new ExtLinkedList<Integer>();
        test.add(1);
        test.add(2);
        test.add(3);
        test.add(4);
        test.add(5);
        System.out.println(test);
        ExtLinkedList second = test.secondHalfList();
        System.out.print(second);
    }
}
