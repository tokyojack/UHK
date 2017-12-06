package me.tokyojack.mcmarket.uhc.scenario.events.Longshot;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Arrow;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityShootBowEvent;
import org.bukkit.event.entity.ProjectileHitEvent;

import me.tokyojack.mcmarket.uhc.UHC;
import me.tokyojack.mcmarket.uhc.utils.Chat;
import me.tokyojack.mcmarket.uhc.utils.events.minecraftEvents.PlayerShootPlayerEvent;

public class LongDistanceShot implements Listener {

	private Map<UUID, Location> arrowDistances = new HashMap<UUID, Location>();

	@EventHandler
	public void playerBowShoot(EntityShootBowEvent event) {
		if (!(event.getEntity() instanceof Player))
			return;

		this.arrowDistances.put(event.getProjectile().getUniqueId(), event.getEntity().getLocation());
	}

	@EventHandler
	public void arrowHitPlayer(PlayerShootPlayerEvent event) {
		if (!(event.getProjectile() instanceof Arrow))
			return;

		Arrow arrow = (Arrow) event.getProjectile();

		if (!this.arrowDistances.containsKey(arrow.getUniqueId()))
			return;
		
		Player victim = event.getVictim();

		Double distance = victim.getLocation().distance(this.arrowDistances.get(arrow.getUniqueId()));

		if (distance <= 49.9)
			return;

		Player damager = event.getDamager();

		damager.sendMessage(Chat.color("You hit a player from 50 blocks away!"));

		if (damager.getHealth() <= 18)
			damager.setHealth(damager.getHealth() + 2);

		victim.sendMessage(Chat.color("You were hit by an arrow 50 blocks away!"));
		event.setDamage(event.getDamage() + (event.getDamage() * 0.5));
	}

	@EventHandler
	public void arrowHitPlayer(ProjectileHitEvent event) {
		if (!this.arrowDistances.containsKey(event.getEntity().getUniqueId()))
			return;

		Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(UHC.getPlugin(), new Runnable() {
			@Override
			public void run() {
				arrowDistances.remove(event.getEntity().getUniqueId());
			}
		}, 1);
		
	}
}
