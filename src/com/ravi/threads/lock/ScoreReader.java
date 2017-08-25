package com.ravi.threads.lock;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ScoreReader implements Runnable {

	ScoreBoard board ;
	@Override
	public void run() {
		// TODO Auto-generated method stub
		this.readScore();

	}
	
	public ScoreReader(ScoreBoard board) {
		// TODO Auto-generated constructor stub
		
		this.board = board;
	}
	
	private void readScore(){
		System.out.printf("Score is %d and Sentiment is %s\n", board.getScore(), board.getSentiment());
	}
	
	

}
