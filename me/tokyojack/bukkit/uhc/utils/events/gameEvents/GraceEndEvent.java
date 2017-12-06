package me.tokyojack.mcmarket.uhc.utils.events.gameEvents;

import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

public class GraceEndEvent extends Event{
	public GraceEndEvent(){
		
	}
	
	private static final HandlerList handlers = new HandlerList();

	public HandlerList getHandlers() {
		return handlers;
	}

	public static HandlerList getHandlerList() {
		return handlers;
	}
}
