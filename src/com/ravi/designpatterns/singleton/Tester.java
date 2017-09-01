package com.ravi.designpatterns.singleton;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Tester  {

	public static void main(String[] args){
		
		Runnable r = () -> {System.out.println(ResourceBundle.getInstance().hashCode());};
		ExecutorService executor = Executors.newFixedThreadPool(5);
		for (int i=0; i<5; i++){
			executor.submit(r);
		}
		
		Runnable r1 = () -> {System.out.println(ResourceBundleEnum.INSTANCE.hashCode());};
		
		for (int i=0; i<5; i++){
			executor.submit(r1);
		}
		
		executor.shutdown();
	}
	
	
}
