package fr.namu.bs;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.bukkit.command.CommandExecutor;
import org.bukkit.event.Listener;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import fr.namu.bs.enumbs.StateBS;
import fr.namu.bs.scoreboard.FastBoard;
import fr.namu.bs.scoreboard.ScoreBoardBS;
import fr.namu.bs.utils.*;
import fr.namu.bs.listeners.*;
import fr.namu.bs.commandbs.*;

public class MainBS extends JavaPlugin {
	
	public final Map<UUID, FastBoard> boards = new HashMap<>();
	public final Map<UUID, PlayerBS> playerbs = new HashMap<>();
	
	private StateBS state;
	
	public final ScoreBoardBS score = new ScoreBoardBS(this);
	
	public final BasicsUtil basic = new BasicsUtil(this);
	public final BlockUtil bloc = new BlockUtil(this);
	public final LaunchUtil launch = new LaunchUtil(this);
	public final SetWorldUtil SetWorldUtil = new SetWorldUtil(this);
	public final StatUtil stat = new StatUtil(this);
	public final TimerUtil timer = new TimerUtil(this);
	public final TopUtil top = new TopUtil(this);
	public final EndUtil end = new EndUtil(this);
	
	@Override
	public void onEnable() {
		SetWorldUtil.setWorld();
		enableListeners();
		enableCommands();
	}
	
	@Override
	public void onDisable() {
		 
	}
	
	public void enableListeners() {
		PluginManager pm = getServer().getPluginManager();
		pm.registerEvents((Listener)new DamageEvent(this), (Plugin)this);
		pm.registerEvents((Listener)new DeathEvent(this), (Plugin)this);
		pm.registerEvents((Listener)new ClickEvent(this), (Plugin)this);
		pm.registerEvents((Listener)new ChatEvent(this), (Plugin)this);
		pm.registerEvents((Listener)new JoinLeaveEvent(this), (Plugin)this);
	}
	
	public void enableCommands() {
		getCommand("host").setExecutor((CommandExecutor)new HostCMD(this));
		getCommand("rules").setExecutor((CommandExecutor)new RulesCMD(this));
		getCommand("h").setExecutor((CommandExecutor)new HostCMD(this));
		getCommand("block").setExecutor((CommandExecutor)new BlockCMD(this));
	}
	
	
	public void setState(StateBS state) {
		this.state = state;
	}
	public Boolean isState(StateBS state) {
		return this.state == state;
	}
}
