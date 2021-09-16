public class replaceChar {

    public static String replaceChar(String p, int k, char c){
        try{
            return p.substring(0,k)+ c + p.substring(k+1);
        } 
        catch(Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void main(String[] args) {
        String test = "Hi testing that this works";
        String empty = "";
        String newstr = replaceChar(test,3,'+');
        String outofbounds = replaceChar(empty, 0, 'I');
        String testbounds = replaceChar(test, 50, 'T');
        System.out.println(test);
        System.out.println(newstr);
        System.out.println(outofbounds);
        System.out.println(testbounds);
    }
}
