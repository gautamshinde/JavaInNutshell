package datastructure.maxsum;

public class MaxSumNoAdjucentElement {

	public static void main(String[] args) {
		int[] arr = new int[]{1,4,0,1,100,2};
		System.out.println("Max sum = "+ findMaxSum(arr));
	}

	private static int findMaxSum(int[] arr) {
		if(arr.length <=2) {
			return -1;
		}
		int excSum = 0;
		int incSum = arr[0];
		int tempExc = 0;
		for (int i = 1; i < arr.length; i++) {
			tempExc = Integer.max(excSum, incSum); //(0,1) - (1,4) - (4,1) - (4, 5) - (5, 104)  
			incSum = excSum + arr[i];              // 0+4  -  1+0  - 4+1   - 4+100  - 5+2
			excSum = tempExc;                      // 1    -  4    - 4     -  5     - 104
		}		
		return Integer.max(excSum, incSum);
	}
}
