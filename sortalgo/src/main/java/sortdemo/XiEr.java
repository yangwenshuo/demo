package sortdemo;

public class XiEr {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 希尔排序由于一开始是隔空交换顺序，不是相邻对比，所以不是稳定的
		// 希尔排序是第一个时间复杂度突破n^2d的算法，直接插值的平均值是n^2/4，而希尔平均是n*logn，最坏是n^2.
		int[] chi = { 2, 44, 5, 65, 7, 12, 53, 19, 9, 10, 22, 4 };

		int gap = chi.length;

		while (true) {
			gap = gap / 2;
			for (int count = 0; count < gap; count++) {
				// 二循环控制每一个分组都能插值排序到
				int i, j;
				for (i = count + gap; i < chi.length; i = i + gap) {
					for (j = i - gap; j >= 0; j = j - gap) {
						if (chi[j] < chi[i]) {
							break;
						}
					}
					if (j != i - gap) {
						int temp = chi[i];
						for (int k = i - gap; k > j; k = k - gap) {
							chi[k + gap] = chi[k];
						}

						chi[j + gap] = temp;
					}

				}
			}
			if (gap == 1) {
				break;
			}
		}

		for (int i : chi) {
			System.out.println(i);
		}
	}

}
