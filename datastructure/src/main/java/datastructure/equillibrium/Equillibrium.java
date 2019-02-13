package datastructure.equillibrium;

import java.util.Arrays;

public class Equillibrium {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 int arr[] = { -7, 1, 5, 2, -4, 3, 0 };
		 System.out.println("Equillibrium " + findEquillibrium(arr));
	}

	private static int findEquillibrium(int arr[]) {
		
		if(arr == null || arr.length == 0) {
			return -1;
		}
		int leftsum = 0;
		int sum = Arrays.stream(arr).sum();
		
		for (int i = 0; i < arr.length; i++) {
			sum -= arr[i];
			
			if(sum == leftsum) {
				return i;
			}
			
			leftsum += arr[i];
		}		
		
		
		return sum;
	}
}
