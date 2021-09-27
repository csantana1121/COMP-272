public class MyBigIntegerTest {
    public static void main(String[] args) {
        MyBigInteger driver = new MyBigInteger("999");
        MyBigInteger test = new MyBigInteger("1");
        System.out.println(driver.equals(test));
        System.out.println(driver.lessThan(test));
        System.out.println(test.lessThan(driver));
        MyBigInteger sum = driver.add(test);
        MyBigInteger lol = new MyBigInteger("777");
        MyBigInteger sum2 = driver.add(lol);
        MyBigInteger sum3 = lol.add(driver);
        MyBigInteger empty = new MyBigInteger();
        MyBigInteger empty2 = new MyBigInteger();
        System.out.println("testing empty" +empty.lessThan(driver));
        MyBigInteger addition2 = empty.add(driver);
        MyBigInteger addition3 = driver.add(empty);
        System.out.println(driver.equals(addition2));
        System.out.println(driver.equals(addition3));
        sum.bigI.printListForward();
        System.out.println(driver.equals("1434"));
        MyBigInteger kekw = new MyBigInteger("1234");
        MyBigInteger neg = new MyBigInteger("-2134");
        MyBigInteger negsum = kekw.add(neg);
        negsum.bigI.printListForward();
    }
}
