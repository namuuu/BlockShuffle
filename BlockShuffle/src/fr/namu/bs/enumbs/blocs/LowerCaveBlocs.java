package fr.namu.bs.enumbs.blocs;

import org.bukkit.Material;

public enum LowerCaveBlocs {
	
	JUKEBOX("Jukebox", Material.JUKEBOX),
	GOLD_BLOCK("Bloc d'Or", Material.GOLD_BLOCK),
	OBSIDIAN("Obsidienne", Material.OBSIDIAN),
	ANVIL("Enclume", Material.ANVIL),
	LAPIS_BLOCK("Bloc de Lapis", Material.LAPIS_BLOCK),
	
	  ;
	private final String appearance;
	
	private final Material mat;
	
	LowerCaveBlocs(String appearance, Material mat) {
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
