package fr.namu.bs.commandbs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabExecutor;
import org.bukkit.entity.Player;
import fr.namu.bs.MainBS;

public class RulesCMD implements TabExecutor {
	public RulesCMD(MainBS main) {
	}

	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		Player player = (Player)sender;		
				
		player.sendMessage("    §7■ §9§lBlock §eShuffle §7■");
		player.sendMessage("§eLe §9BlockShuffle §eest un mini-jeu originellement inventé par §aDream§e, un Youtubeur Minecraft renommé aux États-Unis. Dans notre version de ce Mini-Jeu, au bout de chaque manche (celles-ci durant"
				+ " 4 minutes), un §abloc vous sera attribué §e(que vous pouvez voir avec §7/block§e), et vous devez ainsi vous placer au dessus le plus rapidement possible. Ceux-ci vont §augmenter en difficulté §eau fur et à mesure que la "
				+ "partie se déroule, pouvant aller d'un simple bloc de neige à un bloc d'Or. Plus vous parviendrez à trouver votre bloc au plus vite, plus §ale nombre de points qui vous sera attribué sera grand §e!"
				+ " L'objectif final étant §a200 points§e, le plus rapide à atteindre ce résultat gagnera la partie ! Si vous voulez avoir un oeil sur les objectifs et les points de vos amis, tout est renseigné "
				+ "dans la §aliste des joueurs§e.");
		
		
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
