package sort_solutions;

import java.util.Arrays;

/**
 * 归并排序:
 * 思想：分治
 * 分为两部分：mergeSort、Sort
 * @author zhou
 *
 */
public class MergeSort {
	/*
	 * 治：合并，排序.
	 * 注意：前提是nums已经是排好序的了
	 * */
	public void mergeSort(int[] nums, int L, int R) {
		while(L >= R)
			return;
		int M = (L + R) >> 1;
		mergeSort(nums, L, M);
		mergeSort(nums, M+1, R);
		sort(nums, L, M, R);
	}
	
	/*
	 * 分：拆分,拆分成多个数组
	 * nums数组下标从 left -> right
	 * */
	public void sort(int[] nums, int left, int mid, int right) {
		int leftSize = mid - left + 1;
		int rightSize = right - mid;
		///初始化两个空的数组
		int[] lefts = new int[leftSize];
		int[] rights = new int[rightSize];
		
		//将lefts、rights数组分别填上数字
		for(int m = left;m <= mid;m ++) {
			lefts[m-left] = nums[m];
		}
		for(int m = mid+1;m <= right;m ++) {
			rights[m-mid-1] = nums[m];
		}
		
		//分别定义左右两个数组的游标，以及合并后的新数组的指针
		int i = 0,j = 0,k = left;
		while(i < leftSize && j < rightSize) {
			if(lefts[i] <= rights[j]) {
				nums[k++] = lefts[i++];
			}else {
				nums[k++] = rights[j++];
			}
		}
		while(i < leftSize) { //说明left数组还有剩余
			nums[k++] = lefts[i++];
		}
		while(j < rightSize) {
			nums[k++] = rights[j++];
		}
		/*for(int m = 0;m < nums.length;m ++) {
			nums[left+m] = nums[m];
		}*/
		
	}
	
	public static void main(String[] args) {
		MergeSort sol = new MergeSort();
		int[] arr = new int[]{4,5,11,6,2,7,13,8};
		sol.mergeSort(arr, 0, arr.length-1);
		System.out.println(Arrays.toString(arr));
	}

}
