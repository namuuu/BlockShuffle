package fr.namu.bs.utils;

import fr.namu.bs.MainBS;

public class TimerUtil {
	
	private int timeLeft = 241;
	private int round = 0;
	
	public int baseTime = 240;
	
	public TimerUtil(MainBS main) {
	}
	
	public void setTimer(int value) {
		this.timeLeft = value;
	}

	public void decTimer() {
		this.timeLeft--;
	}
	
	public int getTimer() {
		return this.timeLeft;
	}
	
	public int getBaseTime() {
		return this.baseTime;
	}
	
	public void addRound() {
		this.round++;
	}
	
	public int getRound() {
		return this.round;
	}
	
	public void resetTimer() {
		this.timeLeft = baseTime;
		this.round++;
	}
	
	public int timeUsed() {
		return this.baseTime - this.timeLeft;
	}
	
	public String timeUsedText() {
		return this.conversion(timeUsed());
	}
	
	public String textTimer() {
		String valeur;
		if (timeLeft % 60 > 9) {
			valeur = (timeLeft % 60) + "s";
		} else {
			valeur = "0" + (timeLeft % 60) + "s";
		} 
		if (timeLeft / 3600 > 0) {
			if (timeLeft % 3600 / 60 > 9) {
				valeur = (timeLeft / 3600) + "h" + (timeLeft % 3600 / 60) + "m" + valeur;
			} else {
				valeur = (timeLeft / 3600) + "h0" + (timeLeft % 3600 / 60) + "m" + valeur;
			} 
		} else if (timeLeft / 60 > 0) {
			valeur = (timeLeft / 60) + "m" + valeur;
		} 
		return valeur;
	}
	
	public String conversion(int timer) {
		String valeur;
		if (timer % 60 > 9) {
			valeur = (timer % 60) + "s";
		} else {
			valeur = "0" + (timer % 60) + "s";
		} 
		if (timer / 3600 > 0) {
			if (timer % 3600 / 60 > 9) {
				valeur = (timer / 3600) + "h" + (timer % 3600 / 60) + "m" + valeur;
			} else {
				valeur = (timer / 3600) + "h0" + (timer % 3600 / 60) + "m" + valeur;
			} 
		} else if (timer / 60 > 0) {
			valeur = (timer / 60) + "m" + valeur;
		} 
		return valeur;
	}
}
