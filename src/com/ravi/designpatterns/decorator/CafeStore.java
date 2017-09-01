package com.ravi.designpatterns.decorator;

public class CafeStore {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Beverage bev = new Expresso();
		bev  = new Mocha(bev);
		System.out.print(bev.getDescription() + bev.cost());

	}

}
