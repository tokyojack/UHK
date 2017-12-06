package me.tokyojack.mcmarket.uhc.world.events;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

import me.tokyojack.mcmarket.uhc.utils.Chat;

public class PlayerLeaveMessage implements Listener {

	@EventHandler
	public void playerJoin(PlayerQuitEvent event) {
		event.setQuitMessage(Chat.color("&7&oPlayer " + event.getPlayer().getName() + " has quit."));
	}
}
