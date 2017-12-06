package me.tokyojack.mcmarket.uhc.utils.events.gameEvents;

import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

import lombok.Getter;
import me.tokyojack.mcmarket.uhc.group.objects.Group;

@Getter
public class GameWinEvent extends Event {

	private Group winningGroup;

	public GameWinEvent(Group winningGroup) {
		this.winningGroup = winningGroup;
	}

	private static final HandlerList handlers = new HandlerList();

	public HandlerList getHandlers() {
		return handlers;
	}

	public static HandlerList getHandlerList() {
		return handlers;
	}
}
