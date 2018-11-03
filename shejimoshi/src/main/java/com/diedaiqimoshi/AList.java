package com.diedaiqimoshi;


public class AList implements IList{
	private int index = 0;
	private Object[] objarray = new Object[100];
	
	@Override
	public Iterator getIterator() {
		// TODO Auto-generated method stub
		return new AIterator(this);
	}

	@Override
	public void add(Object obj) {
		// TODO Auto-generated method stub
		objarray[index] = obj;
		this.index++;
	}
	
	@Override
	public int getSize() {
		// TODO Auto-generated method stub
		return this.index;
	}

	@Override
	public Object get(int index) {
		// TODO Auto-generated method stub
		return objarray[index];
	}
}
