package fr.namu.bs.enumbs.blocs;

import org.bukkit.Material;

public enum HarderSurfaceBlocs {
	STAINED_GLASS("Verre teinté", Material.STAINED_GLASS),
	BRICK("Briques", Material.BRICK),
	BOOKSHELF("Bibliothèques", Material.BOOKSHELF),
	ICE("Bloc de glace", Material.ICE),
			
	  ;
	private final String appearance;
	
	private final Material mat;
	
	HarderSurfaceBlocs(String appearance, Material mat) {
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
