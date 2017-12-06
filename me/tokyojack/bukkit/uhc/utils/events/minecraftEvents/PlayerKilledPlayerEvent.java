package me.tokyojack.mcmarket.uhc.utils.events.minecraftEvents;

import org.bukkit.Bukkit;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.EventHandler;
import org.bukkit.event.HandlerList;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class PlayerKilledPlayerEvent extends Event implements Listener {

	private static final HandlerList handlers = new HandlerList();

	private Player killer;
	private Player victim;

	public PlayerKilledPlayerEvent() {
		// For register
	}

	public PlayerKilledPlayerEvent(Player killer, Player victim) {
		this.killer = killer;
		this.victim = victim;
	}

	public Player getKiller() {
		return this.killer;
	}

	public Player getVictim() {
		return this.victim;
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
	public void playerDeath(PlayerDeathEvent event) {
		Entity killer = event.getEntity().getKiller();

		if (killer == null)
			return;

		if (!(killer instanceof Player))
			return;

		Player playerKiller = (Player) event.getEntity().getKiller();

		Bukkit.getPluginManager().callEvent(new PlayerKilledPlayerEvent(playerKiller, event.getEntity()));

	}
}