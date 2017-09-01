package com.ravi.designpatterns.command;
/*
 * Concrete Command
 */
public class FlipDownCommand implements ICommand {

	private Light sw;
	
	public FlipDownCommand(Light sw) {
		this.sw = sw;
	}
	@Override
	public void execute() {
		// TODO Auto-generated method stub
		sw.turnOff();
	}

}
