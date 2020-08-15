package fr.namu.bs;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.scoreboard.Scoreboard;

import fr.namu.bs.enumbs.State;

public class PlayerBS {
	private State state = State.VIVANT;
	
	Scoreboard board;
	
	private Location spawn;
	
	private String BlockName = "Attribution...";
	private Material BlockType = Material.DRAGON_EGG;
	
	private int points = 0;
	private Boolean hasFinished = false;
	
	
	public PlayerBS() {
	    this.board = Bukkit.getScoreboardManager().getNewScoreboard();
	  }

	public PlayerBS(MainBS main) {		
	}

	public Scoreboard getScoreBoard() {
	    return this.board;
	  }
	  
	  public void setScoreBoard(Scoreboard board) {
	    this.board = board;
	  }
		  
	  public void setState(State state) {
		    this.state = state;
		  }
		  
	  public boolean isState(State state) {
		    return (this.state == state);
		  }
  
	  public void setSpawn(Location spawn) {
		    this.spawn = spawn;
		  }
		  
	  public Location getSpawn() {
		    return this.spawn;
		  }
	  
	  public void setPoints(int value) {
		  this.points = value;
	  }
	  
	  public void addPoints(int value) {
		  this.points = points + value;
	  }
	  
	  public int getPoints() {
		  return this.points;
	  }
	  
	  public void setFinished(Boolean value) {
		  this.hasFinished = value;
	  }
	  
	  public Boolean isFinished() {
		  return this.hasFinished;
	  }
	  
	  public void setBlockName(String name) {
		  this.BlockName = name;
	  }
	  
	  public String getBlockName() {
		  return this.BlockName;
	  }
	  
	  public void setMaterial(Material mat) {
		  this.BlockType = mat;
	  }
	  
	  public Material getMaterial() {
		  return this.BlockType;
	  }
}


