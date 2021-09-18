public class arrayPairs {
    public void uniquePairs(int[] arr, int k){
        String output = "";
        for(int i = 0; i<arr.length;i++){
            for(int j = i; j<arr.length;j++){
                int target = Math.abs(arr[i] - arr[j]);
                if (target == k)
                    output += "(" + arr[i] + "," + arr[j] + "), ";
            }
        }
        output = output.substring(0, output.length()-2);
        System.out.println(output);
    }

    public static void main(String[] args) {
        int[] intArray = new int[]{ 1,4,9,12, 6, 15, 5, 13,17 };
        arrayPairs driver = new arrayPairs();
        driver.uniquePairs(intArray, 3);
        driver.uniquePairs(intArray, 4);
    }
}
