package me.tokyojack.mcmarket.uhc.game.events;

import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

import me.tokyojack.mcmarket.uhc.Config;
import me.tokyojack.mcmarket.uhc.UHC;
import me.tokyojack.mcmarket.uhc.game.GameManager;
import me.tokyojack.mcmarket.uhc.game.objects.GameState;
import me.tokyojack.mcmarket.uhc.utils.Chat;
import me.tokyojack.mcmarket.uhc.utils.Countdown;

public class PlayerLeaveGame implements Listener {

	@EventHandler
	public void playerQuit(PlayerQuitEvent event) {
		int maxTotalPlayers = Config.MAX_TOTAL_GROUP_AMOUNT * Config.MAX_GROUP_MEMBER_AMOUNT;

		if (Bukkit.getOnlinePlayers().size() > maxTotalPlayers)
			return;

		Chat.broadcast("A player left, making timer stop");
		GameManager gameManager = UHC.getPlugin().getGameManager();
		gameManager.getGame().setGameState(GameState.WAITING);

		Countdown.STARTING.stop();

	}

}
