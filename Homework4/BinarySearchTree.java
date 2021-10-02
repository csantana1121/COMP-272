public class BinarySearchTree<E extends Comparable<E>> extends BinaryTree<E> {

    int size;
    Node<E> root;
    public BinarySearchTree() {
       size = 0;
       root = null;
   }
   public BinarySearchTree(E val) {
       root = new Node(val);
       size = 1;
   }
   
// returns true if BST has val else false.
   public boolean contains (E val) {
        Node<E> node  = root;
        if(node == null)
            return false;
        else{
            if(node.getInfo() == val){
                return true;
            } else{
                while(node != null){
                    if(node.getInfo().compareTo(val)< 0){  
                        if(node.getRight() == null)
                            return false;
                        else
                            node = node.getRight();
                    } else if( node.getInfo().compareTo(val)>0){
                        if(node.getLeft() == null)
                            return false;
                        else
                            node = node.getLeft();
                    } else {
                        return true;
                    }
                }
                return false;
            }
        }
       
   }
// inserts val at the right place satisfying search tree properties, should handle if the tree is empty
// if value is already there then donâ€™t insert it again
   public void insert(E val) {
        
        Node<E> node = new Node(val);
        if (size == 0){
            root = node;
            size++;
        } else if (!this.contains(val)){
            node = root;
            while(node != null){
                if(node.getInfo().compareTo(val)<0){
                    if (node.getRight()!= null)
                        node = node.getRight();
                    else{
                        this.addRight(node, val);
                        size++;
                        return;
                    }
                }
                if(node.getInfo().compareTo(val)>0){
                    if (node.getLeft() != null)
                        node = node.getLeft();
                    else{
                        this.addLeft(node, val);
                        size++;
                        return;
                    }
                }
            }   
        } 
        }

// returns the minimum value stored in the tree
public E findMin() {
    Node<E> node = root;
    if (node ==null)
        return null;
    while (node.getLeft() != null){
        node= node.getLeft();
    }
    return node.getInfo();

}

// returns the maximum value stored in the tree
public E findMax() {
    Node<E> node = root;
    if (node ==null)
        return null;
    while (node.getRight() != null){
        node= node.getRight();
    }
    return node.getInfo();
}
   
   public static void main(String[] args) {
       BinarySearchTree<Integer> bt= new BinarySearchTree<>();
       bt.insert(5);
       bt.insert(10);
    //    bt.inOrder(bt.root);
    //    System.out.println(bt.root.right.getInfo());
       bt.insert(3);
       bt.insert(3);
       bt.insert(20);
       bt.insert(324);
       bt.insert(-6);
       bt.insert(8);
       bt.insert(4);
    //    System.out.println(bt.root.right.right.getInfo());
       bt.inOrder(bt.root);
       System.out.println("Lowest value:" + bt.findMin());
       System.out.println("Highest value:" + bt.findMax());
   }
   
            
}