package sortdemo;

import javax.sql.rowset.JdbcRowSet;

public class ChaZhi {

	////////������
	//dierciaag

	//��ֵ���� ��ʱ�临�Ӷ���n^2/4,��ð����n^2/2,ѡ����n^2/2������ѡ������Ľ��������� ð�������١�
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] chi = { 2, 44, 5, 65, 7, 12, 53, 9, 9, 10, 22, 4 };

		// ��ֵ���� ��ǰ���Ū�������������� ֪��-+
		//ð������ȽϺܶ࣬����Ҳ�ܶ�
		//ѡ������Ƚϸ�ð��һ���࣬���ǽ����ٺܶ�
		//��ֵ����Ƚϱ����������˴�Լһ�롣
		
		//��ֵ����Ҳ�����ڵ��������������ȶ��ġ�
		
		int j = 0;
		int i = 0;
		for (i = 1; i < chi.length; i++) {

			for (j = i - 1; j >= 0; j--) {
				//��iǰ��ĵ�������ģ���iǰ��İ����Ƚϣ�������ֱ��Լ�С�ģ��Ͱ��Լ���������,
				//�����ǲ����в����˷ѵģ���Ϊ������ֵ�һ���ͱ��Լ�С���Ͳ�����ǰ���������ˡ�
				if (chi[i] > chi[j]) {
					break;
				}
			}
			if (j != i - 1) {
				//��������жϳ����������˱��Լ�С�ģ��ͰѺ����ȫ�����ƶ������Լ����ȥ��
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
