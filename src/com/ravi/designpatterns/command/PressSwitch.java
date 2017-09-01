package com.ravi.designpatterns.command;

/*Test Class or Client*/

public class PressSwitch {
	
	public Light sw;

	public PressSwitch(Light sw) {
		super();
		this.sw = sw;
	}
	
	
	public static void main(String[] args) {
		final Light light = new Light();
		FlipUpCommand flipUpCommand = new FlipUpCommand(light);
		FlipDownCommand flipDownCommand = new FlipDownCommand(light);
		
		Switch sw = new Switch();
		sw.storeAndExecute(flipUpCommand);
	}
	

}
