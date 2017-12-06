package me.tokyojack.mcmarket.uhc.scenario.events.LuckyLeaves;

import java.util.Random;

import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.LeavesDecayEvent;
import org.bukkit.inventory.ItemStack;

public class LeaveFadeDropApple implements Listener {

	@EventHandler(ignoreCancelled = true)
	public void leaveDecay(LeavesDecayEvent event) {
		if (RandomNumber(100) > 3) // 3%
			return;

		event.getBlock().getWorld().dropItem(event.getBlock().getLocation(), new ItemStack(Material.GOLDEN_APPLE));
	}

	private int RandomNumber(int s) {
		return new Random().nextInt(s) + 1;
	}
}
