//fastest so far
import java.util.*;
import java.math.*;
public class ThreexBasic
{
   public void checkCollatz(BigInteger x) {
    
   int rightZeroBits;
       long n=0; 
       BigInteger y=x;
      do  {
           
           rightZeroBits=x.getLowestSetBit();
           
           if (rightZeroBits==0) {
               x=x.shiftLeft(1).add(x).add(BigInteger.ONE).shiftRight(1);
            // System.out.println(x);
               n++;
        }
        else {
            x=x.shiftRight(rightZeroBits);
          //System.out.println(x);
            n++;
        }
    }
        while (x.compareTo(y)>0);
          //if ((n % 10000)==0) System.out.println(n);
        
       System.out.println("steps ="+n);
   } 
   
   public static void main(String[] args){
       
      // int k = 82589933 ;
      int  k=216091;  //to 1 ; 2,081,336 steps; to <n 675,122
    //int k=859433; //to 1  :8,285,734 steps; 2,672,720
   //int k=2976221; //28,688,498
     
      BigInteger p=BigInteger.ONE.shiftLeft(k).subtract(BigInteger.ONE);
      // BigInteger p= new BigInteger("531137992816767098689588206552468627329593117727031923199444138200403559860852242739162502265229285668889329486246501015346579337652707239409519978766587351943831270835393219031728127");
       long t1 = System.currentTimeMillis();
       new ThreexBasic().checkCollatz(p);
       long t2= System.currentTimeMillis();
       System.out.println("time taken = "+ (t2-t1));
       
       
       
       
   }
   
   
}