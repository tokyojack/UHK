package me.tokyojack.mcmarket.uhc.world.qualityOfGameplay;

import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.ItemSpawnEvent;

public class PotionRemove implements Listener {

	@EventHandler
	public void onItemSpawn(ItemSpawnEvent event) {
		boolean n = event.getEntity().getItemStack().getType() == Material.GLASS_BOTTLE;
		if (n == true) {
			event.getEntity().remove();
		}
	}

}
