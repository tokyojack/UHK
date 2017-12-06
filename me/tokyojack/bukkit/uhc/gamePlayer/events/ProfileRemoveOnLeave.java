package me.tokyojack.mcmarket.uhc.gamePlayer.events;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

import me.tokyojack.mcmarket.uhc.UHC;
import me.tokyojack.mcmarket.uhc.gamePlayer.GamePlayerManager;

public class ProfileRemoveOnLeave implements Listener {

	@EventHandler
	public void playerJoin(PlayerQuitEvent event) {
		GamePlayerManager gamePlayerManager = UHC.getPlugin().getGamePlayerManager();
		gamePlayerManager.removeGamePlayer(event.getPlayer().getName());
	}

}
