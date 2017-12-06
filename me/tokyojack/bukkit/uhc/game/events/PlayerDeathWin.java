package me.tokyojack.mcmarket.uhc.game.events;

import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

import me.tokyojack.mcmarket.uhc.UHC;
import me.tokyojack.mcmarket.uhc.group.GroupManager;
import me.tokyojack.mcmarket.uhc.utils.events.gameEvents.GameWinEvent;
import me.tokyojack.mcmarket.uhc.utils.events.minecraftEvents.PlayerKilledPlayerEvent;

public class PlayerDeathWin implements Listener{

	@EventHandler
	public void playerKilledPlayer(PlayerKilledPlayerEvent event) {
		GroupManager groupManager = UHC.getPlugin().getGroupManager();
		groupManager.removePlayerFromGroup(event.getVictim().getName());

		if (groupManager.getNumberOfGroupsLeft() <= 1)
			Bukkit.getServer().getPluginManager().callEvent(new GameWinEvent(groupManager.getWinningGroup()));		
	}
}
