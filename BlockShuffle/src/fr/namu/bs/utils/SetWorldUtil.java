package fr.namu.bs.utils;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import fr.namu.bs.MainBS;
import fr.namu.bs.enumbs.StateBS;

public class SetWorldUtil {
	
	private MainBS main;
	
	public SetWorldUtil(MainBS main) {
		this.main = main;
	}

	public void setWorld() {
	    try {
		      World world = this.main.basic.world;
		      world.setPVP(false);
		      world.setWeatherDuration(0);
		      world.setThunderDuration(0);
		      world.setTime(0L);
		      world.getWorldBorder().reset();
		      int x = 0; //(int)world.getSpawnLocation().getX();
		      int z = 0; //(int)world.getSpawnLocation().getZ();
		      int y = 90; //(int)world.getSpawnLocation().getY(); 
		      world.setSpawnLocation(x, y, z); // 184
		      for (int i = -16; i <= 16; i++) {
		        for (int j = -16; j <= 16; j++) {
		        	(new Location(world, (i + x), y-1, (j + z))).getBlock().setType(Material.BARRIER);
		        	(new Location(world, (i + x), y+3, (j + z))).getBlock().setType(Material.BARRIER);
		        } 
		        (new Location(world, (i + x), y  , (z - 16))).getBlock().setType(Material.BARRIER);
		        (new Location(world, (i + x), y+1, (z - 16))).getBlock().setType(Material.BARRIER);
		        (new Location(world, (i + x), y+3, (z - 16))).getBlock().setType(Material.BARRIER);
		        (new Location(world, (i + x), y  , (z + 16))).getBlock().setType(Material.BARRIER);
		        (new Location(world, (i + x), y+1, (z + 16))).getBlock().setType(Material.BARRIER);
		        (new Location(world, (i + x), y+2, (z + 16))).getBlock().setType(Material.BARRIER);
		        (new Location(world, (x - 16), y  , (i + z))).getBlock().setType(Material.BARRIER);
		        (new Location(world, (x - 16), y+1, (i + z))).getBlock().setType(Material.BARRIER);
		        (new Location(world, (x - 16), y+2, (i + z))).getBlock().setType(Material.BARRIER);
		        (new Location(world, (x + 16), y  , (i + z))).getBlock().setType(Material.BARRIER);
		        (new Location(world, (x + 16), y+1, (i + z))).getBlock().setType(Material.BARRIER);
		        (new Location(world, (x + 16), y+2, (i + z))).getBlock().setType(Material.BARRIER);
		      }		      		      
		      this.main.setState(StateBS.LOBBY);
		    } catch (Exception e) {
		    	Bukkit.broadcastMessage(ChatColor.RED + "Une erreur est survenue. Le Plugin BlockShuffle n'a pas pu charger.");
		    }
	}
	
}
