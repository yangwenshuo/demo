package com.diedaiqimoshi;

public class AIterator implements Iterator{
	
	private IList ilist = null;
	private int index = 0;
	
	
	public AIterator(IList ilist) {
		super();
		this.ilist = ilist;
	}

	@Override
	public boolean hasNext() {
		if(index >= ilist.getSize()){
			return false;
		}else{
			return true;
		}
		
	}

	@Override
	public Object next() {
		Object obj = ilist.get(index);
		index++;
		return obj;
	}

}
