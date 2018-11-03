package sortdemo;

public class MaoPaoSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] chi = { 2, 44, 5, 65, 7, 12, 53, 5, 9, 10, 22, 4 };
		
		for (int j = 0; j < chi.length; j++) {
			for (int i = 0; i < chi.length-1-j; i++) {
				if (chi[i]>chi[i+1]) {
					int temp = chi[i];
					chi[i] = chi[i+1];
					chi[i+1] = temp;
				}
			}			
		}
		for (int i = 0; i < chi.length; i++) {
			System.out.println(chi[i]);
		}
	}

}
