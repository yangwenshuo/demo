package com.danlimoshi;

//����ģʽ
public class Wife {
	private static Wife wife = null;
	static Object obj = new Object();
	
	//ע�ⵥ��ģʽ�Ĺ�����Ҫ˽��
	private Wife(){
		
	}
	
	public static Wife getInstance(){
		
		if(wife == null){
			//һ��ͬ�������  if�п�
			synchronized (obj) {
				if (wife == null) {
					wife = new Wife();
				}
			} 
		}
		return wife;
	}
}
