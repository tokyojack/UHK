package me.tokyojack.mcmarket.uhc.event;

import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

import me.tokyojack.mcmarket.uhc.UHC;
import me.tokyojack.mcmarket.uhc.utils.events.gameEvents.GameCompleteEvent;

public class GameComplete implements Listener{

	@EventHandler
	public void gameComplete(GameCompleteEvent event) {
		Bukkit.getOnlinePlayers().forEach(player -> player.kickPlayer("Game done"));
		UHC.getPlugin().getGamePlayerManager().saveAll();
	}

}
