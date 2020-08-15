package fr.namu.bs.utils;

import org.bukkit.Bukkit;
import org.bukkit.World;

import fr.namu.bs.MainBS;

public class BasicsUtil {

	public World world = Bukkit.getWorld("world");
	
	public BasicsUtil(MainBS main) {
		
	}
	
	public void setup() {
		world = Bukkit.getWorld("world");
	}
}
