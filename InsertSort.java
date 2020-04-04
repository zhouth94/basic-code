package sort_solutions;

import java.util.Arrays;

public class InsertSort {
	//插入排序 需要空出一个位置放待插入的数
	public void insert(int[] arr,int n) { //将第n个数插入到arr
		int key = arr[n];
		int i = n;
		for(;i >= 1;i --) {
			if(arr[i-1] > key) {
				arr[i] = arr[i-1];
			}else {
				break;
			}
			if(i == 0) arr[i] = key;
			
		}
		arr[i] = key;
	}
	
	public void insertSort(int[] arr) {
		//初始化arr长度为1
		for(int i = 1;i < arr.length;i ++) {
			insert(arr, i);
		}
	}
	
	public static void main(String[] args) {
		int[] arr = {9, 3, 101, 17, 5, 1};
		InsertSort i = new InsertSort();
		i.insertSort(arr);
		System.out.println(Arrays.toString(arr));
	}

}
