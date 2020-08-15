package fr.namu.bs.utils;

import org.bukkit.Bukkit;
import org.bukkit.Color;
import org.bukkit.FireworkEffect;
import org.bukkit.GameMode;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Firework;
import org.bukkit.entity.Player;
import org.bukkit.inventory.meta.FireworkMeta;

import fr.namu.bs.MainBS;
import fr.namu.bs.enumbs.StateBS;

public class EndUtil {

	
	private MainBS main;
	
	public EndUtil(MainBS main) {
		this.main = main;
	}

	public void win(Player player) {
		this.main.setState(StateBS.FIN);
		Bukkit.broadcastMessage("§9" + player.getName() + "§e remporte la partie ! Félécitations à lui, et nous vous remercions d'avoir joué !");
		
		for(Player players : Bukkit.getOnlinePlayers()) {
			if(players != player) {
				players.setGameMode(GameMode.SPECTATOR);
				players.teleport(player);
			}
		}		
		
		firework(player);
		
		this.main.getServer().getScheduler().scheduleSyncDelayedTask(this.main, new Runnable() {
			public void run() {
				Bukkit.shutdown();
			}
		}, 500L);
	}
	
	 public void firework(Player player){
		    Firework fw = (Firework)player.getWorld().spawnEntity(player.getLocation(), EntityType.FIREWORK);
		    FireworkMeta fwmeta = fw.getFireworkMeta();
		    FireworkEffect.Builder builder = FireworkEffect.builder();
		    builder.withTrail();
		    builder.withFlicker();
		    builder.withColor(Color.FUCHSIA);
		    builder.withColor(Color.GREEN);
		    builder.withColor(Color.LIME);
		    builder.withColor(Color.BLUE);
		    builder.withColor(Color.MAROON);
		    builder.withColor(Color.ORANGE);
		    builder.withColor(Color.PURPLE);
		    builder.withColor(Color.WHITE);
		    builder.with(FireworkEffect.Type.BALL_LARGE);
		    fwmeta.addEffects(new FireworkEffect[] { builder.build() });
		    fwmeta.setPower((int).9);
		    fw.setFireworkMeta(fwmeta);
		  }
}
