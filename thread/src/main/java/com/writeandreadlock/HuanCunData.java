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
			//����˵��������û��,����Ҫȥ���ݿ����
			readLock.unlock();
			
			//���ڲ������ݿ�Ҫ��ֵ��������,���Ի�Ҫ��һ��д��.
			writeLock.lock();
			System.out.println("ȥ���ݿ��������");
			String newvalue = "�����µ�";
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
