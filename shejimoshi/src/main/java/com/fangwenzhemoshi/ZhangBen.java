package com.fangwenzhemoshi;

import java.util.ArrayList;
import java.util.List;

public class ZhangBen {
	private List<Account> al = new ArrayList<Account>();
	
	public void addAccount(Account a){
		al.add(a);
	}
	
	public void show(Vister v){
		for (Account account : al) {
			account.accept(v);
		}
	}
}
