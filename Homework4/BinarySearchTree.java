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
                    if(node.getInfo().compareTo(val)> 0){  
                        if(node.getRight() == null)
                            return false;
                        else
                            node = node.getRight();
                    } else if( node.getInfo().compareTo(val)<0){
                        if(node.getLeft() == null)
                            return false;
                        else
                            node = node.getLeft();
                    } else {
                        return true;
                    }
                }
            }
        }
       
   }
// inserts val at the right place satisfying search tree properties, should handle if the tree is empty
// if value is already there then donâ€™t insert it again
   public void insert(E val) {
        
        Node<E> node = new Node(val);
        if (size == 0)
            root = node;
        else if (!this.contains(val)){
            node = root;
            while(node != null){
                if(node.getInfo().compareTo(val)>0){
                    
                }
            }   
        }
        }

// returns the minimum value stored in the tree
public E findMin() {

}

// returns the maximum value stored in the tree
public E findMax() {
}
   
   public static void main(String[] args) {
       BinarySearchTree<Integer> bt= new BinarySearchTree<>();
       bt.insert(5);
       bt.insert(10);
       bt.insert(3);
       bt.insert(20);
       bt.insert(8);
       bt.insert(4);
   }
   
            
}