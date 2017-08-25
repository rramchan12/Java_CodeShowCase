package com.ravi.threads.lock;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Runner {

public static void main(String[] args) {
		
		ScoreBoard board = new ScoreBoard();
		ExecutorService executor = Executors.newFixedThreadPool(10);
		for (int i =0; i<9 ; i++){
			executor.execute(new ScoreWriter(board));
			
		}
		executor.execute(new ScoreReader(board));
		
		
		
	}

}
