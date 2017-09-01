package com.ravi.designpatterns.decorator;

public class Mocha extends AddOnsDecorator {

	
	


	public Mocha(Beverage beverage) {
		super(beverage);
		// TODO Auto-generated constructor stub
		this.description = "Mocha";
	}


	@Override
	public double cost() {
		// TODO Auto-generated method stub
		return beverage.cost()+ 1;
	}


	@Override
	public String getDescription() {
		// TODO Auto-generated method stub
		return beverage.getDescription()+this.description;
	}

}
