class threexplusone {
    public static void main(String[] args) {
        int startnum = 0;
        int index = 0;
        int greatestpeak = 0;
        int steps;
        int highestnum;
        while (true){
            index = startnum;
            System.out.println("Indexing for " + index);
            steps = 0;
            highestnum = 0;
            do{
                if(index % 2 == 0 && index != 0){
                    index = index / 2;
                    // System.out.println(index);
                } else{
                    index = (3*index) + 1;
                    // System.out.println(index);
                }
                steps++;
                if (index > highestnum){
                    highestnum = index;
                }
                if (index > greatestpeak){
                    greatestpeak = index;
                }
            } while(index != 1);
            startnum++;
            System.out.println("Total number of steps: " + steps);
            System.out.println("Highest peak this cycle: " + highestnum);
            System.out.println("Greatest peak so far: " + greatestpeak);
        }
    }
}