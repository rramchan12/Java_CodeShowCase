package com.ravi.designpatterns.singleton;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/*
 * Enum with double checked locking
 * 
 */
public class ResourceBundle {
	
	private static volatile ResourceBundle instance = null ;
	
	private ResourceBundle() {
		// TODO Auto-generated constructor stub
		this.instance = instance;
	}
	
	public static ResourceBundle getInstance(){
		if (instance==null) {
			synchronized(ResourceBundle.class){
				if (instance == null ){
					instance= new ResourceBundle();
				}
							
				
			}
		}
		return instance;
		
	}
	
	
	
	

}
