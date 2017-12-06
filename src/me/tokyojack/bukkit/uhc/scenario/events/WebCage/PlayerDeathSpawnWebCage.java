package me.tokyojack.mcmarket.uhc.scenario.events.WebCage;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;

public class PlayerDeathSpawnWebCage implements Listener {

	@EventHandler
	public void playerDeath(PlayerDeathEvent event) {
		Block block = event.getEntity().getLocation().getBlock();

		int radius = 1;
		for (int x = -radius; x <= radius; x++) {
			for (int y = -(radius - 1); y <= (radius + 1); y++) {
				for (int z = -radius; z <= radius; z++) {
					Block newBlock = block.getRelative(x, y, z);
					// For Timb Bomb Scenario
					if (newBlock.getType() == Material.CHEST)
						continue;
					block.getRelative(x, y, z).setType(Material.WEB);
				}
			}
		}
	}
}
