package me.tokyojack.mcmarket.uhc.gamePlayer.events.score;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

import me.tokyojack.mcmarket.uhc.UHC;
import me.tokyojack.mcmarket.uhc.utils.events.minecraftEvents.PlayerKilledPlayerEvent;

public class PlayerKillPointIncrease implements Listener {

	@EventHandler
	public void playerKilledPlayer(PlayerKilledPlayerEvent event){
		UHC.getPlugin().getGamePlayerManager().getGamePlayer(event.getKiller().getName()).addKill();
	}
	
}
