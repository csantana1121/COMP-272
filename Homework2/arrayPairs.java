public class arrayPairs {
    public void uniquePairs(int[] arr, int k){
        int pointerOne = 0;
        int pointerTwo = arr.length - 1;
        String output = "";
        while (pointerOne < pointerTwo) {
            int target = Math.abs(arr[pointerOne] - arr[pointerTwo]);
            // System.out.println(target);
            if (target == k) {
                output = "(" + arr[pointerOne] + "," + arr[pointerTwo] + "), ";
                pointerOne++;
            } else if (target < k) {
                pointerOne++;
            } else {
                pointerTwo--;
            }
        }
        output = output.substring(0, output.length() -2);
        System.out.println(output);
    }

    public static void main(String[] args) {
        int[] intArray = new int[]{ 1,4,9,12, 6, 15, 5, 13,17 };
        arrayPairs driver = new arrayPairs();
        driver.uniquePairs(intArray, 3);
    }
}
