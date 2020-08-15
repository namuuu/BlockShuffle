package fr.namu.bs.utils;

import fr.namu.bs.MainBS;

public class StatUtil {

	private int PlayerNB = 0;
	
	
	public StatUtil(MainBS main) {
	}

	public int getPlayer() {
		return this.PlayerNB;
	}
	
	public void addPlayer() {
		this.PlayerNB++;
	}
	
	public void decPlayer() {
		this.PlayerNB --;
	}
}
