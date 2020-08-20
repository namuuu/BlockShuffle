package fr.namu.bs.listeners;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

import fr.namu.bs.MainBS;
import fr.namu.bs.PlayerBS;
import fr.namu.bs.enumbs.State;
import fr.namu.bs.enumbs.StateBS;

public class ChatEvent implements Listener {
	
	private MainBS main;
	
	public ChatEvent(MainBS main) {
		this.main = main;
	}

	@EventHandler
	public void onChatEvent(AsyncPlayerChatEvent event) {
		Player player = event.getPlayer();
		
		if (this.main.isState(StateBS.LOBBY)) {
			event.setFormat("§e" + player.getName() + " §7» §7" + event.getMessage());
			return;
		} 
		
		PlayerBS pbs = this.main.playerbs.get(player.getUniqueId());
			
		if(pbs.isState(State.VIVANT)) {
			if(pbs.isFinished()) {
				event.setFormat("§7[" + pbs.getBlockName() + " | " + pbs.getPoints() + "§7] §a" + player.getName() + " §7» " + event.getMessage());
				return;
			}
			event.setFormat("§7[" + pbs.getBlockName() + " | " + pbs.getPoints() + "§7] §c" + player.getName() + " §7» " + event.getMessage());
			return;
		}
		event.setFormat("§7[SPEC] " + player.getName() + " » " + event.getMessage());		
	}
}
