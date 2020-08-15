package fr.namu.bs.scoreboard;

import org.bukkit.Bukkit;

import fr.namu.bs.MainBS;
import fr.namu.bs.PlayerBS;
import fr.namu.bs.enumbs.State;
import fr.namu.bs.enumbs.StateBS;

public class ScoreBoardBS {

	private MainBS main;
	
	public ScoreBoardBS(MainBS main) {
		this.main = main;
	}

	public void updateBoardGame(FastBoard board) {
		
		String[] score = { 
	            "",
	            "Manche : §9" + this.main.timer.getRound(),
	            "Durée : §9" + this.main.timer.textTimer(),
	            "",
	            "§eClassement :",
	            "§1#1 - §f",
	            "§3#2 - §f",
	            "§b#3 - §f",
	            "",
	            "",
	            "",
	            ""
	    };
		if(this.main.top.getFirst() != null)
			score[5] = score[5] + this.main.top.getFirst().getName();
		if(this.main.top.getSecond() != null)
			score[6] = score[6] + this.main.top.getSecond().getName();
		if(this.main.top.getThird() != null)
			score[7] = score[7] + this.main.top.getThird().getName();
		
		if(this.main.playerbs.containsKey(board.getPlayer().getUniqueId()) && this.main.playerbs.get(board.getPlayer().getUniqueId()).isState(State.VIVANT)) {
			PlayerBS pbs = this.main.playerbs.get(board.getPlayer().getUniqueId());
			score[9] = "Vos points : §9" + pbs.getPoints();
			score[10] = "Bloc : §3" + score[10] + pbs.getBlockName();
		} else {
			score[9] = "§9Vous êtes Spectateur";
			score[10] = " ";
		}
				
		for (int i = 0; i < score.length; i++) {
		      StringBuilder sb = new StringBuilder();
		      sb.append(score[i]);
		      if (sb.length() > 30)
		        sb.delete(29, sb.length() - 1); 
		      score[i] = sb.toString();
		    } 
		
		board.updateLines(score);
	}

	public void updateBoardLobby(FastBoard board) {
		String[] score = { 
	            "",
	            "§eUn doute sur les règles ?",
	            "§eUtilisez §7/rules §e!",
	            "",
	            "§eNombre de joueurs :",
	            "§9" + this.main.stat.getPlayer() + "§e joueurs",
	            "",
	            "§7" + Bukkit.getIp() 
	    };
		
		
		
		for (int i = 0; i < score.length; i++) {
		      StringBuilder sb = new StringBuilder();
		      sb.append(score[i]);
		      if (sb.length() > 30)
		        sb.delete(29, sb.length() - 1); 
		      score[i] = sb.toString();
		    } 
		
		board.updateLines(score);
	}
	
	
	public void updateBoard() {
		for (FastBoard board : this.main.boards.values()) {	
			if(this.main.isState(StateBS.LOBBY)) {
				updateBoardLobby(board);
			} else {
				updateBoardGame(board);
			}
		}
	}
}
