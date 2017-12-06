package me.tokyojack.mcmarket.uhc.scenario.events.Diamondless;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.inventory.ItemStack;

public class PlayerDropDiamondOnDeath implements Listener {
	
	@EventHandler
	public void playerDeath(PlayerDeathEvent event) {
		Player player = event.getEntity();
		player.getInventory().addItem(new ItemStack(Material.DIAMOND));
	}
	
}
