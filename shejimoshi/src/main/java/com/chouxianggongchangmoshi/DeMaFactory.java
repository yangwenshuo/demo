package com.chouxianggongchangmoshi;

public class DeMaFactory implements IFactory{

	@Override
	public MidHero createMidHero() {
		// TODO Auto-generated method stub
		return new DeMaMidHero();
	}

	@Override
	public TopHero createTopHero() {
		// TODO Auto-generated method stub
		return new DeMaTopHero();
	}

	@Override
	public ADHero createADHero() {
		// TODO Auto-generated method stub
		return new DeMaADHero();
	}

}
