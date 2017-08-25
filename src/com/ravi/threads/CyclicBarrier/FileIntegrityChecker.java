package com.ravi.threads.CyclicBarrier;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


public class FileIntegrityChecker implements Runnable{
	
	

	public FileIntegrityChecker() {
		
	}
	
	public static void main(String[] args) throws InterruptedException {
		
		CyclicBarrier barrier = new CyclicBarrier(5, new FileIntegrityChecker());
		
		ExecutorService executorService = Executors.newFixedThreadPool(5);
		for (int i=0;i<5;i++){
		executorService.submit(new DownloadWorker(barrier));
		System.out.println("Submitted Jobs");
		
		}
		executorService.shutdown();
		System.out.println("Awaiting Workers to finish");
	}
	
	

	private void doIntegrityCheck() {		
				
		
		System.out.print("Doing Integrity Check");;
		
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		this.doIntegrityCheck();
	}

}
