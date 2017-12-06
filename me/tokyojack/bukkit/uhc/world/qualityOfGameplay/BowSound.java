package me.tokyojack.mcmarket.uhc.world.qualityOfGameplay;

import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

import me.tokyojack.mcmarket.uhc.utils.events.minecraftEvents.PlayerShootPlayerEvent;

public class BowSound implements Listener {

	@EventHandler
	public void onHit(PlayerShootPlayerEvent event) {
		Player damager = event.getDamager();
		damager.playSound(damager.getLocation(), Sound.ITEM_PICKUP, 1, 4);
	}

}
