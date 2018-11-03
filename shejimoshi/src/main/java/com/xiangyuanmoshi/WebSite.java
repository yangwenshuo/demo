package com.xiangyuanmoshi;

public class WebSite {
	private String name;
	
	public WebSite() {
		super();
		// TODO Auto-generated constructor stub
	}

	public WebSite(String name) {
		super();
		this.name = name;
	}

	public void use(User user){
		System.out.println(user.getName()+"ิฺสนำร" +this.getName());
	}

	
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
	
}
