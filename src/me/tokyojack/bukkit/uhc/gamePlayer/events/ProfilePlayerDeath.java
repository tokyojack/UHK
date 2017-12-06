package me.tokyojack.mcmarket.uhc.gamePlayer.events;

import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;

import me.tokyojack.mcmarket.uhc.UHC;
import me.tokyojack.mcmarket.uhc.gamePlayer.GamePlayerManager;
import me.tokyojack.mcmarket.uhc.utils.events.gameEvents.PlayerBecomeSpectatorEvent;

public class ProfilePlayerDeath implements Listener {

	@EventHandler
	public void playerDeath(PlayerDeathEvent event) {
		GamePlayerManager gamePlayerManager = UHC.getPlugin().getGamePlayerManager();
		gamePlayerManager.removeGamePlayer(event.getEntity().getName());
		Bukkit.getServer().getPluginManager().callEvent(new PlayerBecomeSpectatorEvent(event.getEntity()));
	}

}
