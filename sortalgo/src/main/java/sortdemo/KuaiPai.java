package sortdemo;

import java.util.Arrays;

public class KuaiPai {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// java�Ŀ���Ҳ�ǵݹ�ʵ�ֵ�
		/*
		 * ��������������֮ǰѧϰ��ð����������������Ƕ����ڽ��������򣬶���ͨ�����ϵ�
		 * �Ƚ��ƶ�ʵ������ģ�����ʵ�������˼�¼�ıȽϺ��ƶ��ľ��������ؼ��ֽϴ�ļ�¼
		 * ��ǰ��ֱ���ƶ������棬�ؼ��ֽ�С�ļ�¼�Ӻ���ֱ���ƶ���ǰ�棬�Ӷ���С���ܵıȽ� �������ƶ��Ĵ�����ͬʱ���õݹ���ε�˼�롣
		 */
		int[] chi = { 2, 44, 5, 7, 65, 7, 12, 53, 19, 9, 10, 22, 4 };


		//�������������� ���� low������high����
		kuaiPai(chi, 0, chi.length - 1);
		System.out.println(Arrays.toString(chi));
	}

	public static void kuaiPai(int[] chi, int low, int high) {

		//ע������Ҫ������ highback��lowback
		//ע��tempҪ�����Ū,���м��while��ֻ��ch[low]=ch[high]��ch[high]=ch[low]
		int lowbak = low;
		int highbak = high;
		
		if(low == high){
			return;
		}
	
		// TODO Auto-generated method stub
		int temp = chi[low];
		while(low < high){
			while((low < high) && (chi[high] > temp)){
				//���ұ߰�������߱ȣ����chi[high]�������ֵ�Ͱ�highһֱ�����Ų
				high--;
			}
			
			if(low < high){
				//һ�������ѭ��ֹͣ�ˣ�˵������low==high�ˣ�����chi[high]<temp��
				//�����chi[high]<temp��,�Ͱ����Сֵ����chi[low]
		
				chi[low] = chi[high];//���ʱ��chi[high]�Ȳ��ø�ֵ����Ϊ���Ǵ�high���жϺ�����Ҫȥlow��ѭ����
				//��low��ѭ�����Ҳ������һ����ֵ��break����ʱ���ǿ��԰������ֵ�������ڵ�high
				low++;//���lowҪ��һ�£���Ϊ�Ѿ�ȷʵ���յ���һ��С��temp�ĺ�����.
			}else{
				break;
			}
			while((low < high) && (chi[low] < temp)){
				//��low�߿�ʼ�Ƚ�,���С��temp�Ļ��Ͱ�lowָ��һֱ���ұ�Ų
				low++;
			}
			if(low < high){
				//һ�������ѭ��ֹͣ�ˣ�˵������low==high�ˣ�����chi[low] > temp��
				
				
				
				//��������˻���chi[low] > temp,��ʱ���ǾͰ�chi[low],�����������high
				
				
				
				chi[high] = chi[low];//���ʱ��chi[low]�Ȳ��ø�ֵ����Ϊ���Ǵ�low���жϺ�����Ҫȥhigh��ѭ����
				//��high��ѭ�����Ҳ������һ��Сֵ��break����ʱ���ǿ��԰������ֵ�������ڵ�low
				high--;//���highҪ��һ�£���Ϊ�Ѿ�ȷʵ���յ���һ������temp�ĺ�����.
				
				
			}else{
				break;
			}		
		}
		//ѭ����ɺ�϶���low==high��,����,��ʱ����û��ֵ,���ǰ�temp������
		chi[low] = temp;
		
		
		//�ݹ�Ի�׼���������߽��бȽ�
		
		if (high < highbak) {
			kuaiPai(chi, low+1, highbak);//Ҫ���õ��ղű����lowbak��highbak
		}
		if (low > lowbak) {
			kuaiPai(chi, lowbak, high-1);
		}
		
		
	}

}
