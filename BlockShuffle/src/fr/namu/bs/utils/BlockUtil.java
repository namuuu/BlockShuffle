package fr.namu.bs.utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Sound;
import org.bukkit.entity.Player;

import fr.namu.bs.MainBS;
import fr.namu.bs.PlayerBS;
import fr.namu.bs.enumbs.State;
import fr.namu.bs.enumbs.blocs.AllBlocks;
import fr.namu.bs.enumbs.blocs.HarderSurfaceBlocs;
import fr.namu.bs.enumbs.blocs.LowerCaveBlocs;
import fr.namu.bs.enumbs.blocs.NetherBlocs;
import fr.namu.bs.enumbs.blocs.SurfaceBlocs;
import fr.namu.bs.enumbs.blocs.UpperCaveBlocs;
import fr.namu.bs.scoreboard.Title;

public class BlockUtil {

	private MainBS main;
	
	List<SurfaceBlocs> SurfaceList = Arrays.asList(SurfaceBlocs.values());
	List<HarderSurfaceBlocs> HSurfaceList = Arrays.asList(HarderSurfaceBlocs.values());
	List<UpperCaveBlocs> UCaveList = Arrays.asList(UpperCaveBlocs.values());
	List<LowerCaveBlocs> LCaveList = Arrays.asList(LowerCaveBlocs.values());
	List<NetherBlocs> NetherList = Arrays.asList(NetherBlocs.values());
	List<AllBlocks> Alllist = Arrays.asList(AllBlocks.values());
	
	private Random random = new Random();
	
	public BlockUtil(MainBS main) {
		this.main = main;
	}

	
	public void BlockSelect() {
		int round = this.main.timer.getRound();
		List<UUID> players = new ArrayList<>(this.main.playerbs.keySet());	     	
		if(round <= 1) {	    		
			SurfaceBlocs(players);
		} else if (round <= 2 && round > 1) {	   		
			HarderSurfaceBlocs(players);
		} else if (round <= 4 && round > 2) {	
			UpperCaveBlocs(players);
		} else if (round <= 6 && round > 4) {	    		
			LowerCaveBlocs(players);
		}  else if (round <= 8 && round > 4) {	    		
			NetherBlocs(players);
		}  else if (round > 8){	    		
			AllBlocks(players);
		}  
	}
	
	public void verifyBlock() {
		List<UUID> players = new ArrayList<>(this.main.playerbs.keySet());
	    for(Integer ind = 0; ind < players.size(); ind++) {
	    	Player player = Bukkit.getPlayer(players.get(ind));
	    	PlayerBS pbs = this.main.playerbs.get(player.getUniqueId());
	    	Location ploc = player.getLocation();
	    	ploc.setY(ploc.getBlockY() - 0.4);
	    	if(!pbs.isFinished() && pbs.isState(State.VIVANT)) {
	    		Title.sendActionBar(player, "§eVotre bloc : §9" + pbs.getBlockName());
	    		if(ploc.getBlock().getType() == pbs.getMaterial() || player.getLocation().getBlock().getType() == pbs.getMaterial()) {
	    			Bukkit.broadcastMessage("§a"+ player.getName() + " §ea terminé son objectif en §9" + this.main.timer.timeUsedText() + " ! §7(" + pbs.getBlockName() + ")");
		    		player.playSound(player.getLocation(), Sound.LEVEL_UP, 1.5F, 1.0F);
		    		pbs.addPoints(pbs.getPoints() + 15 + Math.round(300 / this.main.timer.timeUsed()));
		    		pbs.setFinished(true);
		    		this.main.top.refreshPoints(player);
		    		player.setPlayerListName("§7[" + pbs.getBlockName() + " | " + pbs.getPoints() + "§7] §a" + player.getName());
		    		if(pbs.getPoints() >= 200) {
		    			this.main.end.win(player);
		    		}
	    		}
	    	}
	    }
	}
	
	public void announcePlayers() {
		List<UUID> players = new ArrayList<>(this.main.playerbs.keySet());
	    for(Integer ind = 0; ind < players.size(); ind++) {
	    	Player player = Bukkit.getPlayer(players.get(ind));
	    	PlayerBS pbs = this.main.playerbs.get(player.getUniqueId());
	    	if(pbs.isFinished() == false) {
	    		Bukkit.broadcastMessage("§c" + player.getName() + " §en'a pas fini son objectif ! §7(" + pbs.getBlockName() + ")");
	    	}
	    }
	}
	
	public void SurfaceBlocs(List<UUID> players) {
		for(Integer ind = 0; ind < players.size(); ind++) {
			Player player = Bukkit.getPlayer(players.get(ind));
			PlayerBS pbs = this.main.playerbs.get(players.get(ind));
			SurfaceBlocs bloc = SurfaceList.get(random.nextInt(SurfaceList.size()));	
			pbs.setBlockName(bloc.getName());
    		pbs.setMaterial(bloc.getMaterial());
    		pbs.setFinished(false);
    		player.sendMessage("§bOn vous a attribué un nouveau bloc ! Celui est : §9" + pbs.getBlockName());
    		player.setPlayerListName("§7[" + pbs.getBlockName() + " | " + pbs.getPoints() + "§7] §c" + player.getName());
    		
		}
	}
	
	public void HarderSurfaceBlocs(List<UUID> players) {
		for(Integer ind = 0; ind < players.size(); ind++) {
			Player player = Bukkit.getPlayer(players.get(ind));
			PlayerBS pbs = this.main.playerbs.get(players.get(ind));
			if(pbs.isState(State.VIVANT)) {
				HarderSurfaceBlocs bloc = HSurfaceList.get(random.nextInt(HSurfaceList.size()));	
				pbs.setBlockName(bloc.getName());
				pbs.setMaterial(bloc.getMaterial());
				pbs.setFinished(false);  				   	
				player.sendMessage("§bOn vous a attribué un nouveau bloc ! Celui est : §9" + pbs.getBlockName());
				player.setPlayerListName("§7[" + pbs.getBlockName() + " | " + pbs.getPoints() + "§7] §c" + player.getName());
			}
		}
	}
	
	public void UpperCaveBlocs(List<UUID> players) {
		for(Integer ind = 0; ind < players.size(); ind++) {
			Player player = Bukkit.getPlayer(players.get(ind));
			PlayerBS pbs = this.main.playerbs.get(players.get(ind));
			if(pbs.isState(State.VIVANT)) {
				UpperCaveBlocs bloc = UCaveList.get(random.nextInt(UCaveList.size()));
				pbs.setBlockName(bloc.getName());
				pbs.setMaterial(bloc.getMaterial());
				pbs.setFinished(false);
				player.sendMessage("§bOn vous a attribué un nouveau bloc ! Celui est : §9" + pbs.getBlockName());
				player.setPlayerListName("§7[" + pbs.getBlockName() + " | " + pbs.getPoints() + "§7] §c" + player.getName());
			}
		}
	}
	
	public void LowerCaveBlocs(List<UUID> players) {
		for(Integer ind = 0; ind < players.size(); ind++) {
			Player player = Bukkit.getPlayer(players.get(ind));
			PlayerBS pbs = this.main.playerbs.get(players.get(ind));
			if(pbs.isState(State.VIVANT)) {
				LowerCaveBlocs bloc = LCaveList.get(random.nextInt(LCaveList.size()));
				pbs.setBlockName(bloc.getName());
				pbs.setMaterial(bloc.getMaterial());    	
				pbs.setFinished(false);
				player.sendMessage("§bOn vous a attribué un nouveau bloc ! Celui est : §9" + pbs.getBlockName());
				player.setPlayerListName("§7[" + pbs.getBlockName() + " | " + pbs.getPoints() + "§7] §c" + player.getName());
			}
		}
	}
	
	public void NetherBlocs(List<UUID> players) {
		for(Integer ind = 0; ind < players.size(); ind++) {
			Player player = Bukkit.getPlayer(players.get(ind));
			PlayerBS pbs = this.main.playerbs.get(players.get(ind));
			if(pbs.isState(State.VIVANT)) {
				NetherBlocs bloc = NetherList.get(random.nextInt(NetherList.size()));
				pbs.setBlockName(bloc.getName());
				pbs.setMaterial(bloc.getMaterial());    	
				pbs.setFinished(false);
				player.sendMessage("§bOn vous a attribué un nouveau bloc ! Celui est : §9" + pbs.getBlockName());
				player.setPlayerListName("§7[" + pbs.getBlockName() + " | " + pbs.getPoints() + "§7] §c" + player.getName());
			}
		}
	}
	
	public void AllBlocks(List<UUID> players) {
		for(Integer ind = 0; ind < players.size(); ind++) {
			Player player = Bukkit.getPlayer(players.get(ind));
			PlayerBS pbs = this.main.playerbs.get(players.get(ind));
			if(pbs.isState(State.VIVANT)) {
			AllBlocks bloc = Alllist.get(random.nextInt(Alllist.size()));
			pbs.setBlockName(bloc.getName());
			pbs.setMaterial(bloc.getMaterial());    	
			pbs.setFinished(false);
			player.sendMessage("§bOn vous a attribué un nouveau bloc ! Celui est : §9" + pbs.getBlockName());
    		player.setPlayerListName("§7[" + pbs.getBlockName() + " | " + pbs.getPoints() + "§7] §c" + player.getName());
			}
		}
	}
}
