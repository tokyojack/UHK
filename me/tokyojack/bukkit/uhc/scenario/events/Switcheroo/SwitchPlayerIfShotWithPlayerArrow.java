package me.tokyojack.mcmarket.uhc.scenario.events.Switcheroo;

import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

import me.tokyojack.mcmarket.uhc.utils.events.minecraftEvents.PlayerShootPlayerEvent;

public class SwitchPlayerIfShotWithPlayerArrow implements Listener {

	@EventHandler
	public void arrowHitPlayer(PlayerShootPlayerEvent event) {	
		Player victim = event.getVictim();
		Player damager = event.getDamager();

		Location victimLocation = victim.getLocation().clone();
		Location playerShooterLocation = damager.getLocation().clone();

		victim.teleport(playerShooterLocation);
		damager.teleport(victimLocation);

	}

}
