package sort_solutions;

import java.util.Arrays;

/**
 * �鲢����:
 * ˼�룺����
 * ��Ϊ�����֣�mergeSort��Sort
 * @author zhou
 *
 */
public class MergeSort {
	/*
	 * �Σ��ϲ�������.
	 * ע�⣺ǰ����nums�Ѿ����ź������
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
	 * �֣����,��ֳɶ������
	 * nums�����±�� left -> right
	 * */
	public void sort(int[] nums, int left, int mid, int right) {
		int leftSize = mid - left + 1;
		int rightSize = right - mid;
		///��ʼ�������յ�����
		int[] lefts = new int[leftSize];
		int[] rights = new int[rightSize];
		
		//��lefts��rights����ֱ���������
		for(int m = left;m <= mid;m ++) {
			lefts[m-left] = nums[m];
		}
		for(int m = mid+1;m <= right;m ++) {
			rights[m-mid-1] = nums[m];
		}
		
		//�ֱ�����������������α꣬�Լ��ϲ�����������ָ��
		int i = 0,j = 0,k = left;
		while(i < leftSize && j < rightSize) {
			if(lefts[i] <= rights[j]) {
				nums[k++] = lefts[i++];
			}else {
				nums[k++] = rights[j++];
			}
		}
		while(i < leftSize) { //˵��left���黹��ʣ��
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
