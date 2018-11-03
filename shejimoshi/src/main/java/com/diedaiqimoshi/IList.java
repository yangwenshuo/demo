package com.diedaiqimoshi;

public interface IList {
	public Iterator getIterator();
	public Object get(int index);
	public void add(Object obj);
	public int getSize();
}
