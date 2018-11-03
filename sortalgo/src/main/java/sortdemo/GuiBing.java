package sortdemo;

public class GuiBing {
	//归并排序是稳定的，因为会有相邻比较的。
	//归并排序的时间复杂度是n*logn 比如将一个16长度数组分的话，会分为8级 ，8 8 ，4级，4 4 4 4，2级 2 2 2 2 2 2 2 2,1级等
	//比如1级，要把一级的两两放到result数组里，时间度是n,把二级的两两放到result里时间度也是n,1248级一共会放result logn次
	//所以时间复杂度是n*logn。
	public static void main(String[] args) {
		int[] chi = { 2, 44, 5,7, 65, 7, 12, 53, 19, 9, 10, 22, 4 };
		int[] result = mergerSort(chi,0,chi.length-1);
		
		for (int i = 0; i < result.length; i++) {
			System.out.println(result[i]);
		}
	}
	//归并排序两大步骤
	public static int[] mergerSort(int[] chi,int begin,int end) {
		// TODO Auto-generated method stub
	
		
		int[] leftresult = null;
		int[] rightresult = null;
		int[] totalresulte = null;
		
		if(end - begin>0)//注意只有当传进来的数组长度大于等于2的时候才继续递归，分成两份搞，当
						//数组长度只有一个的时候就直接返回包含这一个元素的数组即可。
		{
			int mid = (end-begin)/2 + begin;
			
			
			
			
			//111111111111111111111111在传进来的数组的长度大于1的情况下，分成两部分，左右部分分别进行递归排序。
			
			
			
			
			leftresult = mergerSort(chi, begin,mid);
			rightresult = mergerSort(chi, mid+1,end);
			
			int left = 0;
			int right = 0;
			int i = 0;
		
			totalresulte = new int[end - begin + 1];
			
			
			
			
			//2222222222222222222222222222上面的两部分分别进行归并排序后，两边都是排序的
			//下来我们进行合并数组就可以了
			//左边的做指针指向第一个，右边的指针指向第一个，小的进resutl，移动指针 。
			
			
			
			
			//合并数组的代码看看吧 好理解，左边的数组有个左指针，指向最靠前的元素，也就是当前最小的，
			//右边数组有个右指针，指向最靠前的元素，也是当前最小的，最小的比较，谁小谁进result数组，谁的指针往后挪一位。
			while(left<leftresult.length && right < rightresult.length){
				//一旦左边或是右边有一个数组塞完了，就停止循环，那么就把另一个全部追到result数组里。
				if(leftresult[left] > rightresult[right]){
					totalresulte[i] = rightresult[right];
					i++;
					right++;
				}else{
					totalresulte[i] = leftresult[left];
					i++;
					left++;
				}
			}
			
			if(left == leftresult.length){
				//左边的放完了把右边的追加到result数组
				while(right<rightresult.length){
					totalresulte[i] = rightresult[right];
					right++;
					i++;
				}
			}else if(right == rightresult.length){
				//右边的放完 把左边的追加到result数组
				while(left<leftresult.length){
					totalresulte[i] = leftresult[left];
					left++;
					i++;
				}
			}
			return totalresulte;
		}else{
			//当只剩一个的时候就把这个值放到一个数组里返回去，上面的就会开始并归。
			int oneresule[] = {chi[end]};
			return oneresule;
		}
		
		

	}
}
