package datastructure.missingnumber;

public class MultipleMissingNumberWithDuplicates {

	public static void main(String[] args) {
		int[] input = { 1, 1, 2, 3, 5, 5, 7, 9, 9, 9 };
		printMissingNumber(input);
	}

	private static void printMissingNumber(int[] arr) {
		int[] tempArr = new int[arr.length];

		for (int i : arr) {
			tempArr[i] = 1;
		}

		System.out.println("Missing numbers ");
		for (int i = 1; i < tempArr.length; i++) {
			if (tempArr[i] == 0) {
				System.out.print(i);
				System.out.print(",");
			}
		}
	}
}
