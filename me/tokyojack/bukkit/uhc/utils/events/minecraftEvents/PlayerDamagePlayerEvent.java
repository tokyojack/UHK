package me.tokyojack.mcmarket.uhc.utils.events.minecraftEvents;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.EventHandler;
import org.bukkit.event.HandlerList;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class PlayerDamagePlayerEvent extends Event implements Listener {

	private static final HandlerList handlers = new HandlerList();

	private Player damager;
	private Player victim;
	private EntityDamageByEntityEvent event;

	public PlayerDamagePlayerEvent() {
		// For register
	}

	public PlayerDamagePlayerEvent(Player damager, Player victim, EntityDamageByEntityEvent event) {
		this.damager = damager;
		this.victim = victim;
		this.event = event;
	}

	public Player getDamager() {
		return this.damager;
	}

	public Player getVictim() {
		return this.victim;
	}

	public void setCancelled(boolean bool) {
		this.event.setCancelled(true);
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
		if (!(event.getDamager() instanceof Player))
			return;

		if (!(event.getEntity() instanceof Player))
			return;

		Player damager = (Player) event.getDamager();
		Player victim = (Player) event.getEntity();

		Bukkit.getPluginManager().callEvent(new PlayerDamagePlayerEvent(damager, victim, event));

	}

}