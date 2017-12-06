package me.tokyojack.mcmarket.uhc.scenario.events.NoFall;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;

public class PlayerFallDamage implements Listener {

	@EventHandler(ignoreCancelled = true)
	public void entityDamageEvent(EntityDamageEvent event) {
		if (!(event.getEntity() instanceof Player))
			return;
		if (event.getCause() != EntityDamageEvent.DamageCause.FALL)
			return;
		event.setCancelled(true);
	}
}
