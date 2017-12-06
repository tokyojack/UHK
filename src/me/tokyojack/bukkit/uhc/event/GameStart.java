package me.tokyojack.mcmarket.uhc.event;

import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

import me.tokyojack.mcmarket.uhc.Config;
import me.tokyojack.mcmarket.uhc.UHC;
import me.tokyojack.mcmarket.uhc.utils.events.gameEvents.GameStartEvent;

public class GameStart implements Listener {

	@EventHandler
	public void gameStart(GameStartEvent event) {
		Bukkit.getOnlinePlayers()
				.forEach(player -> player.teleport(Bukkit.getWorld(Config.WORLD_NAME).getSpawnLocation().add(0, 1, 0)));
		UHC.getPlugin().getGameManager().startGrace();
	}

}
