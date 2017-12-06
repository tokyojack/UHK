package me.tokyojack.mcmarket.uhc.game.events;

import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import me.tokyojack.mcmarket.uhc.Config;
import me.tokyojack.mcmarket.uhc.UHC;
import me.tokyojack.mcmarket.uhc.game.GameManager;

public class PlayerJoinGame implements Listener {

	@EventHandler
	public void playerJoin(PlayerJoinEvent event) {
		event.setJoinMessage(null);
		GameManager gameManager = UHC.getPlugin().getGameManager();

		if (gameManager.getGame().isIngame()) {
			event.getPlayer().kickPlayer("Sorry, the game is full!");
			return;
		}

		UHC.getPlugin().getGroupManager().addPlayerToOpenGroup(event.getPlayer().getName());
		int max = Config.MAX_TOTAL_GROUP_AMOUNT * Config.MAX_GROUP_MEMBER_AMOUNT;
		if (Bukkit.getOnlinePlayers().size() >= max)
			UHC.getPlugin().getGameManager().startGame();

	}
}
