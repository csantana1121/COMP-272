import java.util.*;

public class linkedListmerger{
    
    public LinkedList<String> Sortedmerge(LinkedList<String> first, LinkedList<String> second){
        if (first.isEmpty())
            return second;
        else if (second.isEmpty())
            return first;
        LinkedList <String> merged = new LinkedList<String>();
        ListIterator firstlist = first.listIterator();
        ListIterator secondlist = second.listIterator();
        while(firstlist.hasNext() && secondlist.hasNext()){
            if(((String) firstlist.next()).compareTo((String) secondlist.next())>0){
                merged.add((String) secondlist.previous());
                secondlist.next();
                firstlist.previous();
            } else{
                merged.add((String) firstlist.previous());
                firstlist.next();
                secondlist.previous();
            }
        }
        if(!firstlist.hasNext())
            merged.add((String) secondlist.next());
        else
            merged.add((String) firstlist.next());
        return merged;
    }
    public static void main(String[] args) {
        LinkedList<String> firstlist = new LinkedList<String>();
        LinkedList<String> secondlist = new LinkedList<String>();
        firstlist.add("Apple");
        firstlist.add("Banana");
        firstlist.add("Cabbage");
        firstlist.add("Grapes");
        firstlist.add("Peaches");
        firstlist.add("Watermelon");
        secondlist.add("Alabama");
        secondlist.add("Apple");
        secondlist.add("Delaware");
        secondlist.add("Illinois");
        secondlist.add("New York");
        secondlist.add("Wiscousin");
        linkedListmerger driver = new linkedListmerger();
        LinkedList<String> mergedlist = driver.Sortedmerge(firstlist, secondlist);
        System.out.println(firstlist);
        System.out.println(secondlist);
        System.out.println(mergedlist);
        LinkedList<String> test1 = new LinkedList<String>();
        LinkedList<String> test2 = new LinkedList<String>();
        LinkedList<String> test3 = driver.Sortedmerge(test1, test2);
        System.out.println(test1);
        System.out.println(test2);
        System.out.println(test3);
    }
}
