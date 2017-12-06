package me.tokyojack.mcmarket.uhc.scenario.events.TripleOres;

import java.util.Arrays;
import java.util.List;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;

public class OreTripleDropWhenBroken implements Listener {

	private final List<Material> ORES = Arrays.asList(Material.COAL_ORE, Material.IRON_ORE, Material.DIAMOND_ORE,
			Material.EMERALD_ORE, Material.GOLD_ORE, Material.LAPIS_ORE, Material.QUARTZ_ORE, Material.REDSTONE_ORE);

	@EventHandler(ignoreCancelled = true)
	public void blockBreak(BlockBreakEvent event) {
		if (!this.ORES.contains(event.getBlock().getType()))
			return;

		//TODO check for redstone
		
		Location loc = event.getBlock().getLocation();
		for (int i = 0; i < 2; i++) {
			event.getBlock().getDrops().forEach(drop -> event.getBlock().getWorld().dropItem(loc, drop));
		}
	}

}
