package sortdemo;

public class GuiBing {
	//�鲢�������ȶ��ģ���Ϊ�������ڱȽϵġ�
	//�鲢�����ʱ�临�Ӷ���n*logn ���罫һ��16��������ֵĻ������Ϊ8�� ��8 8 ��4����4 4 4 4��2�� 2 2 2 2 2 2 2 2,1����
	//����1����Ҫ��һ���������ŵ�result�����ʱ�����n,�Ѷ����������ŵ�result��ʱ���Ҳ��n,1248��һ�����result logn��
	//����ʱ�临�Ӷ���n*logn��
	public static void main(String[] args) {
		int[] chi = { 2, 44, 5,7, 65, 7, 12, 53, 19, 9, 10, 22, 4 };
		int[] result = mergerSort(chi,0,chi.length-1);
		
		for (int i = 0; i < result.length; i++) {
			System.out.println(result[i]);
		}
	}
	//�鲢����������
	public static int[] mergerSort(int[] chi,int begin,int end) {
		// TODO Auto-generated method stub
	
		
		int[] leftresult = null;
		int[] rightresult = null;
		int[] totalresulte = null;
		
		if(end - begin>0)//ע��ֻ�е������������鳤�ȴ��ڵ���2��ʱ��ż����ݹ飬�ֳ����ݸ㣬��
						//���鳤��ֻ��һ����ʱ���ֱ�ӷ��ذ�����һ��Ԫ�ص����鼴�ɡ�
		{
			int mid = (end-begin)/2 + begin;
			
			
			
			
			//111111111111111111111111�ڴ�����������ĳ��ȴ���1������£��ֳ������֣����Ҳ��ֱַ���еݹ�����
			
			
			
			
			leftresult = mergerSort(chi, begin,mid);
			rightresult = mergerSort(chi, mid+1,end);
			
			int left = 0;
			int right = 0;
			int i = 0;
		
			totalresulte = new int[end - begin + 1];
			
			
			
			
			//2222222222222222222222222222����������ֱַ���й鲢��������߶��������
			//�������ǽ��кϲ�����Ϳ�����
			//��ߵ���ָ��ָ���һ�����ұߵ�ָ��ָ���һ����С�Ľ�resutl���ƶ�ָ�� ��
			
			
			
			
			//�ϲ�����Ĵ��뿴���� ����⣬��ߵ������и���ָ�룬ָ���ǰ��Ԫ�أ�Ҳ���ǵ�ǰ��С�ģ�
			//�ұ������и���ָ�룬ָ���ǰ��Ԫ�أ�Ҳ�ǵ�ǰ��С�ģ���С�ıȽϣ�˭С˭��result���飬˭��ָ������Ųһλ��
			while(left<leftresult.length && right < rightresult.length){
				//һ����߻����ұ���һ�����������ˣ���ֹͣѭ������ô�Ͱ���һ��ȫ��׷��result�����
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
				//��ߵķ����˰��ұߵ�׷�ӵ�result����
				while(right<rightresult.length){
					totalresulte[i] = rightresult[right];
					right++;
					i++;
				}
			}else if(right == rightresult.length){
				//�ұߵķ��� ����ߵ�׷�ӵ�result����
				while(left<leftresult.length){
					totalresulte[i] = leftresult[left];
					left++;
					i++;
				}
			}
			return totalresulte;
		}else{
			//��ֻʣһ����ʱ��Ͱ����ֵ�ŵ�һ�������ﷵ��ȥ������ľͻῪʼ���顣
			int oneresule[] = {chi[end]};
			return oneresule;
		}
		
		

	}
}
