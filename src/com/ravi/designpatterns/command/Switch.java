package com.ravi.designpatterns.command;

import java.util.ArrayList;
import java.util.List;

/*
 * Invoker
 */
public class Switch {
	
	private List<ICommand> history;
	public Switch() {
		// TODO Auto-generated constructor stub
		history = new ArrayList();
	}
	
	public void storeAndExecute(ICommand command){
		history.add(command);
		command.execute();
	}

}
