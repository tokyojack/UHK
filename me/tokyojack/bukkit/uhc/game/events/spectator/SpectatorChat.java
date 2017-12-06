package me.tokyojack.mcmarket.uhc.game.events.spectator;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

import me.tokyojack.mcmarket.uhc.UHC;
import me.tokyojack.mcmarket.uhc.gamePlayer.GamePlayerManager;
import me.tokyojack.mcmarket.uhc.utils.Chat;

public class SpectatorChat implements Listener {

	@EventHandler(ignoreCancelled = true)
	public void playerChat(AsyncPlayerChatEvent event) {
		Player player = event.getPlayer();
		GamePlayerManager gamePlayerManager = UHC.getPlugin().getGamePlayerManager();

		// Is dead
		if (!UHC.getPlugin().getGamePlayerManager().isDead(player.getName()))
			return;

		event.setCancelled(true);

		if (Character.toString(event.getMessage().charAt(0)).equals("@")) {
			player.sendMessage(Chat.color("You cannot send messages to your group while dead"));
			return;
		}

		String message = Chat.color("&7[SPECTATOR] " + player.getName() + ": &f" + event.getMessage());

		gamePlayerManager.getDeadPlayers().stream().map(deadGamePlayer -> Bukkit.getPlayer(deadGamePlayer.getName()))
				.forEach(deadPlayer -> deadPlayer.sendMessage(message));
	}

}
