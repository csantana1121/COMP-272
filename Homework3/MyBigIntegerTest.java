public class MyBigIntegerTest {
    public static void main(String[] args) {
        MyBigInteger driver = new MyBigInteger("1234");
        MyBigInteger test = new MyBigInteger("1235");
        System.out.println(driver.equals(test));
        System.out.println(driver.lessThan(test));
        System.out.println(test.lessThan(driver));
        MyBigInteger sum = driver.add(test);
        MyBigInteger lol = new MyBigInteger("777");
        MyBigInteger sum2 = driver.add(lol);
        MyBigInteger sum3 = lol.add(driver);
    }
}
