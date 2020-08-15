package fr.namu.bs.commandbs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabExecutor;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import fr.namu.bs.MainBS;
import fr.namu.bs.PlayerBS;
import fr.namu.bs.enumbs.StateBS;

public class BlockCMD implements TabExecutor {
	private MainBS main;
	
	public BlockCMD(MainBS main) {
		this.main = main;
	}

	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		Player player = (Player)sender;
		
		if(!this.main.isState(StateBS.GAME)) {
			player.sendMessage("§cLa partie n'a pas encore commencé !");
			return true;
		}
		PlayerBS pbs = this.main.playerbs.get(player.getUniqueId());
		
		if(pbs.getMaterial() == Material.DRAGON_EGG) {
			player.sendMessage("§cOn ne vous a pas encore attribué de bloc !");
			return true;
		}
		
		Inventory inv = Bukkit.createInventory(null, InventoryType.DISPENSER, "§7Voici votre bloc !");
		inv.setItem(4, new ItemStack(pbs.getMaterial(), 1));
		player.openInventory(inv);
		
		return true;
	}
	
	public List<String> onTabComplete(CommandSender commandSender, Command command, String s, String[] args) {
	    String[] tabe = {};
	    List<String> tab = new ArrayList<>(Arrays.asList(tabe));
	    if (args.length == 0)
	      return tab; 
	    if (args.length == 1) {
	      for (int i = 0; i < tab.size(); i++) {
	        for (int j = 0; j < ((String)tab.get(i)).length() && j < args[0].length(); j++) {
	          if (((String)tab.get(i)).charAt(j) != args[0].charAt(j)) {
	            tab.remove(i);
	            i--;
	            break;
	          } 
	        } 
	      } 
	      return tab;
	    } 
	    return null;
	  }
}
