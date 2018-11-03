package com.xiangyuanmoshi;

import java.util.HashMap;

public class WebSiteFactory{
	
	private static HashMap<String, WebSite> hm = new HashMap<String, WebSite>();
	
	public WebSite getWebSite(String webname){
		if(hm.containsKey(webname)){
			return hm.get(webname);
		}else{
			hm.put(webname, new WebSite(webname));
			return hm.get(webname);
		}
	}
	
	public int getWebSiteNum(){
		return hm.size();
	}
}
