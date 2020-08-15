package fr.namu.bs.enumbs.blocs;

import org.bukkit.Material;

public enum NetherBlocs {
	QUARTZ_BLOCK("Bloc de Quartz", Material.QUARTZ_BLOCK),
	NETHER_BRICK("Brique du Nether", Material.NETHER_BRICK),
	SPAWNER("Spawner", Material.MOB_SPAWNER),
	REDSTONE_LAMP("Lamp de Redstone", Material.REDSTONE_LAMP_OFF),
	SANDSTONE("Sable des Âmes", Material.SOUL_SAND),
	BREWING_STAND("Alambic", Material.BREWING_STAND),
	
	  ;
	private final String appearance;
	
	private final Material mat;
	
	NetherBlocs(String appearance, Material mat) {
		  this.appearance = appearance;
		  this.mat = mat;
	}
	  
	public String getName() {
		return this.appearance;
	}
	  
	public Material getMaterial() {
		return this.mat;
	}
}
