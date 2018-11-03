package sortdemo;

public class XuanZeSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] chi = { 2, 44, 5, 65, 7, 12, 53, 5, 9, 10, 22, 4 };
		int min = 0;
		for (int i = 0; i < chi.length; i++) {
			//注意这里是j=i+1；这里就要加上，不要到后面在加。
			min = i;
			for (int j = i + 1; j < chi.length; j++) {
				
				if (chi[min] > chi[j]) { 
					min=j;
				}
			}
			//这才是真正的选择排序，比较次数跟冒泡一样，交换次数小于冒泡。
			
			//选择排序不是稳定的排序算法，因为他不是与相邻的比。
			int temp = chi[i];
			chi[i] = chi[min];
			chi[min] = temp;
			
			
		}
		for (int i = 0; i < chi.length; i++) {
			System.out.println(chi[i]);
		}
	}

}
