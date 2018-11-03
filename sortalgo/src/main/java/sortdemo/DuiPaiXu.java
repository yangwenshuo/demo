package sortdemo;

public class DuiPaiXu {

	public static void main(String[] args) {
		//堆排序是不稳定的，因为他不是相邻比较的，而是分成树那样了，左边大树和右边大树前后相邻的在树里面可能都没关系,
		//堆排序的时间复杂度稳定为n*logn 第一个n是因为要挨个获取n个数，后面的n是获取一个n在树结构中要对比logn次，建
		//堆得时间是n，但是比小太多，忽略了。
		int[] chi = { 2, 44, 5, 65, 7, 12, 53, 19, 9, 10, 22, 4 };
		int len = chi.length;
		// 将这个数组搞成堆的样子
		for (int i = 0; i < len / 2 - 1; i++) {
			gaoChengDui(chi, i, len);
		}
		
		while (len > 0) {
			System.out.println(chi[0]);
			chi[0] = chi[len - 1];
			gaoChengDui(chi, 0, len);
			len--;
		}
	}
	//下面这个算法是假设下面的是堆属性的，只有顶点的不是的时候才能用，所以我们在第一次创建堆的时候
	//需要从下到上，从左到右把非叶节点全部走一遍才可以形成堆，而当调整 的时候由于只有顶点刚被换成最大的，只有顶点是
	//非堆结构的，所以可以直接gaoChengDui(chi, 0, len);
	public static void gaoChengDui(int[] chi, int i, int length) {// 由于在后来交换的时候要不停的缩小数组length
																	// 要减小，所以传了进来。
		int temp = chi[i];
		int k = 0;
		for (k = 2 * i + 1; k < length; k = 2 * k + 1) {
			if ((k + 1) < length && chi[k] > chi[k + 1]) {
				k++;// 注意这里要先比左右
			}
			if (chi[k] > temp) {// 因为这里是和temp比，所以可以到最后chi[i] = temp;
				break;
			} else {
				// 因为父节点和k换了，所以就有可能影响k节点的堆结构，所以要对k节点判断下，所以k=2*k+1循环判断。
				chi[i] = chi[k];
				i = k;// 现在的k就是后来的i，因为现在由于k节点被换了，要对k节点的情况进行判断。
			}
		}

		chi[i] = temp;
	}

}
