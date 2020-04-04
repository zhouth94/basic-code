package sort_solutions;

import java.util.Arrays;

public class BubbleSort {
	public void bubble(int[] arr,int n) {
		int temp = 0;
		for(int i = 0;i < n - 1;i ++) {
			if(arr[i] > arr[i+1]) {
				temp = arr[i];
				arr[i] = arr[i+1];
				arr[i+1] = temp;
			}
		}
	}
	
	public void bubbleAll(int[] arr) { 
		int n = arr.length;
		for(int i = n;i >= 1;i --) {
			bubble(arr, i);
		}
	}
	
	
	public static void main(String[] args) {
		int[] arr = {9, 1, 10, 7, 5};
		BubbleSort b = new BubbleSort();
		b.bubbleAll(arr);
		System.out.println(Arrays.toString(arr));
	}
}
