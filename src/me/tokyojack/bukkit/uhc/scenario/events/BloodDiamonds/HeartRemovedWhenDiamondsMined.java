package me.tokyojack.mcmarket.uhc.scenario.events.BloodDiamonds;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;

public class HeartRemovedWhenDiamondsMined implements Listener {

	@EventHandler(ignoreCancelled = true)
	public void blockBreak(BlockBreakEvent event) {
		if (event.getBlock().getType() != Material.DIAMOND_ORE)
			return;

		Player player = event.getPlayer();
		player.sendMessage("You've lost half a heart because you've mined a diamond.");
		player.setMaxHealth(player.getMaxHealth() - 0.5);
	}

}
