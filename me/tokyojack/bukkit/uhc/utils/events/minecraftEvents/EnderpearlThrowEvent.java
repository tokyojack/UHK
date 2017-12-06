package me.tokyojack.mcmarket.uhc.utils.events.minecraftEvents;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.EventHandler;
import org.bukkit.event.HandlerList;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;

import lombok.Getter;

@Getter
public class EnderpearlThrowEvent extends Event implements Listener {

	private static final HandlerList handlers = new HandlerList();

	private Player player;

	public EnderpearlThrowEvent() {
		// For register
	}

	public EnderpearlThrowEvent(Player player) {
		this.player = player;
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

	@EventHandler
	public void enderpearlUse(PlayerInteractEvent event) {
		ItemStack item = event.getItem();
		if (!event.hasItem())
			return;

		if (item.getType() != Material.ENDER_PEARL)
			return;

		if (event.getPlayer().getGameMode() != GameMode.SURVIVAL)
			return;

		Action action = event.getAction();

		if (!(action == Action.RIGHT_CLICK_AIR || action == Action.RIGHT_CLICK_BLOCK))
			return;

		Bukkit.getPluginManager().callEvent(new EnderpearlThrowEvent(event.getPlayer()));

	}

}