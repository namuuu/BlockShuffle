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

	public void BoardGame(FastBoard board) {
		
		String[] score = { 
	            "",
	            "Manche : §9" + this.main.timer.getRound(),
	            "Durée : §9" + this.main.timer.textTimer(),
	            "",
	            "§eClassement :",
	            "§1#1 - §f" + this.main.top.getPlayerTop(1),
	            "§3#2 - §f" + this.main.top.getPlayerTop(2),
	            "§b#3 - §f" + this.main.top.getPlayerTop(3),
	            "",
	            "",
	            "",
	            ""
	    };
		PlayerBS pbs = this.main.playerbs.get(board.getPlayer().getUniqueId());
		
		if(pbs.isState(State.VIVANT)) {		
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

	public void BoardLobby(FastBoard board) {
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
				BoardLobby(board);
			} else {
				BoardGame(board);
			}
		}
	}
	
	public void updateBoardLobby() {
		for (FastBoard board : this.main.boards.values()) {
			BoardLobby(board);
		}
	}
	
	public void updateBoardGame() {
		for (FastBoard board : this.main.boards.values()) {
			BoardGame(board);
		}
	}
}
