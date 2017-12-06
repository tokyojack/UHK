package me.tokyojack.mcmarket.uhc.game.events.lobby;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.CreatureSpawnEvent;

import me.tokyojack.mcmarket.uhc.UHC;

public class NoMobSpawnWhileWaiting implements Listener {

	@EventHandler
	public void onCreateSpawn(CreatureSpawnEvent event) {
		if (UHC.getPlugin().getGameManager().getGame().isIngame())
			return;

		event.setCancelled(true);
	}
}
