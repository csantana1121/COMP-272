public class MyBigInteger{

    MyLinkedList<Integer> bigI;
    
    public MyBigInteger () {
     
        bigI =new MyLinkedList<>();
    }
    private boolean isNumeric(String strNum) {
        if (strNum == null) {
            return false;
        }
        try {
            double d = Integer.parseInt(strNum);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }
    
    // takes a numerically valued String p and stores it one digit at a time in the linked list
    // example, MyBigInteger("383023322") will store the integer 383023322 in the linked list 
    // one digit per node. 
    public MyBigInteger(String p) {
        bigI =new MyLinkedList<>();
        if(isNumeric(p)){
            boolean firstDigit = false;
            boolean isNegative = false;
            char[] chars = p.toCharArray();
            for(int i = 0; i<chars.length;i++){
                if(Character.getNumericValue(chars[i]) > 0 && !firstDigit)
                    firstDigit = true;
                if(Character.getNumericValue(chars[i]) == -1 && !firstDigit)
                    isNegative = true;
                if(firstDigit)
                    if(isNegative){
                        bigI.addFirst(-Character.getNumericValue(chars[i]));
                        isNegative = false;
                    } else
                        bigI.addLast(Character.getNumericValue(chars[i]));
            }
            if(!firstDigit)
                bigI.addFirst(0);
        } else
            throw new NumberFormatException();
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
                    addend1 = addend1.getPrev();
                    addend2 = addend2.getPrev();
                }
                for(int i = other.bigI.size; i<this.bigI.size;i++){
                    int sum = addend1.getInfo() + carry;
                    carry =0;
                    if(sum >9){
                        sum = sum%10;
                        carry = 1;
                    }
                    input1.append(sum);
                    addend1 = addend1.getPrev();

                }
                MyBigInteger sum =  new MyBigInteger(input1.reverse().toString());
                return sum;
            } else if(this.bigI.size<other.bigI.size){
                int carry = 0;
                StringBuilder input1 = new StringBuilder();
                for(int i = 0; i<this.bigI.size;i++){
                    int sum = addend1.getInfo() + addend2.getInfo() + carry;
                    carry = 0;
                    if(sum >9){
                        sum = sum%10;
                        carry = 1;
                    }
                    input1.append(sum);
                    addend1 = addend1.getPrev();
                    addend2 = addend2.getPrev();
                }
                for(int i = this.bigI.size; i<other.bigI.size;i++){
                    int sum = addend2.getInfo() + carry;
                    carry =0;
                    if(sum >9){
                        sum = sum%10;
                        carry = 1;
                    }
                    input1.append(sum);
                    addend2 = addend2.getPrev();

                }
                MyBigInteger total =  new MyBigInteger(input1.reverse().toString());
                return total;
            } else {
                int carry = 0;
                StringBuilder input1 = new StringBuilder();
                for(int i = 0; i<this.bigI.size;i++){
                    int sum = addend1.getInfo() + addend2.getInfo() + carry;
                    carry = 0;
                    if(sum >9){
                        sum = sum%10;
                        carry = 1;
                    }
                    input1.append(sum);
                    addend1 = addend1.getPrev();
                    addend2 = addend2.getPrev();
                }
                MyBigInteger total =  new MyBigInteger(input1.reverse().toString());
                return total;
            }

        }
    }
    
    // returns true if and only if the two big integers are equal
    public boolean equals(Object other) {
        if(other instanceof MyBigInteger){
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
                else if(num1.getInfo()>num2.getInfo())
                    return false;
                num1 = num1.getNext();
                num2 = num2.getNext();
            }
            return false;
        }
    }
}
