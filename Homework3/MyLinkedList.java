import java.util.*;
public class MyLinkedList<E>
{
    Node<E> first;
    Node<E> last;
    int size;
    
    public MyLinkedList()
    {
       first = null;
       last = null;
       size=0;
    }
    
    public boolean isEmpty() {
        
        return (size==0);
        
    }
    
    public void addFirst(E info) {
        
        Node<E> n =new Node<>();
        n.setInfo(info);
        
       if (isEmpty())  
           last=n;
           
    
       else {
        n.setNext(first);
        first.setPrev(n);
        
    }
    first=n;
    size++;
        
    }
    
    public E removeFirst() {
        
    if (!isEmpty()) {
        
    E val = first.getInfo();
        if (size>1) {
       
        first.getNext().setPrev(null);
        first=first.getNext();
        size--;
        
    }
    else if (size==1) {
       
         first=null;
         last=null;
         size--;
         
        
    }
      return val;  
    }
    else 
    throw new NoSuchElementException();

    }
    
    
    public E removeLast() {
        
    if (!isEmpty()) {
        
   
        E val = last.getInfo();
        if (size>1) {
        last.getPrev().setNext(null);
        last=last.getPrev();
        size--;
    }
       else if (size==1) {
           
         first=null;
         last=null;
         size--;
        }
        return val;
    }
    else 

        throw new NoSuchElementException();
}   
//incomplete code below
//handle empty list situation    
    public E remove(int k) {
        
        if (!isEmpty()) {
        Node<E> temp = first;
        
        if ((k>=0) && (k<size)) {
            if (k==0) return removeFirst();
            else if (k==size-1) return removeLast();
            else {
                // get to k
               // int i=0;
                for (int i=0;i<k;i++) 
                temp = temp.getNext();
                E val=temp.getInfo();
              temp.getPrev().setNext(temp.getNext());
              temp.getNext().setPrev(temp.getPrev());
              size--;
              return val;
                
            }
        }
        else throw new IndexOutOfBoundsException();
    }
            else {
                System.out.println("list empty ..");
            
                throw new NoSuchElementException();
        }
    }
    // adds an item to the end of the list with info field set to val
    public void addLast(E val) {
        Node<E> n =new Node<>();
        n.setInfo(val);
        if (isEmpty())  
           first=n;
        else {
            n.setPrev(last);
            last.setNext(n);
        }
        last = n;
        size++;
        
    }
    
    // prints all items in the list from first to last taking care of situations when the list is empty
    // use exception handling
    public void printListForward() {
        Node<E> n = first;
        if (!isEmpty()) {
            System.out.print(n.getInfo());
            while(n.getNext() != null){
                n = n.getNext();
                System.out.print(", " + n.getInfo());
            }
            System.out.println();
        } else {
            System.out.println("list empty ..");

            throw new NoSuchElementException();
        }

        
    }
    
    // prints all items in the list from last to first taking care of situations when the list is em
    // use exception handling
    public void printListBackward() {
        Node<E> n = last;
        if (!isEmpty()) {
            System.out.print(n.getInfo());
            while(n.getPrev() != null){
                n = n.getPrev();
                System.out.print(", " + n.getInfo());
            }
            System.out.println();
        } else {
            System.out.println("list empty ..");

            throw new NoSuchElementException();
        }
        
    }
    
    //returns true if and only if the list contains at least one element e such that 
    //Objects.equals(o,e)
    //return false if the list is empty
    public boolean contains(Object o) {
        Node<E> n = first;
        if (!isEmpty()) {
            if (n.getInfo()==o)
                return true;
            while(n.getNext()!=null){
                n = n.getNext();
                if(n.getInfo()==o)
                    return true;
            }
            return false;
        } else {
            return false;
        }
    }
    
    // brings the current list back to an empty list
    public void clear() {
        first = null;
        last = null;
        size=0;
        
    }
    // returns the info value stored at node i 
    // throw IndexOutOfBounds exception of i is out of bounds or the list is empty
    public E get(int i) {
        Node<E> n = first;
        if (!isEmpty()) {
            while(n.getNext() != null){
                n = n.getNext();
            }
        } else {
            System.out.println("list empty ..");

            throw new NoSuchElementException();
        }
        return first.getInfo();
    }
    
    // compares this MyLinkedList with the parameter otherList 
    // and returns true if the linkedlists have identical values from beginning to end
    // same size and this.get(i).equals(otherList.get(i)) should be true for all i
    // lists can be empty in which case return true
    //should run in O(n) time where n is the size of each list.
    public boolean equals(Object otherList) {
        return true;
        
        
    }
    
    public static void main(String[] args) {
        MyLinkedList<Integer> test = new MyLinkedList<Integer>();
        System.out.println(test.isEmpty());
        test.addFirst(2);
        test.addFirst(0);
        test.addFirst(1);
        test.printListForward();
        test.printListBackward();
        test.removeFirst();
        test.removeFirst();
        test.removeFirst();
        test.addLast(3);
        test.addLast(0);
        test.addLast(5);
        System.out.println(test.contains(0));
        System.out.println(test.contains(6));
        test.printListForward();
        test.clear();
        System.out.println(test.contains(0));
        test.printListForward();
    }
    
}
    
    