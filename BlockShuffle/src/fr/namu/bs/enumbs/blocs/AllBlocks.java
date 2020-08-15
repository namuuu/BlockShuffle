package fr.namu.bs.enumbs.blocs;

import org.bukkit.Material;

public enum AllBlocks {
	
	STAINED_GLASS("Verre teinté", Material.STAINED_GLASS),
	BRICK("Briques", Material.BRICK),
	BOOKSHELF("Bibliothèques", Material.BOOKSHELF),
	ICE("Bloc de glace", Material.ICE),
	JUKEBOX("Bois", Material.JUKEBOX),
	GOLD_BLOCK("Bloc d'Or", Material.GOLD_BLOCK),
	OBSIDIAN("Obsidienne", Material.OBSIDIAN),
	ANVIL("Enclume", Material.ANVIL),
	QUARTZ_BLOCK("Bloc de Quartz", Material.QUARTZ_BLOCK),
	NETHER_BRICK("Brique du Nether", Material.NETHER_BRICK),
	SPAWNER("Spawner", Material.MOB_SPAWNER),
	REDSTONE_LAMP("Lamp de Redstone", Material.REDSTONE_LAMP_OFF),
	WOOD("Bois", Material.WOOD),
	SAND("Sable", Material.SAND),
	GRAVEL("Gravier", Material.GRAVEL),
	WOOL("Laine", Material.WOOL),
	SNOW("Neige", Material.SNOW_BLOCK),
	COAL_ORE("Charbon", Material.COAL_ORE),
	CLAY("Clay", Material.CLAY),
	FURNACE("Four", Material.FURNACE),
	NOTE_BLOCK("Note Block", Material.NOTE_BLOCK),
	COAL_BLOCK("Bloc de Charbon", Material.COAL_BLOCK),
	IRON_ORE("Minerai de Fer", Material.IRON_ORE),
	GOLD_ORE("Minerai d'Or", Material.GOLD_ORE),
	PISTON("Pîston", Material.PISTON_BASE),
	
	  ;
	private final String appearance;
	
	private final Material mat;
	
	AllBlocks(String appearance, Material mat) {
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

