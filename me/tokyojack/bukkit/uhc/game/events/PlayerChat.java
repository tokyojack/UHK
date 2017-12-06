package me.tokyojack.mcmarket.uhc.game.events;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

import me.tokyojack.mcmarket.uhc.UHC;
import me.tokyojack.mcmarket.uhc.utils.Chat;

public class PlayerChat implements Listener {

	@EventHandler(ignoreCancelled = true)
	public void playerChat(AsyncPlayerChatEvent event) {
		// Team chatting
		if (Character.toString(event.getMessage().charAt(0)).equals("@"))
			return;

		// Dead/Spectator
		if (UHC.getPlugin().getGamePlayerManager().isDead(event.getPlayer().getName()))
			return;

		event.setFormat(Chat.color("&a" + event.getPlayer().getName() + ": &f" + event.getMessage()));

	}

}
