package fr.namu.bs.enumbs.blocs;

import org.bukkit.Material;

public enum UpperCaveBlocs {
	
	NOTE_BLOCK("Note Block", Material.NOTE_BLOCK),
	COAL_BLOCK("Bloc de Charbon", Material.COAL_BLOCK),
	IRON_ORE("Minerai de Fer", Material.IRON_ORE),
	GOLD_ORE("Minerai d'Or", Material.GOLD_ORE),
	HOPPER("Entonnoir", Material.HOPPER),
	PISTON("Piston", Material.PISTON_BASE),
	  ;
	private final String appearance;
	
	private final Material mat;
	
	UpperCaveBlocs(String appearance, Material mat) {
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
