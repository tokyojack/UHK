package me.tokyojack.mcmarket.uhc.utils.events.gameEvents;

import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

import lombok.Getter;

@Getter
public class PlayerBecomeSpectatorEvent extends Event{
	
	Player player;
	
	public PlayerBecomeSpectatorEvent(Player player){
		this.player = player;
	}
	
	private static final HandlerList handlers = new HandlerList();

	public HandlerList getHandlers() {
		return handlers;
	}

	public static HandlerList getHandlerList() {
		return handlers;
	}
}
