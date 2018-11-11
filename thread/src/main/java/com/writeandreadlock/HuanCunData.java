package com.writeandreadlock;

import java.util.HashMap;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock.ReadLock;
import java.util.concurrent.locks.ReentrantReadWriteLock.WriteLock;

public class HuanCunData {
	private HashMap<String, String> hashmap = new HashMap<>();
	
	private ReentrantReadWriteLock rrw = new ReentrantReadWriteLock();
	
	private ReadLock readLock = rrw.readLock();
	private WriteLock writeLock = rrw.writeLock();
	
	public String get(String key) {
		readLock.lock();
		
		String value = hashmap.get(key);
		if(value==null) {
			//这里说明缓存里没有,我们要去数据库里查
			readLock.unlock();
			
			//由于查完数据库要赋值到缓存里,所以还要开一个写锁.
			writeLock.lock();
			System.out.println("去数据库里查完了");
			String newvalue = "我是新的";
			hashmap.put(key, newvalue);
			writeLock.unlock();
		}
		readLock.unlock();
		return value;
	}
	
	public void set(String key,String value) {
		writeLock.lock();
		hashmap.put(key, value);
		writeLock.unlock();
	}

}
