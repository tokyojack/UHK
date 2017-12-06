package me.tokyojack.mcmarket.uhc.gamePlayer.events;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import me.tokyojack.mcmarket.uhc.UHC;
import me.tokyojack.mcmarket.uhc.gamePlayer.GamePlayerManager;

public class ProfileCreateOnJoin implements Listener {

	@EventHandler
	public void playerJoin(PlayerJoinEvent event) {
		GamePlayerManager gamePlayerManager = UHC.getPlugin().getGamePlayerManager();
		gamePlayerManager.addPlayer(event.getPlayer().getName());
	}

}
