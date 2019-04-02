package datastructure.maxminnumber;

public class FindMaxMinNumber {

	public static void main(String[] args) {
		int[] arr = {1, 2, 3, 5, 6, 7, 8};
		printMisstingNumber(arr);
	}

	private static void printMisstingNumber(int[] arr) {
		int max = Integer.MIN_VALUE;
		int min = Integer.MAX_VALUE;
		
		for (int i : arr) {
			if(i > max) {
				max = i;
			} 
			if(i < min) {
				min = i;
			}
		}
		
		System.out.format("Larget number %d and Smallest number %d", max, min);
	}

}
