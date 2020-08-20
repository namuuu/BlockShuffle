package fr.namu.bs.utils;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

import org.bukkit.Bukkit;
import fr.namu.bs.MainBS;

public class TopUtil {
	
	private MainBS main;
	
	public TopUtil(MainBS main) {
		this.main = main;
	}
	
	public String getPlayerTop(Integer place) {
		for (Map.Entry<String, Integer> entry : getTop().entrySet()) {
			int rank = 1;
			if(rank == place && entry.getValue() != 0) {
				return entry.getKey();
			}
		}
		return "";
		/*List<UUID> players = new ArrayList<>(this.main.playerbs.keySet());
		    for(Integer ind = 0; ind < players.size(); ind++) {
		    	Player player = Bukkit.getPlayer(players.get(ind));	    	
		    	refreshPoints(player);
		    }*/
	}
	
	public Map<String, Integer> getTop() {
		Map<String, Integer> stats = new HashMap<>();
		   this.main.playerbs.keySet().forEach(UUID -> stats.put(Bukkit.getPlayer(UUID).getName(), this.main.playerbs.get(UUID).getPoints()));
		   //this.main.basic.sb.getEntries().forEach(playerName -> stats.put(playerName, this.main.basic.obj.getScore(playerName).getScore()));
		   
		   return stats.entrySet()
				   .stream()
				   .sorted((Map.Entry.<String, Integer>comparingByValue().reversed()))
				   .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));
	}
}
