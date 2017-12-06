package me.tokyojack.mcmarket.uhc.scenario.events.Bowless;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityShootBowEvent;

import me.tokyojack.mcmarket.uhc.utils.Chat;

public class StopBowFromShooting implements Listener {

	@EventHandler(ignoreCancelled = true)
	public void playerBowShoot(EntityShootBowEvent event) {
		if (!(event.getEntity() instanceof Player))
			return;

		event.setCancelled(true);
		((Player) event.getEntity()).sendMessage(Chat.color("You cannot fire bows."));

	}
}
