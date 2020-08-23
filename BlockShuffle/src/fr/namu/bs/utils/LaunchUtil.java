package fr.namu.bs.utils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.World;
import org.bukkit.WorldBorder;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.Plugin;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import fr.namu.bs.MainBS;
import fr.namu.bs.PlayerBS;
import fr.namu.bs.enumbs.BorderBS;
import fr.namu.bs.enumbs.State;
import fr.namu.bs.enumbs.StateBS;
import fr.namu.bs.runnable.BlockRun;
import fr.namu.bs.runnable.GameRun;

public class LaunchUtil {

	private MainBS main;
	
	public LaunchUtil(MainBS main) {
		this.main = main;	
	}


	public void startGame() {
		if(!this.main.isState(StateBS.LOBBY)) {
			return;
		}
		
		this.main.setState(StateBS.TP);
	    this.main.score.updateBoardGame();
	    
	    World world = this.main.basic.world;
	    WorldBorder wb = world.getWorldBorder();
	    world.setTime(0L);
	    wb.setCenter(world.getSpawnLocation().getX(), world.getSpawnLocation().getZ());
	    wb.setSize(BorderBS.BORDER_MAX.getValue());
	    wb.setWarningDistance((int)(wb.getSize() / 7.0D));
	    
	    List<UUID> players = new ArrayList<>(this.main.playerbs.keySet());
	    Collections.shuffle(players);
	    for(Integer ind = 0; ind < players.size(); ind++) {
	    	Player player = Bukkit.getPlayer(players.get(ind));
	    	PlayerBS pbs = this.main.playerbs.get(player.getUniqueId());	    	
	        if (pbs.isState(State.VIVANT)) {
	        	player.playSound(player.getLocation(), Sound.ORB_PICKUP, 1.0F, 20.0F);    	
	        	player.getInventory().clear();
	        	player.getInventory().setItem(8, new ItemStack(Material.COOKED_BEEF, 16));
	        	player.setGameMode(GameMode.SURVIVAL);
	        	teleport(player, ind);
	        	for (PotionEffect po : player.getActivePotionEffects())
	        		player.removePotionEffect(po.getType()); 
	        	player.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, Integer.MAX_VALUE, 255));
	        	player.addPotionEffect(new PotionEffect(PotionEffectType.JUMP, Integer.MAX_VALUE, 200));
	        }
	    } 
	    this.main.setState(StateBS.GAME);
	    
	    GameRun startGame = new GameRun(this.main);
	    startGame.runTaskTimer((Plugin)this.main, 0L, 20L);
	    BlockRun startBlock = new BlockRun(this.main);
	    startBlock.runTaskTimer((Plugin)this.main, 0L, this.main.timer.getBaseTime()*20L);	    
	    
	    this.main.getServer().getScheduler().scheduleSyncDelayedTask(this.main, new Runnable() {
			public void run() {
				Bukkit.broadcastMessage("§9B§eS §7» Vous ne connaissez pas le bloc en question ? Faites /block pour le visualiser !");
			}
		}, 200L);
	}
	
	
	public void teleport(Player player, double d) {
			World world = player.getWorld();
			WorldBorder wb = world.getWorldBorder();
			double a = d * 2.0D * Math.PI / Bukkit.getOnlinePlayers().size();
			int x = (int)Math.round(wb.getSize() / 3.0D * Math.cos(a) + world.getSpawnLocation().getX());
			int z = (int)Math.round(wb.getSize() / 3.0D * Math.sin(a) + world.getSpawnLocation().getZ());
			Location spawnp = new Location(world, x, (world.getHighestBlockYAt(x, z) + 1), z);
			((PlayerBS)this.main.playerbs.get(player.getUniqueId())).setSpawn(spawnp.clone());
			spawnp.setY(spawnp.getY() + 100.0D); 
			player.setGameMode(GameMode.SURVIVAL);
			player.teleport(spawnp);
			/*PaperLib.teleportAsync(player, spawnp).thenAccept(result -> {
				if (result) {
					Bukkit.broadcastMessage("§7Téléportation du joueur : " + player.getName() + "§7...");
				}
			});*/
			setPlatform(player);
	} 
	
	public void setPlatform(Player player) {
		World world = this.main.basic.world;
		Location ploc = player.getLocation();
		world.getBlockAt(ploc.getBlockX() - 1, ploc.getBlockY() - 1, ploc.getBlockZ() - 1).setType(Material.BARRIER);
		world.getBlockAt(ploc.getBlockX()    , ploc.getBlockY() - 1, ploc.getBlockZ() - 1).setType(Material.BARRIER);
		world.getBlockAt(ploc.getBlockX() - 1, ploc.getBlockY() - 1, ploc.getBlockZ()    ).setType(Material.BARRIER);
		world.getBlockAt(ploc.getBlockX()    , ploc.getBlockY() - 1, ploc.getBlockZ()    ).setType(Material.BARRIER);	
	}
	
	public void removePlatform(Player player) {
		World world = this.main.basic.world;
		Location ploc = player.getLocation();
		world.getBlockAt(ploc.getBlockX() - 1, ploc.getBlockY() - 1, ploc.getBlockZ() - 1).setType(Material.AIR);
		world.getBlockAt(ploc.getBlockX()    , ploc.getBlockY() - 1, ploc.getBlockZ() - 1).setType(Material.AIR);
		world.getBlockAt(ploc.getBlockX() - 1, ploc.getBlockY() - 1, ploc.getBlockZ()    ).setType(Material.AIR);
		world.getBlockAt(ploc.getBlockX()    , ploc.getBlockY() - 1, ploc.getBlockZ()    ).setType(Material.AIR);	
	}
}
