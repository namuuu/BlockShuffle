package fr.namu.bs.enumbs;

public enum BorderBS {
	  BORDER_MAX(2000, "§6Taille Bordure (Grande)"),
	  BORDER_MIN(500, "§6Taille Bordure (Petite)");
	  
	  private final String appearance;
	  
	  private int value;
	  
	  BorderBS(int value, String appearance) {
	    this.value = value;
	    this.appearance = appearance;
	  }
	  
	  public int getValue() {
	    return this.value;
	  }
	  
	  public void addValue(int value) {
		  if(this.value + value > 0) {
			  this.value = this.value + value;
		  }
	  }
	  
	  public String getAppearance() {
	    return this.appearance;
	  }
}
