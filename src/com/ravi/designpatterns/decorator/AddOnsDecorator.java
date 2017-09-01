package com.ravi.designpatterns.decorator;

public abstract class AddOnsDecorator extends Beverage {
	
	Beverage beverage;
	
	
	public AddOnsDecorator(Beverage beverage) {
		super();
		this.beverage = beverage;
	}
	public abstract String getDescription();
	
	
	

}
