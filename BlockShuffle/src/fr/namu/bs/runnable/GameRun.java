package fr.namu.bs.runnable;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.scheduler.BukkitRunnable;

import fr.namu.bs.MainBS;

public class GameRun extends BukkitRunnable {

	private MainBS main;
	
	public GameRun(MainBS main) {
		this.main = main;
	}

	public void run() {
		this.main.timer.decTimer();
		this.main.score.updateBoardGame();
		
		if(this.main.timer.getTimer() == 235) {
			if(this.main.timer.getRound() == 1) {
				List<UUID> players = new ArrayList<>(this.main.playerbs.keySet());
				for(Integer ind = 0; ind < players.size(); ind++) {
					Player player = Bukkit.getPlayer(players.get(ind));
					this.main.launch.removePlatform(player);
					for (PotionEffect po : player.getActivePotionEffects())
			            player.removePotionEffect(po.getType()); 
				}
			}
		}
		
		this.main.bloc.verifyBlock();
	}
}
