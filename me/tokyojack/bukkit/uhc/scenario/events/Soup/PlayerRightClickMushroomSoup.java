package me.tokyojack.mcmarket.uhc.scenario.events.Soup;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

public class PlayerRightClickMushroomSoup implements Listener {

	@EventHandler
	public void playerInteract(PlayerInteractEvent event) {
		if (event.getItem() == null)
			return;

		if (event.getItem().getType() != Material.MUSHROOM_SOUP)
			return;

		Action action = event.getAction();

		if (!(action == Action.RIGHT_CLICK_AIR || action == Action.RIGHT_CLICK_BLOCK))
			return;

		Player player = event.getPlayer();

		event.setCancelled(true);
		player.setItemInHand(new ItemStack(Material.BOWL));

		healPlayer(3.5, player);
	}

	private void healPlayer(double hearts, Player player) {
		double healingAmount = (player.getHealth() + (hearts * 2)) > 20.0 ? 20.0 : player.getHealth() + (hearts * 2);
		player.setHealth(healingAmount);
	}
}
