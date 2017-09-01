package com.ravi.designpatterns.command;

import java.util.HashMap;
import java.util.Map;

public class PressSwitchStream {
	
	private Map<String,ICommand> commandFactory;
	
	public PressSwitchStream() {
		// TODO Auto-generated constructor stub
		commandFactory = new HashMap<String,ICommand>();
	}
	
	public void addCommand(String commandStr, ICommand command){
		commandFactory.put(commandStr, command);
	}
	
	public void runCommand(String commandStr){
		if (commandFactory.containsKey(commandStr)){
			commandFactory.get(commandStr).execute();
		}
	}
	
	public static void main(String[] args) {
		PressSwitchStream stream = new PressSwitchStream();
		stream.addCommand("LightOnCommand", () ->{ System.out.println("Light is on");});
		stream.runCommand("LightOnCommand");	
	}

}
