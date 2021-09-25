public class MyBigInteger{

    MyLinkedList<Integer> bigI;
    
    public MyBigInteger () {
        
        bigI =new MyLinkedList<>();
    }
    
    // takes a numerically valued String p and stores it one digit at a time in the linked list
    // example, MyBigInteger("383023322") will store the integer 383023322 in the linked list 
    // one digit per node. 
    public MyBigInteger(String p) {
        bigI =new MyLinkedList<>();
        char[] chars = p.toCharArray();
        for(int i = 0; i<chars.length;i++)
            bigI.addLast(Character.getNumericValue(chars[i]));
        bigI.printListForward();
    }
    
    //add(..) adds this MyBigInteger to other MyBigInteger and returns the sum as a MyBigInteger
    // the original Big Integers don't change.
    public MyBigInteger add(MyBigInteger other) {
        if (this.bigI.size==0 && other.bigI.size==0){
            MyBigInteger sum = new MyBigInteger();
            return sum;
        } else if(this.bigI.size == 0)
            return other;
        else if(other.bigI.size == 0)
            return this;
        else{
            Node<Integer> addend1 = this.bigI.last;
            Node<Integer> addend2 = other.bigI.last;
            if(this.bigI.size>other.bigI.size){
                int carry = 0;
                StringBuilder input1 = new StringBuilder();
                for(int i = 0; i<other.bigI.size;i++){
                    int sum = addend1.getInfo() + addend2.getInfo() + carry;
                    carry = 0;
                    if(sum >9){
                        sum = sum%10;
                        carry = 1;
                    }
                    input1.append(sum);
                    addend1 = addend1.getNext();
                    addend2 = addend2.getNext();
                }
                for(int i = other.bigI.size; i<this.bigI.size;i++){
                    int sum = addend1.getInfo() + carry;
                    carry =0;
                    if(sum >9){
                        sum = sum%10;
                        carry = 1;
                    }
                    input1.append(sum);
                    addend1 = addend1.getNext();

                }
                MyBigInteger sum =  new MyBigInteger(input1.reverse().toString());
                return sum;
            } else if(this.bigI.size<other.bigI.size){

            }

        }
    }
    
    // returns true if and only if the two big integers are equal
    public boolean equals(Object other) {
        if(other.getClass().equals(this.getClass())){
            MyBigInteger compare = (MyBigInteger) other;
            return this.bigI.equals(compare.bigI);
        } else
            return false;
    }
    // returns true if and only if this MyBigInteger is less than other MyBigInteger
    
    public boolean lessThan(MyBigInteger other) {
        if(this.bigI.size<other.bigI.size)
            return true;
        else if (this.bigI.size>other.bigI.size)
            return false;
        else{
            Node<Integer> num1 = this.bigI.first;
            Node<Integer> num2 = other.bigI.first;
            for(int i = 0; i<this.bigI.size;i++){
                if(num1.getInfo()<num2.getInfo())
                    return true;
                num1 = num1.getNext();
                num2 = num2.getNext();
            }
            return false;
        }
    }
}
