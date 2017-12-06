package me.tokyojack.mcmarket.uhc.scenario.events.CutClean;

import java.util.HashMap;
import java.util.Map;

import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.inventory.ItemStack;

import me.tokyojack.mcmarket.uhc.UHC;
import me.tokyojack.mcmarket.uhc.scenario.objects.Scenario;

public class OreBreakSmelt implements Listener {

	@SuppressWarnings("serial")
	private final Map<Material, Material> ORES = new HashMap<Material, Material>() {
		{
			put(Material.IRON_ORE, Material.IRON_INGOT);
			put(Material.GOLD_ORE, Material.GOLD_INGOT);
			put(Material.QUARTZ_ORE, Material.QUARTZ);
		}
	};

	// TODO Change to event.getBlock().getDrops?
	@EventHandler(ignoreCancelled = true)
	public void blockBreak(BlockBreakEvent event) {
		if (!this.ORES.containsKey(event.getBlock().getType()))
			return;

		Material cookedItem = this.ORES.get(event.getBlock().getType());

		event.setCancelled(true);
		event.getBlock().setType(Material.AIR);

		if (UHC.getPlugin().getScenarioManager().containsScenario(Scenario.TRIPLEORE)) {
			for (int i = 0; i < 3; i++) {
				event.getBlock().getWorld().dropItem(event.getBlock().getLocation(), new ItemStack(cookedItem));
			}
		} else {
			//Normal
			event.getBlock().getWorld().dropItem(event.getBlock().getLocation(), new ItemStack(cookedItem));
		}
	}
}
