package sortdemo;

public class XuanZeSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] chi = { 2, 44, 5, 65, 7, 12, 53, 5, 9, 10, 22, 4 };
		int min = 0;
		for (int i = 0; i < chi.length; i++) {
			//ע��������j=i+1�������Ҫ���ϣ���Ҫ�������ڼӡ�
			min = i;
			for (int j = i + 1; j < chi.length; j++) {
				
				if (chi[min] > chi[j]) { 
					min=j;
				}
			}
			//�����������ѡ�����򣬱Ƚϴ�����ð��һ������������С��ð�ݡ�
			
			//ѡ���������ȶ��������㷨����Ϊ�����������ڵıȡ�
			int temp = chi[i];
			chi[i] = chi[min];
			chi[min] = temp;
			
			
		}
		for (int i = 0; i < chi.length; i++) {
			System.out.println(chi[i]);
		}
	}

}
