package fr.namu.bs.listeners;

import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;

import fr.namu.bs.MainBS;
import fr.namu.bs.enumbs.StateBS;

public class DamageEvent implements Listener {

	private MainBS main;
	
	public DamageEvent(MainBS main) {
		this.main = main;
	}

	@EventHandler
	public void onPlayerDamage(EntityDamageEvent event) {
		Entity entity = event.getEntity();
		
		if(!(entity instanceof Player)) {
			return;
		}
		if(!this.main.isState(StateBS.GAME)) {
			event.setCancelled(true);
			return;
		}
		if(this.main.timer.getRound() == 1 && this.main.timer.getTimer() >= 210) {
			event.setCancelled(true);
		}
	}
}
