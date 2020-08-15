package fr.namu.bs.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import fr.namu.bs.MainBS;
import fr.namu.bs.PlayerBS;

public class TopUtil {
	
	private MainBS main;

	private Player first = null;
	
	private Player second = null;
	
	private Player third = null;
	
	
	public TopUtil(MainBS main) {
		this.main = main;
	}
	
	public Player getFirst() {
		return this.first;
	}
	
	public Player getSecond() {
		return this.second;
	}
	
	public Player getThird() {
		return this.third;
	}


	public void refreshPoints(Player player) {
		if(first == null) {
			first = player;
			return;
		} else if (second == null && first != player) {
			second = player;
			return;
		} else if (third == null && first != player && second != player) {
			third = player;
			return;
		}
		
		PlayerBS pbs = this.main.playerbs.get(player.getUniqueId());
		if(third == null) {
			return;
		}
		PlayerBS firstbs = this.main.playerbs.get(first.getUniqueId());
		PlayerBS secondbs = this.main.playerbs.get(second.getUniqueId());
		PlayerBS thirdbs = this.main.playerbs.get(third.getUniqueId());
		if(player == first) {
			return;
		}
		if(pbs.getPoints() > firstbs.getPoints() && player != first) {
			if(player != second) {
				third = second;
			}			
			second = first;
			first = player;	
			return;
		}
		if(pbs.getPoints() > secondbs.getPoints() && player != second) {
			third = second;
			second = player;
			return;
		}
		if(pbs.getPoints() > thirdbs.getPoints()) {
			third = player;
			return;
		}
		
	}
	
	public void refreshPlayer() {
		first = null;
		second = null;
		third = null;
		
		 List<UUID> players = new ArrayList<>(this.main.playerbs.keySet());
		    for(Integer ind = 0; ind < players.size(); ind++) {
		    	Player player = Bukkit.getPlayer(players.get(ind));	    	
		    	refreshPoints(player);
		    }
	}
}
