package sortdemo;

public class DuiPaiXu {

	public static void main(String[] args) {
		//�������ǲ��ȶ��ģ���Ϊ���������ڱȽϵģ����Ƿֳ��������ˣ���ߴ������ұߴ���ǰ�����ڵ�����������ܶ�û��ϵ,
		//�������ʱ�临�Ӷ��ȶ�Ϊn*logn ��һ��n����ΪҪ������ȡn�����������n�ǻ�ȡһ��n�����ṹ��Ҫ�Ա�logn�Σ���
		//�ѵ�ʱ����n�����Ǳ�С̫�࣬�����ˡ�
		int[] chi = { 2, 44, 5, 65, 7, 12, 53, 19, 9, 10, 22, 4 };
		int len = chi.length;
		// ����������ɶѵ�����
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
	//��������㷨�Ǽ���������Ƕ����Եģ�ֻ�ж���Ĳ��ǵ�ʱ������ã����������ڵ�һ�δ����ѵ�ʱ��
	//��Ҫ���µ��ϣ������Ұѷ�Ҷ�ڵ�ȫ����һ��ſ����γɶѣ��������� ��ʱ������ֻ�ж���ձ��������ģ�ֻ�ж�����
	//�Ƕѽṹ�ģ����Կ���ֱ��gaoChengDui(chi, 0, len);
	public static void gaoChengDui(int[] chi, int i, int length) {// �����ں���������ʱ��Ҫ��ͣ����С����length
																	// Ҫ��С�����Դ��˽�����
		int temp = chi[i];
		int k = 0;
		for (k = 2 * i + 1; k < length; k = 2 * k + 1) {
			if ((k + 1) < length && chi[k] > chi[k + 1]) {
				k++;// ע������Ҫ�ȱ�����
			}
			if (chi[k] > temp) {// ��Ϊ�����Ǻ�temp�ȣ����Կ��Ե����chi[i] = temp;
				break;
			} else {
				// ��Ϊ���ڵ��k���ˣ����Ծ��п���Ӱ��k�ڵ�Ķѽṹ������Ҫ��k�ڵ��ж��£�����k=2*k+1ѭ���жϡ�
				chi[i] = chi[k];
				i = k;// ���ڵ�k���Ǻ�����i����Ϊ��������k�ڵ㱻���ˣ�Ҫ��k�ڵ����������жϡ�
			}
		}

		chi[i] = temp;
	}

}
