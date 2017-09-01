package com.ravi.designpatterns.command;
/*
 * Concrete Command
 */
public class FlipUpCommand implements ICommand{
	
	private Light sw;
	
	public FlipUpCommand(Light sw) {
		this.sw = sw;
	}

	


	@Override
	public void execute() {
		sw.turnOn();
		
	}
	
}
