package sortdemo;

import java.util.Arrays;

public class KuaiPai {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// java的快排也是递归实现的
		/*
		 * 快速排序是我们之前学习的冒泡排序的升级，他们都属于交换类排序，都是通过不断的
		 * 比较移动实现排序的，他的实现增大了记录的比较和移动的举例，将关键字较大的记录
		 * 从前面直接移动到后面，关键字较小的记录从后面直接移动都前面，从而减小了总的比较 次数和移动的次数，同时采用递归分治的思想。
		 */
		int[] chi = { 2, 44, 5, 7, 65, 7, 12, 53, 19, 9, 10, 22, 4 };


		//快排有三个参数 数组 low索引和high索引
		kuaiPai(chi, 0, chi.length - 1);
		System.out.println(Arrays.toString(chi));
	}

	public static void kuaiPai(int[] chi, int low, int high) {

		//注意这里要备份下 highback和lowback
		//注意temp要在最后弄,在中间的while里只是ch[low]=ch[high]和ch[high]=ch[low]
		int lowbak = low;
		int highbak = high;
		
		if(low == high){
			return;
		}
	
		// TODO Auto-generated method stub
		int temp = chi[low];
		while(low < high){
			while((low < high) && (chi[high] > temp)){
				//从右边挨个往左边比，如果chi[high]大于这个值就把high一直往左边挪
				high--;
			}
			
			if(low < high){
				//一旦上面的循环停止了，说明可能low==high了，或者chi[high]<temp了
				//如果是chi[high]<temp了,就把这个小值赋给chi[low]
		
				chi[low] = chi[high];//这个时候chi[high]先不用赋值，因为我们从high边中断后马上要去low边循环了
				//从low边循环完后也会由于一个大值而break，这时我们可以把这个大值赋给现在的high
				low++;//这边low要加一下，因为已经确实的收到了一个小于temp的函数了.
			}else{
				break;
			}
			while((low < high) && (chi[low] < temp)){
				//从low边开始比较,如果小于temp的话就把low指针一直往右边挪
				low++;
			}
			if(low < high){
				//一旦上面的循环停止了，说明可能low==high了，或者chi[low] > temp了
				
				
				
				//如果发生了或者chi[low] > temp,此时我们就把chi[low],赋给到上面的high
				
				
				
				chi[high] = chi[low];//这个时候chi[low]先不用赋值，因为我们从low边中断后马上要去high边循环了
				//从high边循环完后也会由于一个小值而break，这时我们可以把这个大值赋给现在的low
				high--;//这边high要加一下，因为已经确实的收到了一个大于temp的函数了.
				
				
			}else{
				break;
			}		
		}
		//循环完成后肯定是low==high了,哈哈,此时这里没有值,我们把temp赋给他
		chi[low] = temp;
		
		
		//递归对基准的左右两边进行比较
		
		if (high < highbak) {
			kuaiPai(chi, low+1, highbak);//要利用到刚才保存的lowbak和highbak
		}
		if (low > lowbak) {
			kuaiPai(chi, lowbak, high-1);
		}
		
		
	}

}
