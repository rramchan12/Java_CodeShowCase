package com.ravi.threads.countdownlatch;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


public class DownloadManager {
	
	private CountDownLatch latch ;
	public CountDownLatch getLatch() {
		return latch;
	}

	public void setLatch(CountDownLatch latch) {
		this.latch = latch;
	}

	public DownloadManager() {
		this.latch = new CountDownLatch(6);
	}
	
	public static void main(String[] args) throws InterruptedException {
		
		DownloadManager manager = new DownloadManager();
		manager.initMultiThreadedDownload();
	}

	public void initMultiThreadedDownload() throws InterruptedException {
		
		ExecutorService executorService = Executors.newFixedThreadPool(5);
		for (int i=0;i<5;i++){
		executorService.submit(new DownloadWorker(latch));
		}
		executorService.shutdown();
		System.out.println("Awaiting Workers to finish");
		latch.await();
		System.out.print("Workers are finished");;
		
	}

}
