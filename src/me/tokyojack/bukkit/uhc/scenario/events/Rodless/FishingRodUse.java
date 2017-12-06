package me.tokyojack.mcmarket.uhc.scenario.events.Rodless;

import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

import me.tokyojack.mcmarket.uhc.utils.Chat;

public class FishingRodUse implements Listener {

	@EventHandler(ignoreCancelled = true)
	public void fishingRodUse(PlayerInteractEvent event) {
		if (event.getItem() == null)
			return;

		if (event.getItem().getType() != Material.FISHING_ROD)
			return;

		Action action = event.getAction();

		if (!(action == Action.RIGHT_CLICK_AIR || action == Action.RIGHT_CLICK_BLOCK))
			return;

		event.getPlayer().sendMessage(Chat.clear("You cannot use a fishing rod"));
		event.setCancelled(true);
	}

}
