package me.tokyojack.mcmarket.uhc.scenario.events.Fireless;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityDamageEvent.DamageCause;

public class PlayerTakeFireDamage implements Listener {

	@EventHandler(ignoreCancelled = true)
	public void entityDamageEvent(EntityDamageEvent event) {
		if (!(event.getEntity() instanceof Player))
			return;
		DamageCause damageCause = event.getCause();

		if (!(damageCause == DamageCause.FIRE || damageCause == DamageCause.FIRE_TICK))
			return;

		event.setCancelled(true);
	}

}
