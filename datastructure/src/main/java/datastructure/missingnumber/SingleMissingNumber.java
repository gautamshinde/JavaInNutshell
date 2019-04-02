package datastructure.missingnumber;

public class SingleMissingNumber {

	public static void main(String[] args) {
		int[] arr = {1, 2, 3, 5, 6, 7, 8};
		System.out.println(printMisstingNumber(arr));
	}
	
	public static int printMisstingNumber(int[] arr) {
		if(arr.length ==1) {
			return -1;
		}
		
		int origLength = arr.length+1;
		
		int sum = (origLength * (origLength+1)) /2 ;
		
		for (int i : arr) {
			sum -= i;
		}
		
		return sum;
	}

}
