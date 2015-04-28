public class KNumSumToN {

	public static int count(int k, int[] numbers, int n) {
		return count(k, numbers, numbers.length-1, n);
	}

	public static int count(int k, int[] numbers, int index, int n) {
		if (k == 0 && n == 0 || (k == 1 && index == 0 && n - numbers[0] == 0)) {
			return 1;
		} else if (index <= 0 || k < 0 || n < 0) {
			return 0;
		} else {
			return count(k - 1, numbers, index - 1, n - numbers[index - 1])
					+ count(k, numbers, index - 1, n);
		}
	}

	public static void main(String[] args) {
		//int[] arr1= new int[] { 3,1,2,2,0,4,0};
		//int[] arr1= new int[] { 1,2,3,4,5,6,7};
		int[] arr1= new int[] { 1,2,3};
		//System.out.println(count(2, new int[] { 1, 1, 0 }, 3));
		System.out.println(count(2,arr1, arr1.length));
	}
}