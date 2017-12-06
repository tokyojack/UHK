package me.tokyojack.mcmarket.uhc.event;

import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

import me.tokyojack.mcmarket.uhc.Config;
import me.tokyojack.mcmarket.uhc.UHC;
import me.tokyojack.mcmarket.uhc.group.objects.Group;
import me.tokyojack.mcmarket.uhc.utils.events.gameEvents.GameWinEvent;

public class GameWin implements Listener {

	@EventHandler
	public void gameWin(GameWinEvent event){
		Group winningGroup = event.getWinningGroup();
		winningGroup.getMembers().forEach(playerName -> Bukkit.getWorld(Config.WORLD_NAME).strikeLightning(Bukkit.getPlayer(playerName).getLocation()));
		UHC.getPlugin().getGameManager().endGame();
		UHC.getPlugin().getWorldBorderManager().stop();
	}
	
}
