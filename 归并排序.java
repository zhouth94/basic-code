package sort_solutions;

/**
 * �鲢����:�����������ֵ�Ԫ��������Ȼ�����������Ĳ��ֺϲ�Ϊһ�������
 * ��һ���ݹ�
 * �ռ临�Ӷȣ�O(N)���鲢������Ҫһ����ԭ������ͬ���ȵ�����������������
 * 
 * �鲢��������������������
 * ����˼·�ǣ��ڹ鲢�Ĺ����м���ÿ��С�������������������������������������
 * @author zhou
 *
 */
public class �鲢���� {
	
	public static void sort(int[] arr, int L, int R){
		if(L == R)
			return ;
		// >>�Ǳ��ز���������һλ���൱�ڳ���2
		int mid = L + ((R-L)>>1);
		//�� 
		sort(arr, L, mid);
		sort(arr, mid+1, R);
		merge(arr, L, mid, R);
	}

	//��
	private static void merge(int[] arr, int left, int mid, int right) {
		//����һ�� left->right ������
		int[] tmp = new int[right-left+1];
		
		int i = 0;
		///��ʼ������ָ��
		int p1 = left;
		int p2 = mid+1;
		
		//�Ƚ�����������Ԫ�أ��ĸ�С�����tmp������
		while(p1<=mid && p2<=right){
			tmp[i] = (arr[p1]<arr[p2])?arr[p1++] :arr[p2++];
			i ++;
		}
		//ѭ���˳��󣬰�ʣ���Ԫ�ط���tmp
		while(p1 <= mid){
			tmp[i++] = arr[p1++];
		}
		while(p2 <= right){
			tmp[i++] = arr[p2++];
		}
		
		//��arr�е�Ԫ�����¸�ֵ���Ӷ�ʹarr��Ԫ�����������붼���������
		for (int j = 0; j < tmp.length; j++) {
			arr[left+j] = tmp[j];
		}
	}
	
	public static void main(String[] args) {
		�鲢���� g = new �鲢����();
		int[] arr = new int[]{5, 4, 7, 9, 3, 8, 12, 1};
		�鲢����.sort(arr, 0, arr.length-1);
		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}
	}
}















