package sort_solutions;

/**
 * 归并排序:让左右两部分的元素先有序，然后把两个有序的部分合并为一个有序的
 * 是一个递归
 * 空间复杂度：O(N)，归并排序需要一个与原数组相同长度的数组做辅助来排序
 * 
 * 归并排序可以用来求逆序对数
 * 具体思路是，在归并的过程中计算每个小区间的逆序对数，进而计算出大区间的逆序对数
 * @author zhou
 *
 */
public class 归并排序 {
	
	public static void sort(int[] arr, int L, int R){
		if(L == R)
			return ;
		// >>是比特操作，右移一位，相当于除以2
		int mid = L + ((R-L)>>1);
		//分 
		sort(arr, L, mid);
		sort(arr, mid+1, R);
		merge(arr, L, mid, R);
	}

	//治
	private static void merge(int[] arr, int left, int mid, int right) {
		//声明一个 left->right 的数组
		int[] tmp = new int[right-left+1];
		
		int i = 0;
		///初始化两个指针
		int p1 = left;
		int p2 = mid+1;
		
		//比较左右两部分元素，哪个小便放入tmp数组中
		while(p1<=mid && p2<=right){
			tmp[i] = (arr[p1]<arr[p2])?arr[p1++] :arr[p2++];
			i ++;
		}
		//循环退出后，把剩余的元素放入tmp
		while(p1 <= mid){
			tmp[i++] = arr[p1++];
		}
		while(p2 <= right){
			tmp[i++] = arr[p2++];
		}
		
		//将arr中的元素重新赋值，从而使arr中元素是左右两半都保持有序的
		for (int j = 0; j < tmp.length; j++) {
			arr[left+j] = tmp[j];
		}
	}
	
	public static void main(String[] args) {
		归并排序 g = new 归并排序();
		int[] arr = new int[]{5, 4, 7, 9, 3, 8, 12, 1};
		归并排序.sort(arr, 0, arr.length-1);
		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}
	}
}















