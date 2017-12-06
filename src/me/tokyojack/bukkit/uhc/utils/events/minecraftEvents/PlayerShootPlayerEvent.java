package me.tokyojack.mcmarket.uhc.utils.events.minecraftEvents;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.entity.Projectile;
import org.bukkit.event.Event;
import org.bukkit.event.EventHandler;
import org.bukkit.event.HandlerList;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class PlayerShootPlayerEvent extends Event implements Listener {

	private static final HandlerList handlers = new HandlerList();

	private Player damager;
	private Player victim;
	private Projectile projectile;
	private EntityDamageByEntityEvent event;

	public PlayerShootPlayerEvent() {
		// For register
	}

	public PlayerShootPlayerEvent(Player damager, Player victim, Projectile projectile,
			EntityDamageByEntityEvent event) {
		this.damager = damager;
		this.victim = victim;
		this.projectile = projectile;
		this.event = event;
	}

	public Player getDamager() {
		return this.damager;
	}

	public Player getVictim() {
		return this.victim;
	}

	public Projectile getProjectile() {
		return this.projectile;
	}

	public void setCancelled(boolean bool) {
		this.event.setCancelled(true);
	}

	public void setDamage(double amount) {
		event.setDamage(amount);
	}

	public double getDamage() {
		return event.getDamage();
	}

	@Override
	public HandlerList getHandlers() {
		return handlers;
	}

	public static HandlerList getHandlerList() {
		return handlers;
	}

	public void registerListener(JavaPlugin plugin) {
		Bukkit.getPluginManager().registerEvents(this, plugin);
	}

	@EventHandler(ignoreCancelled = true)
	public void entityDamageEntity(EntityDamageByEntityEvent event) {
		if (!(event.getEntity() instanceof Player))
			return;

		if (!(event.getDamager() instanceof Projectile))
			return;

		Player victim = (Player) event.getEntity();
		Projectile projectile = (Projectile) event.getDamager();

		if (!(projectile.getShooter() instanceof Player))
			return;

		Player damager = (Player) projectile.getShooter();

		Bukkit.getPluginManager().callEvent(new PlayerShootPlayerEvent(damager, victim, projectile, event));
	}
}