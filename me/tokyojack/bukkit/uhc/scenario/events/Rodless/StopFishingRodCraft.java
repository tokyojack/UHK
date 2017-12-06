package me.tokyojack.mcmarket.uhc.scenario.events.Rodless;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.PrepareItemCraftEvent;
import org.bukkit.inventory.ItemStack;

import me.tokyojack.mcmarket.uhc.utils.Chat;

public class StopFishingRodCraft implements Listener {

	@EventHandler
	public void craftItem(PrepareItemCraftEvent event) {
		Material itemType = event.getRecipe().getResult().getType();

		if (itemType != Material.FISHING_ROD)
			return;
		event.getInventory().setResult(new ItemStack(Material.AIR));
		event.getViewers().forEach(viewer -> {
			if (viewer instanceof Player)
				((Player) viewer).sendMessage(Chat.color("You cannot craft the fishing rod!"));
		});
	}
}
