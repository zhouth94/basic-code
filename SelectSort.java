package sort_solutions;

import java.util.Arrays;

public class SelectSort {
	public int findMaxIndex(int[] arr,int n) {
		int max = arr[0];
		int index = 0;
		for(int i = 1;i < n;i ++) {
			if(arr[i] > max) {
				max = arr[i];
				index = i;
			}
		}
		return index;
	}
	
	public void selectSort(int[] arr) {
		int n = arr.length;
		
		while(n > 1) {
			int index = findMaxIndex(arr, n);
			int temp = arr[n - 1];
			arr[n-1] = arr[index];
			arr[index] = temp;
			n --;
		}
	}
	
	public static void main(String[] args) {
		int[] arr = {9, 3, 10, 17, 5};
		SelectSort s = new SelectSort();
		s.selectSort(arr);
		System.out.println(Arrays.toString(arr));
	}
}
