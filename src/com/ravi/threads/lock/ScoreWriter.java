package com.ravi.threads.lock;

import java.util.Random;

public class ScoreWriter implements Runnable {

	Random random = new Random();
	private ScoreBoard board;
	@Override
	public void run() {
		// TODO Auto-generated method stub
		this.updateScore();

	}
	public ScoreWriter(ScoreBoard scoreBoard) {
		// TODO Auto-generated constructor stub
		this.board = board;
	
	}
	
	private void updateScore(){
		int rand = random.nextInt(10);
		System.out.printf("adding %d\n", rand);
		board.updateScore(rand);
		
	}

}
