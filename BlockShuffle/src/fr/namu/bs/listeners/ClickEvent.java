package fr.namu.bs.listeners;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;

import fr.namu.bs.MainBS;

public class ClickEvent implements Listener {

	
	public ClickEvent(MainBS main) {
		
	}

	@EventHandler
	public void onClickEvent(InventoryClickEvent event) {
		Inventory inv = event.getInventory();
		
		if(inv.getName() != null && inv.getName() == "§7Voici votre bloc !") {
			event.setCancelled(true);
		}
	}
}
