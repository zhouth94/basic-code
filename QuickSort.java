package sort_solutions;

import java.util.Arrays;

public class QuickSort {
	public static void main(String[] args) {
		int[] nums = new int[]{4,15,10,6,2,7,13,8};
		QuickSort q = new QuickSort();
		q.quickSort(nums, 0, nums.length-1);
		System.out.println(Arrays.toString(nums));
	}
	
	public void quickSort(int[] nums, int left, int right) {
		if(left >= right)
			return;
		//mid是索引,获取中间值的索引
		int mid = getMid(nums, left, right); 
		quickSort(nums, left,mid-1);
		quickSort(nums, mid+1, right);
	}

	private int getMid(int[] nums, int left, int right) {
		System.out.println("left:" + left);
		int standard = nums[left];
		System.out.println("nums[left]" + nums[left]);
		while(left < right) {
			while(nums[right] >= standard && left < right) {
				right --;
			}
			System.out.println("跳出right" + "---" + right);
			//不满足条件，就移动
			nums[left] = nums[right];
			while(nums[left] <= standard && left < right) {
				left ++;
			}
			nums[right] = nums[left];
			System.out.println("跳出left" + "---" + left);
		}
		//left指针与right指针相遇，且 standard > nums[left]
		nums[left] = standard;
		
		return left;
	}

}
