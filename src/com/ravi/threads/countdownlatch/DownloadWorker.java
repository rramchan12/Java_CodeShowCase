package com.ravi.threads.countdownlatch;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public class DownloadWorker implements Runnable{
	
	private CountDownLatch latch;
	
	public DownloadWorker(CountDownLatch latch) {
		// TODO Auto-generated constructor stub
		this.latch = latch;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		this.doSomethingAndNotify();
		
	}
	
	private void doSomethingAndNotify(){
		try {
			System.out.println("Working");
			TimeUnit.SECONDS.sleep(3);
			System.out.println("Done Working");
			latch.countDown();
			
			
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
	}
	

}
