package com.ravi.threads.lock;

import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ScoreBoard  {
	
	private ReadWriteLock scoreLocker = new ReentrantReadWriteLock(true);
	public int getScore() {
		return score;
	}

	private void setScore(int score) {
		this.score = score;
	}

	public String getSentiment() {
		return sentiment;
	}

	public void setSentiment(String sentiment) {
		this.sentiment = sentiment;
	}



	private int score=0;
	private String sentiment;
	
	public void updateScore(int increment){
		System.out.println("Increment"+increment);
		scoreLocker.writeLock().lock();
		score = score + increment;
		this.updateSentiment();
		scoreLocker.writeLock().unlock();
	}

	public void updateSentiment() {
		// TODO Auto-generated method stub
		scoreLocker.readLock().lock();
		if (score<25)
			sentiment = "average";
		if (score>50)
			sentiment="better";
		if (score>75)
			sentiment = "killer";
		if (score>100)
			sentiment ="century";
		else 
			sentiment="so-so";
		scoreLocker.readLock().unlock();
	}
	
	
	
	
	
	

}
