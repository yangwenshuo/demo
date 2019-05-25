package sortdemo;

import javax.sql.rowset.JdbcRowSet;

public class ChaZhi {

	////////啊啊啊
	//dierciaag

	//插值排序 的时间复杂度是n^2/4,而冒泡是n^2/2,选择是n^2/2，但是选择排序的交换次数比 冒泡排序少。
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] chi = { 2, 44, 5, 65, 7, 12, 53, 9, 9, 10, 22, 4 };

		// 插值排序 把前面的弄成排序的往里面插 知乎-+
		//冒泡排序比较很多，交换也很多
		//选择排序比较跟冒泡一样多，但是交换少很多
		//插值排序比较比那两个少了大约一半。
		
		//插值排序也是相邻的两个比所以是稳定的。
		
		int j = 0;
		int i = 0;
		for (i = 1; i < chi.length; i++) {

			for (j = i - 1; j >= 0; j--) {
				//把i前面的当成有序的，和i前面的挨个比较，如果发现比自己小的，就把自己插他后面,
				//这里是不会有步骤浪费的，因为如果发现第一个就比自己小，就不会往前继续插入了。
				if (chi[i] > chi[j]) {
					break;
				}
			}
			if (j != i - 1) {
				//这里可以判断出，返发现了比自己小的，就把后面的全往后移动，把自己插进去。
				int temp = chi[i];

				for (int k = i - 1; k > j; k--) {
					chi[k + 1] = chi[k];
				}

				chi[j + 1] = temp;
			}
		}

		for (int m : chi) {
			System.out.println(m);
		}

	}

}
