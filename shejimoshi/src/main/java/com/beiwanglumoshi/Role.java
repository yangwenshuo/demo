package com.beiwanglumoshi;

public class Role {
	public String name;
	public int age;
	public String weapon;
	public int hp;
	public int mp;
	
	public RoleBk bkRole(){
		return new RoleBk(weapon, hp, mp);
	}
	
	public void recoverRole(RoleBk bk){
		this.weapon = bk.weapon;
		this.hp = bk.hp;
		this.mp = bk.mp;
	}
	
	public void fightBoss(){
		this.hp -= 20;
		this.mp -= 20;
		this.weapon = "²Ëµ¶";
	}
	
	public void show(){
		System.out.println(this.toString());
	}

	@Override
	public String toString() {
		return "Role [name=" + name + ", age=" + age + ", weapon=" + weapon + ", hp=" + hp + ", mp=" + mp + "]";
	}



	public Role(String name, int age, String weapon, int hp, int mp) {
		super();
		this.name = name;
		this.age = age;
		this.weapon = weapon;
		this.hp = hp;
		this.mp = mp;
	};
	
	
	
	
}
