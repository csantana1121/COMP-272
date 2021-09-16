import java.util.*;
public class ExtLinkedList<E> extends LinkedList<E>{
    public ExtLinkedList <E> secondHalfList(){
        ExtLinkedList <E> secondhalf = new ExtLinkedList<E>();
        int size = this.size();
        int midpoint;
        if (size%2 == 0)
            midpoint = size / 2;
        else
            midpoint = (size / 2)+1; 
        for (int i = midpoint; i < size; i++){
            secondhalf.add(this.get(i));
        }
        return secondhalf; 
    }

    public ExtLinkedList <E> oddList(){
        ExtLinkedList <E> oddindexs = new ExtLinkedList<E>();
        int size = this.size();
        for (int i = 0; i < size;i++){
            if ( i % 2 != 0)
                oddindexs.add(this.get(i));
        }
        return oddindexs;
    }

    public ExtLinkedList <E> evenList(){
        return null;
    }
    public static void main(String[] args) {
        ExtLinkedList<Integer> test = new ExtLinkedList<Integer>();
        ExtLinkedList<String> empty = new ExtLinkedList<String>();
        test.add(1);
        test.add(2);
        test.add(3);
        test.add(4);
        test.add(5);
        //test.add(6); //comment in and out for even and odd number list
        ExtLinkedList second = test.secondHalfList();
        ExtLinkedList secondempty = empty.secondHalfList();
        System.out.println(test);
        System.out.println(second);
        System.out.println(secondempty);
        ExtLinkedList oddindexes = test.oddList();
        ExtLinkedList oddempty = empty.oddList();
        System.out.println(oddindexes);
        System.out.println(oddempty);

    }
}
