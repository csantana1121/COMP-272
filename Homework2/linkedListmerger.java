import java.util.*;

public class linkedListmerger{
    
    public LinkedList<String> Sortedmerge(LinkedList<String> first, LinkedList<String> second){

    }
    public static void main(String[] args) {
        LinkedList<String> firstlist = new LinkedList<String>();
        LinkedList<String> secondlist = new LinkedList<String>();
        firstlist.add("Apple");
        firstlist.add("Banana");
        firstlist.add("Grapes");
        firstlist.add("Peaches");
        firstlist.add("Watermelon");
        secondlist.add("Alabama");
        secondlist.add("Delaware");
        secondlist.add("Illinois");
        secondlist.add("New York");
        secondlist.add("Wisconsin");
        linkedListmerger driver = new linkedListmerger();
        LinkedList<String> mergedlist = driver.Sortedmerge(firstlist, secondlist);
        System.out.println(firstlist);
        System.out.println(secondlist);
        System.out.println(mergedlist);
    }
}
