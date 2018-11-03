package com.chouxianggongchangmoshi;


public class NuoKeFactory implements IFactory{

	@Override
	public MidHero createMidHero() {
		// TODO Auto-generated method stub
		return new NuoKeMidHero();
	}

	@Override
	public TopHero createTopHero() {
		// TODO Auto-generated method stub
		return new NuoKeTopHero();
	}

	@Override
	public ADHero createADHero() {
		// TODO Auto-generated method stub
		return new NuoKeADHero();
	}

}
