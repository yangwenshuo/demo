package sortdemo;

public class XiEr {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// ϣ����������һ��ʼ�Ǹ��ս���˳�򣬲������ڶԱȣ����Բ����ȶ���
		// ϣ�������ǵ�һ��ʱ�临�Ӷ�ͻ��n^2d���㷨��ֱ�Ӳ�ֵ��ƽ��ֵ��n^2/4����ϣ��ƽ����n*logn�����n^2.
		int[] chi = { 2, 44, 5, 65, 7, 12, 53, 19, 9, 10, 22, 4 };

		int gap = chi.length;

		while (true) {
			gap = gap / 2;
			for (int count = 0; count < gap; count++) {
				// ��ѭ������ÿһ�����鶼�ܲ�ֵ����
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
