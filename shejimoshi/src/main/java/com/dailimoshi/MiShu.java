package com.dailimoshi;

public class MiShu implements Person{

	private Person p = null;
	private String xinqing = "好";
	
	
	
	public Person getP() {
		return p;
	}

	public void setP(Person p) {
		this.p = p;
	}

	@Override
	public void meet() {
		// TODO Auto-generated method stub
		System.out.println("我是秘书,现在你见到我了,如果今天我心情好我就让你看到老板,如果心情不好就不然你看到");
		if(this.xinqing.equals("好")){
			p.meet();
		}else{
			System.out.println("今天心情不好,不让你看到老板");
		}
		
	}

}
