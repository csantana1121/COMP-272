public class MyBigIntegerTest {
    public static void main(String[] args) {
        MyBigInteger driver = new MyBigInteger("1434");
        MyBigInteger test = new MyBigInteger("1235");
        System.out.println(driver.equals(test));
        System.out.println(driver.lessThan(test));
        System.out.println(test.lessThan(driver));
        MyBigInteger sum = driver.add(test);
        MyBigInteger lol = new MyBigInteger("777");
        MyBigInteger sum2 = driver.add(lol);
        MyBigInteger sum3 = lol.add(driver);
        MyBigInteger empty = new MyBigInteger();
        MyBigInteger empty2 = new MyBigInteger();
        MyBigInteger addition = empty.add(empty2);
        MyBigInteger addition2 = empty.add(driver);
        MyBigInteger addition3 = driver.add(empty);
        System.out.println(driver.equals(addition2));
        System.out.println(driver.equals(addition3));
        sum.bigI.printListForward();
    }
}
