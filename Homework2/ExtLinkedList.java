import java.util.*;
public class ExtLinkedList<E> extends LinkedList<E>{
    public ExtLinkedList <E> secondHalfList(){
        ExtLinkedList <E> secondhalf = new ExtLinkedList<E>();
        int size = this.size();
        int midpoint;
        if (size%2 == 0){
            midpoint = size / 2;
        }else{
            midpoint = (size / 2)+1; 
        }
        for (int i = midpoint; i < size; i++){
            secondhalf.add(this.get(i));
        }
        return secondhalf; 
    }

    public ExtLinkedList <E> oddList(){
        return null;
    }

    public ExtLinkedList <E> evenList(){
        return null;
    }
    public static void main(String[] args) {
        ExtLinkedList<Integer> test = new ExtLinkedList<Integer>();
        test.add(1);
        test.add(2);
        test.add(3);
        test.add(4);
        test.add(5);
        //test.add(6); //comment in and out for even and odd number list
        ExtLinkedList second = test.secondHalfList();
        System.out.println(test);
        System.out.print(second);
    }
}
