package fr.namu.bs.listeners;

import org.bukkit.GameMode;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import fr.namu.bs.MainBS;
import fr.namu.bs.PlayerBS;
import fr.namu.bs.enumbs.State;
import fr.namu.bs.enumbs.StateBS;
import fr.namu.bs.scoreboard.FastBoard;
import fr.namu.bs.scoreboard.Title;

public class JoinLeaveEvent implements Listener {
	
	private MainBS main;

	public JoinLeaveEvent(MainBS main) {
		this.main = main;
	}

	@EventHandler
	public void onPlayerJoin(PlayerJoinEvent event) {
		
		Player player = event.getPlayer();
		this.main.playerbs.put(player.getUniqueId(), new PlayerBS()); 
		PlayerBS pbs = this.main.playerbs.get(player.getUniqueId());
		
		player.setMaxHealth(20.0D);
		player.setHealth(20.0D);
		player.setExp(0.0F);
		player.setLevel(0);
		player.getInventory().clear();
		player.getInventory().setArmorContents(null);
		player.teleport(this.main.basic.world.getSpawnLocation());
		player.sendMessage("§7══════════════════════════════");
		player.sendMessage("      §7» §l§9BLOCK §eSHUFFLE §r§7«");
		player.sendMessage(" ");
		player.sendMessage("§eBienvenue dans §aBlock Shuffle §e! Au début de chaque manche, un §abloc te sera attribué.");
		player.sendMessage("§eSois le plus rapide à te positionner sur ce bloc pour remporter §ale maximum de points §e!");
		player.sendMessage("§ePlus les manches avanceront, plus les blocs à obtenir seront §adifficiles à trouver §e!");
		player.sendMessage("§eLe premier joueur à atteindre §a250 points §egagne !");
		player.sendMessage("§7══════════════════════════════");
		for (PotionEffect po : player.getActivePotionEffects())
			player.removePotionEffect(po.getType()); 
		player.addPotionEffect(new PotionEffect(PotionEffectType.SATURATION, 2147483647, 0, false, false));	
		
		if(this.main.isState(StateBS.LOBBY)) {		
			pbs.setState(State.VIVANT);	
			player.setGameMode(GameMode.ADVENTURE);
			this.main.stat.addPlayer();	
			event.setJoinMessage("§a+ §7» §e"+ event.getPlayer().getName());
			
		} else {
			if(this.main.playerbs.containsKey(player.getUniqueId())) {
				this.main.playerbs.get(player.getUniqueId()).setState(State.SPEC);
			}			
			player.setGameMode(GameMode.SPECTATOR);						
			event.setJoinMessage("§7+ » "+ event.getPlayer().getName());
		}
		
		FastBoard fastboard = new FastBoard(player);
	    fastboard.updateTitle("§9Block §eShuffle");
	    this.main.boards.put(player.getUniqueId(), fastboard);
	    this.main.score.updateBoard();
	    Title.sendTabTitle(player, "§9Block §eShuffle", " ", "§eCe Plugin a été développé par §9Namu §7(@Namu.#5363)", "", "§9Nore site: §ehttps://nontia.fr/", " ");
	    
	}
	
	@EventHandler
	public void onPlayerQuit(PlayerQuitEvent event) {	
		Player player = event.getPlayer();
		
		event.setQuitMessage("§c- §7» §e"+ event.getPlayer().getName());
		
		if(this.main.isState(StateBS.LOBBY)) {		
			this.main.score.updateBoard();
			if(this.main.playerbs.containsKey(player.getUniqueId())) {
				this.main.stat.decPlayer();
				this.main.boards.remove(player.getUniqueId());
				this.main.playerbs.remove(player.getUniqueId());
			}
		} else {
			if(this.main.playerbs.containsKey(player.getUniqueId())) {
				this.main.stat.decPlayer();
				this.main.playerbs.get(player.getUniqueId()).setState(State.SPEC);
				this.main.boards.remove(player.getUniqueId());
				this.main.playerbs.remove(player.getUniqueId());
				this.main.top.refreshPlayer();
			}
		}
	}
	
}
