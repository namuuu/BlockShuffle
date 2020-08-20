package fr.namu.bs.utils;

import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.entity.Player;

import fr.namu.bs.MainBS;
import fr.namu.bs.PlayerBS;
import fr.namu.bs.enumbs.State;
import fr.namu.bs.enumbs.StateBS;

public class PlayersUtil {

	private MainBS main;	
	
	public PlayersUtil(MainBS main) {
		
	}

	public void setWaitPlayer(Player player) {
		if(!this.main.isState(StateBS.LOBBY)) {
			return;
		}
		
		PlayerBS pbs = this.main.playerbs.get(player.getUniqueId());
		pbs.setState(State.VIVANT);
		player.setGameMode(GameMode.ADVENTURE);
		player.teleport(this.main.basic.world.getSpawnLocation());
		this.main.stat.addPlayer();	
	}
	
	public void setSpecPlayer(Player player) {
		PlayerBS pbs = this.main.playerbs.get(player.getUniqueId());
		pbs.setPoints(0);
		pbs.setMaterial(Material.DRAGON_EGG);
		pbs.setState(State.SPEC);
		player.setGameMode(GameMode.SPECTATOR);
		player.teleport(this.main.basic.world.getSpawnLocation());
		this.main.stat.decPlayer();
	}
}
