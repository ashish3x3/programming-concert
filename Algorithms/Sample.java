public class Sample {
    private int x1, x2, max;


    public void calculate(){
        int max_sum = 0, finalX1 = 0, finalX2 = 0, finalY1 = 0, finalY2 = 0;
       // int[][] array = new int[][]
          //      {{ 1, 4},
           //      { 5, -5}};
        
        int [][] array=new int[][]{{9,7,-3,2},{5,8,2,-8},{0,-3,5,3},{-5,4,3,-7}};
        int[] tmp = new int[array[0].length];


        for (int y1 = 0; y1 < array.length; y1++) {              //y1 = starting row to start summing up
            for (int x = 0; x < array[y1].length; x++)
                tmp[x] = 0;


            for (int y2 = y1; y2< array.length; y2++) {          //y2 = next row to sum up.
                for (int x1 = 0; x1 < array[y1].length; x1++)
                    tmp[x1] += array[y2][x1];


                kadane(tmp);


                if (max > max_sum) {
                    finalY1 = y1;
                    finalY2 = y2;
                    finalX1 = x1;
                    finalX2 = x2;
                    max_sum = max;
                }
            }
        }


        System.out.println("max sum = " + max_sum);
        System.out.println("from: " + finalX1 + ", " + finalY1);
        System.out.println("to: " + finalX2 + ", " + finalY2);


        for(int i=finalX1 ; i<finalX2 ; i++){
            for(int j=finalY1 ; j<finalY2 ; j++){
                System.out.print(array[i][j] + " ");
            }
            System.out.println();
        }
    }


    private void kadane(int input[]) {
        int currentMax = 0;
        x1 = x2 = 0;
        int startIndex = 0;
        for (int i = 0; i < input.length; i++) {
            currentMax = currentMax + input[i];
            if (currentMax > max) {
                max = currentMax;
                x2 = i;
                x1 = startIndex;
            }
            if (currentMax < 0) {
                currentMax = 0;
                startIndex = i + 1;
            }
        }
    }


    public static void main(String[] args) {
        new Sample().calculate();
    }
}