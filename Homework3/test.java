

public class test {
    public static void main(String[] args) {
        MyLinkedList<Integer> test = new MyLinkedList<Integer>();
        MyLinkedList<Integer> test2 = new MyLinkedList<Integer>();
        System.out.println(test.isEmpty());
        test.addFirst(2);
        test.addFirst(0);
        test.addFirst(1);
        test2.addFirst(2);
        test2.addFirst(0);
        test2.addFirst(2);
        System.out.println(test.equals(test2));
        // test2.clear();
        // test.clear();
        System.out.println(test.equals(test2));
        test.printListForward();
        test.printListBackward();
        test.removeFirst();
        test.removeFirst();
        test.removeFirst();
        test.addLast(3);
        test.addLast(0);
        test.addLast(5);
        System.out.println("index 0 = " +test.get(0));
        System.out.println("index 2 = " +test.get(2));
        // System.out.println("index 5 = " +test.get(5));
        System.out.println(test.contains(0));
        System.out.println(test.contains(6));
        test.printListForward();
        test.clear();
        System.out.println(test.contains(0));
        test.printListForward();
    }
}
