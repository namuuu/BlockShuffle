package fr.namu.bs.listeners;

import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import fr.namu.bs.MainBS;
import fr.namu.bs.PlayerBS;

public class DeathEvent implements Listener {

	private MainBS main;
	
	public DeathEvent(MainBS main) {
		this.main = main;
	}

	@EventHandler
	public void onPlayerDeath(PlayerDeathEvent event) {
		
		Player player = (Player)event.getEntity();
		
		PlayerBS pbs = this.main.playerbs.get(player.getUniqueId());
		
		event.setDeathMessage("");
		
		if(pbs.getSpawn() == null) {
			pbs.setSpawn(Bukkit.getWorld("world").getHighestBlockAt(0, 0).getLocation());
		} 
		
		player.addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, 100, 255));
		player.setHealth(20);
		player.setFoodLevel(20);
		player.teleport(pbs.getSpawn());
		player.playSound(player.getLocation(), Sound.AMBIENCE_THUNDER, 1.0F, 1.0F);
		player.sendMessage("§cVous êtes mort ! Par conséquent, vous revenez à votre point de départ.... Mais sans équipement !");		
	}
}
