package me.tokyojack.mcmarket.uhc.gamePlayer.events.score;

import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerItemConsumeEvent;
import org.bukkit.inventory.ItemStack;

import me.tokyojack.mcmarket.uhc.UHC;

public class GappleEat implements Listener {

	@EventHandler(ignoreCancelled = true)
	public void gappleEat(PlayerItemConsumeEvent event) {
		ItemStack item = event.getItem();
		if (item.getType() != Material.GOLDEN_APPLE)
			return;

		//Maybe just enchanted apples?
		UHC.getPlugin().getGamePlayerManager().getGamePlayer(event.getPlayer().getName()).addGappleEaten();

	}

}
