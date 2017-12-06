package me.tokyojack.mcmarket.uhc.scenario.events.Barebone;

import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;

import me.tokyojack.mcmarket.uhc.utils.Chat;

public class DiamondAndGoldBreak implements Listener {

	@EventHandler(ignoreCancelled = true)
	public void blockBreak(BlockBreakEvent event) {
		if (!(event.getBlock().getType() == Material.DIAMOND_ORE || event.getBlock().getType() == Material.DIAMOND_ORE))
			return;
		
		event.setCancelled(true);
		event.getBlock().setType(Material.AIR);
		
		event.getPlayer().sendMessage(Chat.color("You cannot mine diamond/gold"));
	}
}
