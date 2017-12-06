package me.tokyojack.mcmarket.uhc.world.events;

import org.bukkit.entity.EntityType;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.CreatureSpawnEvent;

public class NoWitherSpawn implements Listener {

	@EventHandler
	public void onCreateSpawn(CreatureSpawnEvent event) {
		if (event.getEntity().getType() == EntityType.WITHER) {
			event.setCancelled(true);
		}
	}

}
