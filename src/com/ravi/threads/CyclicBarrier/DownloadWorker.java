package com.ravi.threads.CyclicBarrier;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.TimeUnit;

public class DownloadWorker implements Runnable{
	
	private CyclicBarrier barrier;
	
	public DownloadWorker(CyclicBarrier barrier) {
		// TODO Auto-generated constructor stub
		this.barrier = barrier;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		this.doSomethingAndVerifyIntegrity();
		
	}
	
	private void doSomethingAndVerifyIntegrity(){
		try {
			System.out.println("Working");
			
			
			System.out.println("IntegrityCheck : No of parties waiting :"+barrier.getNumberWaiting());
			System.out.println("Joining the Party");
			barrier.await();
			System.out.println("IntegrityCheck: Done");
			
			
			
		} catch (InterruptedException | BrokenBarrierException e) {
			
			e.printStackTrace();
		}
	}
	

}
