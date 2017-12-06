package me.tokyojack.mcmarket.uhc.scenario.events.TimeBomb;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.block.Chest;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import me.tokyojack.mcmarket.uhc.UHC;

public class PlaceChestOnDeath implements Listener {

	// TODO Maybe make the armour/hotbar on the lowest slot?

	@EventHandler
	public void playerDeath(PlayerDeathEvent event) {
		Player player = event.getEntity();

		player.getLocation().getBlock().setType(Material.CHEST);
		player.getLocation().add(0, 0, 1).getBlock().setType(Material.CHEST);
		// TODO find open space beisde main

		Chest chest = (Chest) player.getLocation().getBlock().getState();
		Inventory chestInventory = chest.getInventory();

		for (int i = 0; i < event.getDrops().size(); i++) {
			ItemStack item = event.getDrops().get(i);
			if (item == null)
				continue;

			chestInventory.setItem(i, item);
		}

		chest.update();
		
		event.getDrops().clear();

		Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(UHC.getPlugin(), new Runnable() {
			@Override
			public void run() {
				chestInventory.clear();
				chest.getWorld().createExplosion(chest.getLocation(), 5);
			}
		}, 20 * 30);
	}
}
