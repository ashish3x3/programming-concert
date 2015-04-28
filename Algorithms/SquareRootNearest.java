import java.util.Scanner;


public class SquareRootNearest {

	public static void main(String[] args) {
		System.out.println("enetr number");
		Scanner scan=new Scanner(System.in);
		
		int num;
		num=scan.nextInt();
		
		
		System.out.println("result"+squareRoot(num));

	}
	
	public static int squareRoot(int num){

			int k = num, diff = 0;

				while (true) {

						while (k * k >= num)

								k = k / 2;

						if (k * k == num)

							return k;

// Simplification here. Increment k till its square it less than num

// and then compare which of sqaure of (k-1) and square of k is near to original number.

// return that

						while (k * k < num) {

							k++;

						}

						int diffLower = Math.abs((num - (k-1) * (k-1)));

						int diffHigher = Math.abs((num - k*k));

						if(diffLower<diffHigher) 
							return k-1;

						return k;

		
		
		
}
	}
}
