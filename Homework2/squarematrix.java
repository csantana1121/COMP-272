public class squarematrix {

    public void rowSums(int[][] arr){
        for (int i = 0; i < arr.length; i++){
            int rowsum = 0;
            //Here I use the length of the column, but doesn't matter since it's a square
            //so it's the same length/size
            for (int j = 0; j < arr[i].length; j++){
                rowsum += arr[i][j];
            }
            System.out.println(rowsum);
        }
    }

    public void columnMins(int[][] arr){
        for (int i = 0; i < arr.length; i++){
            int columnmin = arr[0][i];
            for (int j = 0; j < arr.length; j++){
                //for some reason (arr[j][i]<columnmin) wasn't working
                //when columnmin was 1 higher than arr[j][i] used this roundabout way
                //not sure of the java syntax issue or why it didn't work
                if (columnmin-arr[j][i]>0)
                    columnmin = arr[j][i];
            }
            System.out.println(columnmin);
        }
    }
    public static void main(String[] args) {
        squarematrix driver = new squarematrix();
        int square[][] = {{3,2,5},{1,0,4},{5,6,7}};
        driver.rowSums(square);
        System.out.println();
        driver.columnMins(square);
    }
}
