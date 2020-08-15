package fr.namu.bs.enumbs.blocs;

import org.bukkit.Material;

public enum SurfaceBlocs {
	
	WOOD("Bois", Material.WOOD),
	SAND("Sable", Material.SAND),
	GRAVEL("Gravier", Material.GRAVEL),
	WOOL("Laine", Material.WOOL),
	SNOW("Neige", Material.SNOW_BLOCK),
	COAL_ORE("Charbon", Material.COAL_ORE),
	CLAY("Clay", Material.CLAY),
	FURNACE("Four", Material.FURNACE),
	  ;
	private final String appearance;
	
	private final Material mat;
	
	SurfaceBlocs(String appearance, Material mat) {
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
