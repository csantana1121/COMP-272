import java.util.*;
public class test {
    public static void main(String[] args) {
        MaxHeap<Integer> heaper = new MaxHeap<>();
        MaxHeap<Integer> builder = new MaxHeap<>();
        ArrayList<Integer> test = new ArrayList<>();
        test.add(213);
        test.add(32);
        test.add(2143);
        test.add(21);
        test.add(1);
        test.add(8);
        test.add(540);
        builder.heapSort(test);
        builder.buildHeap(test);
        heaper.addHeap(10);
        System.out.println("max:" + heaper.removeHeap());
        heaper.addHeap(13);
        heaper.addHeap(1);
        heaper.addHeap(321);
        heaper.addHeap(43);
        heaper.addHeap(8);
        heaper.addHeap(1);
        System.out.println("max:" + heaper.removeHeap());
        System.out.println(heaper.arr);
        heaper.heapMerge(builder);
        System.out.println(heaper.arr);
        System.out.println(heaper.size());
    }
}
