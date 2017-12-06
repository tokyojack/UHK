package me.tokyojack.mcmarket.uhc.scenario.events.Diamondless;

import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;

public class DiamondOreDropRemove implements Listener {

	@EventHandler(ignoreCancelled = true)
	public void diamondOreBreak(BlockBreakEvent event) {
		if (event.getBlock().getType() != Material.DIAMOND_ORE)
			return;
		
		event.setCancelled(true);
		event.getBlock().setType(Material.AIR);

		// TODO particle?
		// TODO check for explosions dropping it?
		
		event.getPlayer().sendMessage("Its Diamondless scenario :(");
	}

}
